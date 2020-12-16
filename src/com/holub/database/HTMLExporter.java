package com.holub.database;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class HTMLExporter implements Table.Exporter, Element{
    private final Writer out;

    public HTMLExporter(Writer out) {
        this.out = out;
    }

    @Override
    public void startTable() throws IOException {
        out.write("<!DOCTYPE html>\n");
    }

    @Override
    public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
        out.write("<html>\n\t<head>\n\t\t<title>");
        out.write(tableName);
        out.write("</title>\n\t</head>\n\t<body>\n\t\t<table border=\"1\">\n");

        while (columnNames.hasNext()){
            Object column = columnNames.next();
            out.write("\t\t\t<th>");
            if(column != null)
                out.write(column.toString());
            out.write("</th>\n");
        }
    }

    @Override
    public void storeRow(Iterator data) throws IOException {
        out.write("\t\t\t<tr>\n");
        while(data.hasNext()){
            Object rowData = data.next();
            out.write("\t\t\t\t<td>");
            if( rowData != null )
                out.write(rowData.toString());
            out.write("</td>\n");
        }
        out.write("\t\t\t</tr>\n");

    }

    @Override
    public void endTable() throws IOException {
        out.write("\t\t</table>\n\t</body>\n</html>");
    }

    @Override
    public void accept(ExporterVisitor exporterVisitor) throws IOException {
        exporterVisitor.visitHTMLExporter(this);
    }
}
