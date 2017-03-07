
package com.airhacks.sample.entity;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class Sample {

    private String name;

    public Sample(String name) {
        this.name = name;
    }

    public Sample(JsonObject input) {
        this.name = input.getString("name");
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder().
                add("name", this.name).
                build();
    }

    @Override
    public String toString() {
        return "Sample{" + "name=" + name + '}';
    }


}
