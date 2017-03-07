
package com.airhacks.sample.audit.boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class SampleCreationListener {

    public void onNewSample(@Observes(during = TransactionPhase.AFTER_SUCCESS) JsonObject sample) {
        System.out.println("+++audit- created: " + sample);

    }

    public void onFailedAttempt(@Observes(during = TransactionPhase.AFTER_FAILURE) JsonObject sample) {
        System.out.println("---audit- creation failed: " + sample);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SampleCreationListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
