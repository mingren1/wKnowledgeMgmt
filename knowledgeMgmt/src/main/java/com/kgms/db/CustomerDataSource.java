package com.kgms.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomerDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
