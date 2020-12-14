package com.holub.database;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class HTMLExporter implements Table.Exporter{
    private final Writer out;

    public HTMLExporter(Writer out) {
        this.out = out;
    }

    @Override
    public void startTable() throws IOException {
        out.write("<!DOCTYPE html>");
    }

    @Override
    public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
        out.write("<html><head><title>");
        out.write(tableName);
        out.write("</title></head><body><table border=\"1\">");

        while (columnNames.hasNext()){
            Object column = columnNames.next();
            out.write("<th>");
            if(column != null)
                out.write(column.toString());
            out.write("</th>");
        }
    }

    @Override
    public void storeRow(Iterator data) throws IOException {
        out.write("<tr>");
        while(data.hasNext()){
            Object rowData = data.next();
            out.write("<td>");
            if( rowData != null )
                out.write(rowData.toString());
            out.write("</td>");
        }
        out.write("</tr>");

    }

    @Override
    public void endTable() throws IOException {
        out.write("</table></body></html>");
    }
}
