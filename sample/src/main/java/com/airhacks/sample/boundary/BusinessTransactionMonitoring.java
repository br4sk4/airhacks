
package com.airhacks.sample.boundary;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class BusinessTransactionMonitoring {

    @AroundInvoke
    public Object monitor(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        System.out.println("method = " + method);
        return ic.proceed();
    }


}
