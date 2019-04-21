package org.vinsw.rest.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.vinsw.rest.CommonResponse;
import org.vinsw.rest.Error;

import java.util.ArrayList;
import java.util.Locale;

public class BaseController {

    protected ResponseEntity<CommonResponse> invalid(BindingResult result) {
        ArrayList<Error> errList = new ArrayList();
        for (FieldError err : result.getFieldErrors()) {
            errList.add(new Error(err.getField(), messageSource().getMessage(err, Locale.ENGLISH)));
        }
        CommonResponse res = new CommonResponse()
                .withStatus(CommonResponse.Status.INVALID_INPUT)
                .withErrors(errList);
        ResponseEntity<CommonResponse> responseEntity = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    protected ResponseEntity<CommonResponse> success() {
        CommonResponse res = new CommonResponse()
                .withStatus(CommonResponse.Status.SUCCESS);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
