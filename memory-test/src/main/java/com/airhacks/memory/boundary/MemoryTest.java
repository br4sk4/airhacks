
package com.airhacks.memory.boundary;

import com.airhacks.memory.entity.LargeEntity;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
@Path("memory")
public class MemoryTest {

    private List<LargeEntity> entities;


    @POST
    public void generate(String amount) {
        this.entities = Stream.generate(this::create).
                limit(Integer.parseInt(amount)).
                collect(Collectors.toList());
        System.out.println("-- entities created: " + this.entities.size());
    }

    LargeEntity create() {
        return new LargeEntity("duke");
    }

}
