package com.mazharulsabbir.fieldbuzz.applicant.assignment.utils;

import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api.RetrofitBuilder;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.AuthErrorResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {
    public static AuthErrorResponse parseError(Response<?> response) {
        Converter<ResponseBody, AuthErrorResponse> converter =
                new RetrofitBuilder().getRetrofit()
                        .responseBodyConverter(AuthErrorResponse.class, new Annotation[0]);

        AuthErrorResponse error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new AuthErrorResponse();
        }

        return error;
    }
}
