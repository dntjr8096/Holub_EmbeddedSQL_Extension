package test;

import com.holub.database.Table;
import com.holub.database.TableFactory;
import com.holub.database.XMLExporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("XML Exporter Test 시작")
class XMLExporterTest {

    private Table nameTable;
    private Writer writer = new StringWriter();
    private XMLExporter xmlExporter = new XMLExporter(writer);
    private String[] col, row;

    @BeforeEach
    void init(){
        col = new String[]{"first", "last", "addrId"};
        row = new String[]{"test1", "test1", "1"};
        nameTable = TableFactory.create("name", col);
        nameTable.insert(row);
    }

    @Test
    @DisplayName("테이블 초기화 테스트")
    void startTable() throws IOException {
        xmlExporter.startTable();
        assertEquals(writer.toString(), "<?xml version=\"1.0\"?>\n<root>\n");
    }


    @Test
    @DisplayName("테이블 제목 테스트")
    void initTableName() throws IOException {
        xmlExporter.storeMetadata("person", 3, 1, Arrays.stream(col).iterator());
        assertEquals(writer.toString(), "\t<table name=\"person\">\n");
    }

    @Test
    @DisplayName("데이터 1줄 삽입 테스트")
    void insertRow() throws IOException {
        xmlExporter.storeMetadata("person", 3, 1, Arrays.stream(col).iterator());
        xmlExporter.storeRow(Arrays.stream(row).iterator());
        assertEquals(writer.toString(), "\t<table name=\"person\">\n" +
                "\t<row>\n" +
                "\t\t<first>test1</first>\n" +
                "\t\t<last>test1</last>\n" +
                "\t\t<addrId>1</addrId>\n" +
                "\t</row>\n");
    }

    @Test
    @DisplayName("XML 테이블 완성 결과 테스트")
    void exportXML() throws IOException {
        xmlExporter.startTable();
        xmlExporter.storeMetadata("person", 3, 1, Arrays.stream(col).iterator());
        xmlExporter.storeRow(Arrays.stream(row).iterator());
        xmlExporter.endTable();
        assertEquals(writer.toString(), "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "\t<table name=\"person\">\n" +
                "\t<row>\n" +
                "\t\t<first>test1</first>\n" +
                "\t\t<last>test1</last>\n" +
                "\t\t<addrId>1</addrId>\n" +
                "\t</row>\n" +
                "\t</table>\n" +
                "</root>");
    }
}