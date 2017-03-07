
package com.airhacks.sample.boundary;

/**
 *
 * @author airhacks.com
 */
public class DBImporter implements Importer {

    @Override
    public String importContent() {
        return "fromDB";
    }

}
