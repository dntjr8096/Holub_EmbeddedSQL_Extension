package com.holub.database;

import java.io.IOException;

public interface ExporterVisitor {
    void visitXMLExporter(XMLExporter xmlExporter) throws IOException;
    void visitHTMLExporter(HTMLExporter htmlExporter) throws IOException;
}
