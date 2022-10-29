package com.ueg.nutshellbackend.common.exception;

import com.ueg.nutshellbackend.common.util.CollectionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageResponse implements Serializable {

    private String code;
    private Integer status;
    private String error;
    private String message;
    private Object[] parameters;
    private List<FieldResponse> attributes;

    public void addAttribute(final FieldResponse field) {
        if (CollectionUtil.isEmpty(attributes)) {
            attributes = new ArrayList<FieldResponse>();
        }
        attributes.add(field);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public List<FieldResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FieldResponse> attributes) {
        this.attributes = attributes;
    }

}
