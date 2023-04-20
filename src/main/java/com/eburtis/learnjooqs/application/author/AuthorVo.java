package com.eburtis.learnjooqs.application.author;

import com.eburtis.learnjooqs.domain.Author;

public class AuthorVo {
    private Long id;
    private String firstName;
    private String lastName;

    public AuthorVo(){super();}
    public AuthorVo(Author author) {
        this();
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
