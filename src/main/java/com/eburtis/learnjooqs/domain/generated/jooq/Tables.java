/*
 * This file is generated by jOOQ.
 */
package com.eburtis.learnjooqs.domain.generated.jooq;


import com.eburtis.learnjooqs.domain.generated.jooq.tables.Book;
import com.eburtis.learnjooqs.domain.generated.jooq.tables.FlywaySchemaHistory;
import com.eburtis.learnjooqs.domain.generated.jooq.tables.Author;
import com.eburtis.learnjooqs.domain.generated.jooq.tables.AuthorBook;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.author</code>.
     */
    public static final Author AUTHOR = Author.AUTHOR;

    /**
     * The table <code>public.author_book</code>.
     */
    public static final AuthorBook AUTHOR_BOOK = AuthorBook.AUTHOR_BOOK;

    /**
     * The table <code>public.book</code>.
     */
    public static final Book BOOK = Book.BOOK;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;
}
