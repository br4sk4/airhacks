/*
 */
package com.airhacks.samples.boundary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import static org.junit.Assert.assertNotNull;
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
        String result = this.tut.request().get(String.class);
        assertNotNull(result);
        System.out.println("result = " + result);

    }

}
