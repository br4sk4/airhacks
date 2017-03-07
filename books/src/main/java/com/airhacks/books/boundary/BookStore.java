
package com.airhacks.books.boundary;

import com.airhacks.books.entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookStore {

    @PersistenceContext
    EntityManager em;

    public Book upsert(Book book) {
        Book created = this.em.merge(book);
        this.em.flush();
        this.em.refresh(created);
        return created;
    }

    public Book findById(long id) {
        return this.em.find(Book.class, id);
    }

    public List<Book> all() {
        return this.em.createNamedQuery(Book.findAll, Book.class).
                getResultList();
    }


}
