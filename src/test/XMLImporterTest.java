package test;

import com.holub.database.CSVImporter;
import com.holub.database.Table;
import com.holub.database.XMLImporter;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class XMLImporterTest {

    private XMLImporter xmlImporter;
    private String[] col, row;

    @BeforeAll
    void init() throws IOException {
        xmlImporter = new XMLImporter(new FileReader(new File("C:/dp2020/name.xml")));
        col = new String[]{"first", "last", "addrId"};
        row = new String[]{"Fred", "Flintstone", "1"};
    }


    @DisplayName("XML import 시작 테스트")
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ImportStart {
        @Test
        @DisplayName("테이블 제목은 ")
        void name() throws IOException {
            xmlImporter.startTable();
            assertEquals(xmlImporter.loadTableName(), "name");
        }

        @Test
        @DisplayName("테이블 컬럼들은 ")
        void columns() throws IOException{
            Iterator target = Arrays.stream(col).iterator();
            Iterator expected = xmlImporter.loadColumnNames();

            while(expected.hasNext())
                assertEquals(expected.next().toString(), target.next().toString());
        }
    }

    @Test
    @DisplayName("row 1줄은")
    void row() throws IOException {
        xmlImporter.startTable();
        Iterator target = xmlImporter.loadRow();
        Iterator expected = Arrays.stream(row).iterator();

        while(expected.hasNext())
            assertEquals(expected.next().toString(), target.next().toString());
    }
}