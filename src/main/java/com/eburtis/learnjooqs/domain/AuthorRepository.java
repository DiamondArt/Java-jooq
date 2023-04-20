package com.eburtis.learnjooqs.domain;

import com.eburtis.learnjooqs.application.author.AuthorVo;
import org.jooq.DSLContext;
import org.jooq.codegen.maven.example.Tables;
import org.jooq.conf.RenderNameCase;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "author")
public class AuthorRepository {
    private final DSLContext dslContext;
    AuthorRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.dslContext.settings().withRenderNameCase(RenderNameCase.LOWER);
    }

    /***
     *  Lister les auteurs
     * */
    public List<Author> lister() {
        return dslContext.selectFrom(Tables.AUTHOR)
                .fetchInto(Author.class);
    }

    /**
     * Afficher un auteur
     * */
     public Author afficherAuteur(Integer id){
         return dslContext.selectFrom(Tables.AUTHOR).where(Tables.AUTHOR.ID.eq(id)).fetchSingleInto(Author.class);
     }

    /**
     * Creation d'un auteur
     * */
    public void creerAuteur(AuthorVo author){
        dslContext.insertInto(Tables.AUTHOR, Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME,Tables.AUTHOR.LAST_NAME)
                .values(author.getId().intValue(),author.getFirstName(), author.getLastName()).execute();
    }

    /**
     * Mise à jour d'un auteur
     * */
    public void modifierAuteur(AuthorVo author){
        Author _author = this.afficherAuteur(author.getId().intValue());

        dslContext.update(Tables.AUTHOR)
                .set(Tables.AUTHOR.FIRST_NAME,author.getFirstName())
                .set(Tables.AUTHOR.LAST_NAME, author.getLastName())
                .where(Tables.AUTHOR.ID.eq(author.getId().intValue())).execute();
//        .update(CUSTOMER)
//                .set(CUSTOMER.STATUS, "Gold")
//                .where(CUSTOMER.ID.eq(1))
//                .execute();
    }
}
