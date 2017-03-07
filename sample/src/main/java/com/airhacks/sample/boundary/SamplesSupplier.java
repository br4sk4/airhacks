
package com.airhacks.sample.boundary;

import com.airhacks.sample.entity.Sample;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.Interceptors;

@Interceptors(BusinessTransactionMonitoring.class)
public class SamplesSupplier {

    @Resource
    SessionContext sc;

    public List<Sample> samples() {
        return Arrays.asList(new Sample("duke"), new Sample("nuke"));
    }

    public void save(Sample sample) {
        System.out.println("probably saved = " + sample);
        //sc.setRollbackOnly();
    }

    public Sample findById(long id) {
        return new Sample("micro fake " + id);
    }


}
