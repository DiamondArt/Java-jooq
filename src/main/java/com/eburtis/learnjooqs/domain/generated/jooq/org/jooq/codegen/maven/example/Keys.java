/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.codegen.maven.example.tables.Author;
import org.jooq.codegen.maven.example.tables.AuthorBook;
import org.jooq.codegen.maven.example.tables.Book;
import org.jooq.codegen.maven.example.tables.FlywaySchemaHistory;
import org.jooq.codegen.maven.example.tables.records.AuthorBookRecord;
import org.jooq.codegen.maven.example.tables.records.AuthorRecord;
import org.jooq.codegen.maven.example.tables.records.BookRecord;
import org.jooq.codegen.maven.example.tables.records.FlywaySchemaHistoryRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> AUTHOR_PKEY = Internal.createUniqueKey(Author.AUTHOR, DSL.name("author_pkey"), new TableField[] { Author.AUTHOR.ID }, true);
    public static final UniqueKey<AuthorBookRecord> AUTHOR_BOOK_PKEY = Internal.createUniqueKey(AuthorBook.AUTHOR_BOOK, DSL.name("author_book_pkey"), new TableField[] { AuthorBook.AUTHOR_BOOK.AUTHOR_ID, AuthorBook.AUTHOR_BOOK.BOOK_ID }, true);
    public static final UniqueKey<BookRecord> BOOK_PKEY = Internal.createUniqueKey(Book.BOOK, DSL.name("book_pkey"), new TableField[] { Book.BOOK.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AuthorBookRecord, AuthorRecord> AUTHOR_BOOK__FK_AB_AUTHOR = Internal.createForeignKey(AuthorBook.AUTHOR_BOOK, DSL.name("fk_ab_author"), new TableField[] { AuthorBook.AUTHOR_BOOK.AUTHOR_ID }, Keys.AUTHOR_PKEY, new TableField[] { Author.AUTHOR.ID }, true);
    public static final ForeignKey<AuthorBookRecord, BookRecord> AUTHOR_BOOK__FK_AB_BOOK = Internal.createForeignKey(AuthorBook.AUTHOR_BOOK, DSL.name("fk_ab_book"), new TableField[] { AuthorBook.AUTHOR_BOOK.BOOK_ID }, Keys.BOOK_PKEY, new TableField[] { Book.BOOK.ID }, true);
}
