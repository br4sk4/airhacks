
package com.airhacks.sample.boundary;

/**
 *
 * @author airhacks.com
 */
public class FileImporter implements Importer {

    @Override
    public String importContent() {
        return "from file";
    }

}
