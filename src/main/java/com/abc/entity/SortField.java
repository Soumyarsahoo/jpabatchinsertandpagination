package com.abc.entity;

public enum SortField {

    FIELD1("field1");

    private final String databaseFieldName;

    public String getDatabaseFieldName() {
        return databaseFieldName;
    }
    SortField(String databaseFieldName) {
        this.databaseFieldName = databaseFieldName;
    }


}
