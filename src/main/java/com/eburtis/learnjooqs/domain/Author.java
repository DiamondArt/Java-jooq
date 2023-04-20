package com.eburtis.learnjooqs.domain;
import com.eburtis.learnjooqs.application.author.AuthorVo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Author.TABLE_NAME)
@Access(AccessType.FIELD)
public class Author {
    public static final String TABLE_NAME = "author";
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
     private String firstName;
    @Column(name = "last_name")
     private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Author_Book",
        joinColumns = { @JoinColumn(name = "author_id") },
        inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books = new HashSet<>();

    public Author() {super();}
    public Author(Long id,String firstName, String lastName, Set<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public void modifie(AuthorVo authorVo){
        this.id = authorVo.getId();
        this.firstName = authorVo.getFirstName();
        this.lastName = authorVo.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
