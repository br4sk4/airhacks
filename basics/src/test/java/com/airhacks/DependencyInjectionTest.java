
package com.airhacks;

import com.airhacks.di.SoptimInject;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class DependencyInjectionTest {

    @Test
    public void inject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.airhacks.SoptimMicroservice");
        Object microservice = clazz.newInstance();
        Assert.assertNotNull(clazz);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SoptimInject.class)) {
                field.setAccessible(true);
                System.out.println("annotated: " + field);
                Class<?> messageStoreClass = field.getType();
                Object messageStore = messageStoreClass.newInstance();
                field.set(microservice, messageStore);
                System.out.println("microservice = " + microservice);
            } else {
                System.out.println("not annotated: " + field);
            }
        }
    }


}
