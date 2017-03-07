
package com.airhacks.books.boundary;

import com.airhacks.books.entity.Book;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("books")
public class BooksResource {

    @Inject
    BookStore bookStore;

    @POST
    public Response save(Book book, @Context UriInfo info) {
        Book created = this.bookStore.upsert(book);
        URI uri = info.getAbsolutePathBuilder().path("/" + created.getId()).build();
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Book byId(@PathParam("id") long id) {
        return bookStore.findById(id);
    }

    @GET
    public List<Book> all() {
        return this.bookStore.all();
    }

    @GET
    @Path("sample")
    public Book sample() {
        return new Book("parkinson's law");
    }


}
