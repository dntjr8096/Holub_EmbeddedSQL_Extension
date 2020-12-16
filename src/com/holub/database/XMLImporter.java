package com.holub.database;

import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLImporter implements Table.Importer {
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder documentBuilder = null;
    private Document document = null;
    private BufferedReader in;
    private InputSource is;
    private String[] columnNames;
    private String tableName;
    private int rowNum = 0;
    private int pos = 0;

    public XMLImporter(Reader in) {
        this.in = in instanceof BufferedReader
                ? (BufferedReader) in
                : new BufferedReader(in)
        ;

        try {
            is = new InputSource(this.in);
            documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(is);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startTable() throws IOException {
        Element root = document.getDocumentElement();
        Element table = (Element) root.getElementsByTagName("table").item(0);
        tableName = table.getAttribute("name");

        NodeList rows = document.getElementsByTagName("row");
        rowNum = rows.getLength();

        ArrayList<String> cols = new ArrayList<>();
        for (Node node = rows.item(0).getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node.getNodeType() == Node.ELEMENT_NODE)
                cols.add(node.getNodeName());
        }
        columnNames = cols.toArray(new String[cols.size()]);
    }

    @Override
    public String loadTableName() throws IOException {
        return tableName;
    }

    @Override
    public int loadWidth() throws IOException {
        return columnNames.length;
    }

    @Override
    public Iterator loadColumnNames() throws IOException {
        return new ArrayIterator(columnNames);
    }

    @Override
    public Iterator loadRow() throws IOException {
        if (rowNum <= pos)
            return null;

        NodeList rows = document.getElementsByTagName("row");
        ArrayList<String> rowDatas = new ArrayList<>();

        for (Node node = rows.item(pos).getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node.getNodeType() == Node.ELEMENT_NODE)
                rowDatas.add(node.getTextContent());
        }

        pos++;
        return rowDatas.iterator();
    }

    @Override
    public void endTable() throws IOException {

    }
}
