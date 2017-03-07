
package com.airhacks.sample.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("samples")
public class SamplesResource {

    @Inject
    SamplesSupplier supplier;

    @GET
    public String hello() {
        return supplier.hey();
    }


}
