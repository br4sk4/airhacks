
package com.airhacks.sample.boundary;

import com.airhacks.sample.entity.Sample;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("samples")
public class SamplesResource {

    @Inject
    SamplesSupplier supplier;

    @GET
    public JsonArray all() {
        JsonArrayBuilder result = Json.createArrayBuilder();
        List<Sample> samples = supplier.samples();
        samples.stream().map(Sample::toJson).forEach(result::add);
        return result.build();
    }

    @POST
    public void save(JsonObject input) {
        this.supplier.save(new Sample(input));
    }


}
