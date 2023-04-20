/*
 * This file is generated by jOOQ.
 */
package com.eburtis.learnjooqs.domain.generated.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.eburtis.learnjooqs.domain.generated.jooq.tables.records.AuthorBookRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import com.eburtis.learnjooqs.domain.generated.jooq.Keys;
import com.eburtis.learnjooqs.domain.generated.jooq.Public;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorBook extends TableImpl<AuthorBookRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.author_book</code>
     */
    public static final AuthorBook AUTHOR_BOOK = new AuthorBook();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorBookRecord> getRecordType() {
        return AuthorBookRecord.class;
    }

    /**
     * The column <code>public.author_book.author_id</code>.
     */
    public final TableField<AuthorBookRecord, Integer> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.author_book.book_id</code>.
     */
    public final TableField<AuthorBookRecord, Integer> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private AuthorBook(Name alias, Table<AuthorBookRecord> aliased) {
        this(alias, aliased, null);
    }

    private AuthorBook(Name alias, Table<AuthorBookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.author_book</code> table reference
     */
    public AuthorBook(String alias) {
        this(DSL.name(alias), AUTHOR_BOOK);
    }

    /**
     * Create an aliased <code>public.author_book</code> table reference
     */
    public AuthorBook(Name alias) {
        this(alias, AUTHOR_BOOK);
    }

    /**
     * Create a <code>public.author_book</code> table reference
     */
    public AuthorBook() {
        this(DSL.name("author_book"), null);
    }

    public <O extends Record> AuthorBook(Table<O> child, ForeignKey<O, AuthorBookRecord> key) {
        super(child, key, AUTHOR_BOOK);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AuthorBookRecord> getPrimaryKey() {
        return Keys.AUTHOR_BOOK_PKEY;
    }

    @Override
    public List<ForeignKey<AuthorBookRecord, ?>> getReferences() {
        return Arrays.asList(Keys.AUTHOR_BOOK__FK_AB_AUTHOR, Keys.AUTHOR_BOOK__FK_AB_BOOK);
    }

    private transient Author _author;
    private transient Book _book;

    /**
     * Get the implicit join path to the <code>public.author</code> table.
     */
    public Author author() {
        if (_author == null)
            _author = new Author(this, Keys.AUTHOR_BOOK__FK_AB_AUTHOR);

        return _author;
    }

    /**
     * Get the implicit join path to the <code>public.book</code> table.
     */
    public Book book() {
        if (_book == null)
            _book = new Book(this, Keys.AUTHOR_BOOK__FK_AB_BOOK);

        return _book;
    }

    @Override
    public AuthorBook as(String alias) {
        return new AuthorBook(DSL.name(alias), this);
    }

    @Override
    public AuthorBook as(Name alias) {
        return new AuthorBook(alias, this);
    }

    @Override
    public AuthorBook as(Table<?> alias) {
        return new AuthorBook(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorBook rename(String name) {
        return new AuthorBook(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorBook rename(Name name) {
        return new AuthorBook(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorBook rename(Table<?> name) {
        return new AuthorBook(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
