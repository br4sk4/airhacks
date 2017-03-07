
package com.airhacks.books.boundary;

import com.airhacks.books.entity.Book;
import java.net.URI;
import java.util.List;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
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

    @Resource
    ManagedExecutorService mes;

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
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);

        Consumer<Object> consumer = response::resume;
        Supplier<List<Book>> supplier = this.bookStore::all;
        supplyAsync(supplier, this.mes).thenAccept(consumer);

    }

    @GET
    @Path("sample")
    public Book sample() {
        return new Book("parkinson's law");
    }


}
