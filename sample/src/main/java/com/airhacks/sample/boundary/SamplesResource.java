
package com.airhacks.sample.boundary;

import com.airhacks.sample.entity.Sample;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("samples")
public class SamplesResource {

    @Inject
    SamplesSupplier supplier;

    @Inject
    Principal principal;

    @Inject
    Event<JsonObject> listeners;

    @GET
    public JsonArray all() {
        System.out.println("principal: " + principal.getName());
        JsonArrayBuilder result = Json.createArrayBuilder();
        List<Sample> samples = supplier.samples();
        samples.stream().map(Sample::toJson).forEach(result::add);
        return result.build();
    }
    @GET
    @Path("{id}")
    public JsonObject byId(@PathParam("id") long id) {
        return supplier.findById(id).toJson();
    }

    //tx.begin
    @POST
    public Response save(JsonObject input, @Context UriInfo info) {
        this.listeners.fire(input);
        this.supplier.save(new Sample(input));
        URI uri = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(uri).build();
    }
    //tx.commit


}
