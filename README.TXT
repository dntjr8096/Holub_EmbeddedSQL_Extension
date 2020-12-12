# Holub SQL Extension

### 디렉토릭 구조
```
├─database
│  │  checklist
│  │  ConcreteTable.java
│  │  ConcreteTable.test.out
│  │  CSVExporter.java
│  │  CSVImporter.java
│  │  Cursor.java
│  │  Database.java
│  │  Database.test.out
│  │  Database.test.sql
│  │  Database.testdatabases.out
│  │  JTableExporter.java
│  │  makedoc.ksh
│  │  makedoc.out
│  │  makejar.ksh
│  │  people
│  │  Selector.java
│  │  Table.java
│  │  TableFactory.java
│  │  test.ksh
│  │  UnmodifiableTable.java
│  │
│  ├─Dbase
│  │      address.csv
│  │      existing.csv
│  │      existing_copy.csv
│  │      existing_copy.template
│  │      name.csv
│  │
│  └─jdbc
│      │  Console.java
│      │  JDBCConnection.java
│      │  JDBCDriver.java
│      │  JDBCResultSet.java
│      │  JDBCResultSetMetaData.java
│      │  JDBCStatement.java
│      │  JDBCTest.java
│      │
│      ├─adapters
│      │      ConnectionAdapter.java
│      │      ResultSetAdapter.java
│      │      ResultSetMetaDataAdapter.java
│      │      StatementAdapter.java
│      │
│      └─Dbase
│              test
│
├─text
│      BeginToken.java
│      ParseFailure.java
│      RegexToken.java
│      Scanner.java
│      SimpleToken.java
│      Token.java
│      TokenSet.java
│      WordToken.java
│
└─tools
        ArrayIterator.java
        ThrowableContainer.java
``` 

HolubSQL.jar
Version 1.0
Released 27 Sept., 2004

/*  (c) 2004 Allen I. Holub. All rights reserved.
 *
 *  This code may be used freely by yourself with the following
 *  restrictions:
 *
 *  o Your splash screen, about box, or equivalent, must include
 *    Allen Holub's name, copyright, and URL. For example:
 *
 *      This program contains Allen Holub's SQL package.<br>
 *      (c) 2005 Allen I. Holub. All Rights Reserved.<br>
 *              http://www.holub.com<br>
 *
 *    If your program does not run interactively, then the foregoing
 *    notice must appear in your documentation.
 *
 *  o You may not redistribute (or mirror) the source code.
 *
 *  o You must report any bugs that you find to me. Use the form at
 *    http://www.holub.com/company/contact.html or send email to
 *    allen@Holub.com.
 *
 *  o The software is supplied <em>as is</em>. Neither Allen Holub nor
 *    Holub Associates are responsible for any bugs (or any problems
 *    caused by bugs, including lost productivity or data)
 *    in any of this code.
 */
