/*
 */
package com.airhacks.samples.boundary;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class SamplesResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8485/sample/resources/samples");
    }

    @Test
    public void crud() {
        JsonObject input = Json.createObjectBuilder().add("name", "joe").build();
        Response createdResponse = this.tut.request().post(Entity.json(input));
        assertThat(createdResponse.getStatus(), is(201));
        String locationHeader = createdResponse.getHeaderString("Location");
        System.out.println("locationHeader = " + locationHeader);
        assertNotNull(locationHeader);
        JsonObject freshlyCreated = this.client.target(locationHeader).request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertNotNull(freshlyCreated);


        Response response = this.tut.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonArray json = response.readEntity(JsonArray.class);
        System.out.println("result = " + json);

        System.out.println("-- " + json);

    }

}
