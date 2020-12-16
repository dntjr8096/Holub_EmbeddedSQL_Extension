package com.holub.database;

import java.io.IOException;

public interface Element {
    void accept(ExporterVisitor exporterVisitor) throws IOException;
}
