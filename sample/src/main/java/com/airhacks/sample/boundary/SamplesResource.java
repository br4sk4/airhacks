
package com.airhacks.sample.boundary;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("samples")
public class SamplesResource {

    @Inject
    SamplesSupplier supplier;

    @GET
    public JsonObject hello() {
        System.out.println("-- " + supplier);
        return Json.createObjectBuilder().add("result", supplier.hey()).build();

    }


}
