package com.eburtis.learnjooqs.infrastructure;

import com.eburtis.learnjooqs.application.author.AuthorService;
import com.eburtis.learnjooqs.application.author.AuthorVo;
import com.eburtis.learnjooqs.domain.Author;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.conf.RenderNameCase;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.jooq.codegen.maven.example.Tables.AUTHOR;

@Service
@Slf4j
public class AuhtorServiceImplementation implements AuthorService {
    private final DSLContext dslContext;

    AuhtorServiceImplementation(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.dslContext.settings().withRenderNameCase(RenderNameCase.LOWER);
    }

    /***
     *  Lister les auteurs
     * */
    public List<Author> lister() {
        return dslContext.selectFrom(AUTHOR)
                .fetchInto(Author.class);
    }

    /**
     * Afficher un auteur
     * */
    public Author afficherAuteur(Integer id){
        return dslContext.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchSingleInto(Author.class);
    }

    /**
     * Creation d'un auteur
     * */
    public String creerAuteur(AuthorVo author){
         dslContext.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .values(author.getId().intValue(),author.getFirstName(), author.getLastName()).execute();
        return "Author created successfull";
    }

    /**
     * Mise à jour d'un auteur
     * */
    public void modifierAuteur(AuthorVo author){
        Author _author = this.afficherAuteur(author.getId().intValue());

        dslContext.update(AUTHOR)
                .set(AUTHOR.FIRST_NAME,author.getFirstName())
                .set(AUTHOR.LAST_NAME, author.getLastName())
                .where(AUTHOR.ID.eq(author.getId().intValue())).execute();
    }
}
