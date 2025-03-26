package com.busconnect.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;

@Component
public class CustomErrorAttributes implements ErrorAttributes {

    private final DefaultErrorAttributes defaultErrorAttributes = new DefaultErrorAttributes();

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        Map<String, Object> errorAttributes = defaultErrorAttributes.getErrorAttributes(webRequest, options);

        errorAttributes.remove("trace");

        return errorAttributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        return defaultErrorAttributes.getError(webRequest);
    }
}