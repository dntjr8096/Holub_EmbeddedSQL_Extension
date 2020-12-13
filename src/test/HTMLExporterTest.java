package test;

import com.holub.database.HTMLExporter;
import com.holub.database.Table;
import com.holub.database.TableFactory;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HTML Exporter test 시작")
class HTMLExporterTest {

    private Table nameTable;
    private Writer writer = new StringWriter();
    private HTMLExporter htmlExporter = new HTMLExporter(writer);
    private String[] col, row;

    @BeforeEach
    void init(){
        col = new String[]{"first", "last", "addrId"};
        row = new String[]{"test1", "test1", "1"};
        nameTable = TableFactory.create("name", col);
        nameTable.insert(row);
    }

    @DisplayName("테이블 만들기 시작")
    @Test
    void startTable() throws IOException {
       htmlExporter.startTable();
       assertEquals(writer.toString(), "<!DOCTYPE html>");
    }

    @DisplayName("테이블 완성 결과 확인")
    @Test
    void exportHTML() throws IOException {
        htmlExporter.startTable();
        htmlExporter.storeMetadata("name", 3, 1, Arrays.stream(col).iterator());
        htmlExporter.storeRow(Arrays.stream(row).iterator());
        htmlExporter.endTable();
        assertEquals(writer.toString(), "<!DOCTYPE html><html><head><title>name</title></head><body><table border=\"1\"><th>first</th><th>last</th><th>addrId</th><tr><td>test1</td><td>test1</td><td>1</td></tr></table></body></html>");
    }
}