package com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.auth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api.FieldBuzzApiService;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api.RetrofitBuilder;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.AuthenticateResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.Authentication;

import io.reactivex.Observable;
import retrofit2.Response;

public class AuthViewModel extends AndroidViewModel {
    public AuthViewModel(@NonNull Application application) {
        super(application);
    }

    private final RetrofitBuilder builder = new RetrofitBuilder();

    public Observable<Response<AuthenticateResponse>> login(Authentication authentication) {
        FieldBuzzApiService fieldBuzzApiService = builder.getFieldBuzzApiService();
        return fieldBuzzApiService.login(authentication);
    }
}
