
package com.airhacks.sample.boundary;

import javax.enterprise.inject.Specializes;

/**
 * Forget it in projects!!
 *
 * @author airhacks.com
 */
@Specializes
public class SamplesExtension extends SamplesSupplier {

    @Override
    public String hey() {
        return super.hey() + " very extensible";
    }

}
