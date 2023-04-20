package com.eburtis.learnjooqs.application.author;

import com.eburtis.learnjooqs.domain.Author;
import java.util.List;

public interface AuthorService {
    public String creerAuteur(AuthorVo author);

    public List<Author> lister() ;
    public void modifierAuteur (AuthorVo authorVo);
    public Author afficherAuteur(Integer id);
}
