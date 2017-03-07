
package com.airhacks.books.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author airhacks.com
 */
@Table(name = "S_BOOK")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Book.findAll, query = "SELECT b FROM Book b")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private final static String PREFIX = "com.airhacks.books.entity.Book";
    public final static String findAll = PREFIX + ".findAll";

    public Book(String title) {
        this.title = title;
    }

    Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}
