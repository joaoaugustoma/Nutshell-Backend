package com.ueg.nutshellbackend.common.exception;

import com.ueg.nutshellbackend.common.util.Util;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

    private boolean concat;
    private IMessageCode code;
    private Object[] parameters;
    private MessageResponse response;
    public BusinessException(final IMessageCode code, Boolean concat, final Object... parameters) {
        this.code = code;
        this.concat = concat;
        this.parameters = parameters;
    }

    public BusinessException(final IMessageCode code, final Object... parameters) {
        this(code, Boolean.TRUE, parameters);
    }

    public BusinessException(final IMessageCode code) {
        this.code = code;
    }

    public BusinessException(final Throwable e) {
        super(e);
    }

    public BusinessException(MessageResponse response) {
        this.response = response;
    }

    public String getMessage() {
        String message = super.getMessage();

        if (Util.isEmpty(super.getMessage())) {
            List<String> params = new ArrayList<>();

            if (code != null) {
                params.add("code: " + code);
            }

            params.add("concat: " + concat);

            if (hasParameters()) {
                String paramsConcat = Util.getValorConcatenado(", ", parameters);
                params.add("parameters: [" + paramsConcat + "]");
            }

            message = "{";
            message += Util.getValorConcatenado(", ", params.toArray());
            message += "}";
        }

        return message;
    }

    public MessageResponse getResponse() {
        return response;
    }

    public boolean isConcat() {
        return concat;
    }

    public IMessageCode getCode() {
        return code;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public boolean hasParameters() {
        return parameters != null && parameters.length > 0;
    }
}
