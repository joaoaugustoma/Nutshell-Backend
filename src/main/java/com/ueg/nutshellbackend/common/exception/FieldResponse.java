package com.ueg.nutshellbackend.common.exception;

import java.io.Serializable;

public class FieldResponse implements Serializable {

    private String attribute;
    private String description;

    public FieldResponse() {

    }

    public FieldResponse(final String attribute, final String description) {
        this.attribute = attribute;
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}