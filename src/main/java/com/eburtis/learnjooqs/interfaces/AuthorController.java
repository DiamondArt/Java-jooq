package com.eburtis.learnjooqs.interfaces;

import com.eburtis.learnjooqs.application.author.AuthorService;
import com.eburtis.learnjooqs.application.author.AuthorVo;
import com.eburtis.learnjooqs.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Enregiste un author.
     **/
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void creerAuthor(@RequestBody AuthorVo authorVo) {
        this.authorService.creerAuteur(authorVo);
    }

    /**
     * Liste les auteurs
     * */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Author> listeAuthor(){
        return this.authorService.lister();
    }


    /**
     * modifie un author.
     **/
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void modifierAuthor(@RequestBody AuthorVo authorVo) {
        this.authorService.creerAuteur(authorVo);
    }


}
