# Holub SQL Extension

### 디렉토릭 구조
```
src
├─database
│  │  checklist
│  │  ConcreteTable.java (Visitor이면서 테이블 1개를 나타냄)
│  │  ConcreteTable.test.out
│  │  CSVExporter.java
│  │  CSVImporter.java
│  │  Cursor.java
│  │  Database.java  (메모리에 적재된 모든 테이블들에 대한 정보를 들고있고, 기본적으로 csv 파일을 통해 테이블을 로드하고 csv 파일로 테이블 정보를 출력함)
│  │  Database.test.out
│  │  Database.test.sql
│  │  Database.testdatabases.out
│  │  Element.java  (Visitor 패턴에서 장소를 나타내는 클래스들을 위한 인터페이스)
│  │  ExporterVisitor.java (Visitor 패턴에서 방문자를 나타내는 클래스를 위한 인터페이스)
│  │  HTMLExporter.java  (테이블의 정보를 HTMLExporter를 통해서 Html 형식으로 작성할 수 있다. 또한, 방문 공간으로써의 역할도 한다)
│  │  JTableExporter.java
│  │  makedoc.ksh
│  │  makedoc.out
│  │  makejar.ksh
│  │  people
│  │  Selector.java
│  │  Table.java
│  │  TableFactory.java  (load함수를 통해 테이블을 로드하고 내부적으로는 Importer를 사용해 파일을 해석하고 테이블 정보를 불러온다)
│  │  test.ksh
│  │  UnmodifiableTable.java
│  │  XMLExporter.java  (HTMLExporter와 같이 XML 형식으로 테이블 정보를 파일로 출력할 수 있게한다)
│  │  XMLImporter.java  (테이블을 읽어들일 때 XMLImporter를 사용하면 .xml파일을 XML 형식으로 해석하고 테이블 정보를 읽어온다)
│  │
│  ├─Dbase
│  │      address.csv
│  │      existing.csv
│  │      existing_copy.csv
│  │      existing_copy.template
│  │      name.csv
│  │
│  └─jdbc
│      │  Console.java (메인 화면 실행에 관련된 내용들을 수행한다. ex) dbConnection, statement Get)
│      │  JDBCConnection.java
│      │  JDBCDriver.java
│      │  JDBCResultSet.java
│      │  JDBCResultSetMetaData.java
│      │  JDBCStatement.java (명령어를 처리한다. 내부적으로 Database에게 일정 부분을 위임하여 작업을 수행한다)
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
