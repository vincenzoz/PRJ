package org.vinsw.java8.annotation;

import javax.activation.DataSource;

public class SimpleObject {

    @Configuration(path = "path_to_configuration")
    public String configuration;

    @Datasource()
    public DataSource getDataSource() {
        return null;
    }
}
