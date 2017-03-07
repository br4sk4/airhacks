/*
 */
package com.airhacks.samples.boundary;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
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
        this.tut = this.client.target("http://localhost:8080/sample/resources/samples");
    }

    @Test
    public void hello() {
        Response response = this.tut.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonObject json = response.readEntity(JsonObject.class);
        System.out.println("result = " + json);

        System.out.println("-- " + json.getString("result"));

    }

}
