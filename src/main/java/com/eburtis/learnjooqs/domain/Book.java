package com.eburtis.learnjooqs.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = Book.TABLE_NAME)
@Access(AccessType.FIELD)
@Entity
public class Book {
    static final String  TABLE_NAME = "book";
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title")
    private String title;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

}
