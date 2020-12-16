package test;

import com.holub.database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("방문자 패턴 테스트는")
class VisitorTest {
    TableFactory tableFactory = new TableFactory();
    Table nameTable;

    @BeforeEach
    void init() throws IOException {
        nameTable = tableFactory.load("name.csv", new File("."));
    }

    @Test
    @DisplayName("HTML Exporter 방문 테스트는")
    void visitHTMLExporter() throws IOException{
        Writer out = new StringWriter();
        HTMLExporter htmlExporter = new HTMLExporter(out);
        ((ConcreteTable)nameTable).visitHTMLExporter(htmlExporter);

        assertEquals(out.toString(), "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<title>name</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<table border=\"1\">\n" +
                "\t\t\t<th>first</th>\n" +
                "\t\t\t<th>last</th>\n" +
                "\t\t\t<th>addrId</th>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Fred</td>\n" +
                "\t\t\t\t<td>Flintstone</td>\n" +
                "\t\t\t\t<td>1</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Wilma</td>\n" +
                "\t\t\t\t<td>Flintstone</td>\n" +
                "\t\t\t\t<td>1</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Allen</td>\n" +
                "\t\t\t\t<td>Holub</td>\n" +
                "\t\t\t\t<td>0</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table>\n" +
                "\t</body>\n" +
                "</html>");
    }

    @Test
    @DisplayName("XML Exporter 방문 테스트는")
    void visitXMLExporter() throws IOException{
        Writer out = new StringWriter();
        XMLExporter xmlExporter = new XMLExporter(out);
        ((ConcreteTable)nameTable).visitXMLExporter(xmlExporter);

        assertEquals(out.toString(), "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "\t<table name=\"name\">\n" +
                "\t<row>\n" +
                "\t\t<first>Fred</first>\n" +
                "\t\t<last>Flintstone</last>\n" +
                "\t\t<addrId>1</addrId>\n" +
                "\t</row>\n" +
                "\t<row>\n" +
                "\t\t<first>Wilma</first>\n" +
                "\t\t<last>Flintstone</last>\n" +
                "\t\t<addrId>1</addrId>\n" +
                "\t</row>\n" +
                "\t<row>\n" +
                "\t\t<first>Allen</first>\n" +
                "\t\t<last>Holub</last>\n" +
                "\t\t<addrId>0</addrId>\n" +
                "\t</row>\n" +
                "\t</table>\n" +
                "</root>");
    }
}