
package com.airhacks.sample.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("samples")
public class SamplesResource {

    @GET
    public String hello() {
        return "hey joe";
    }


}
