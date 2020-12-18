package com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.auth.view;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.R;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.ErrorResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.Authentication;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.response.AuthenticateResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.auth.viewmodel.AuthViewModel;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.main.view.MainActivity;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.ErrorUtils;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {
    private static final String TAG = "AuthActivity";
    private final CompositeDisposable disposable = new CompositeDisposable();
    private AuthViewModel authViewModel;

    private TextInputLayout email;
    private TextInputLayout pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        email = findViewById(R.id.username);
        pass = findViewById(R.id.password);

        requestStoragePermissionAndProceed();
    }

    private void requestStoragePermissionAndProceed() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            init();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_EXTERNAL_STORAGE
            )) {
                new AlertDialog.Builder(this)
                        .setTitle("Warning!")
                        .setMessage("This app is requesting file read permission from you. It is required to get permitted because of " +
                                "read your cv from storage. Without your permission all functions for this app will not work " +
                                "properly. So, please accept storage permission to choose your cv from storage.")
                        .setPositiveButton("Okay", (dialog, i) -> {
                            dialog.dismiss();
                            requestPermissions(
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    100
                            );
                        })
                        .setNeutralButton("No Thanks", (dialog, i) -> {
                            dialog.dismiss();
                        })
                        .create()
                        .show();
            } else {
                // You can directly ask for the permission.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            100
                    );
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {// If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                requestStoragePermissionAndProceed();
            }
        }
    }

    private void init() {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(this);
        sharedPrefUtil.getUUID();

        if (sharedPrefUtil.getToken() != null) {
            updateUI();
        }

        findViewById(R.id.login_btn).setOnClickListener(view -> {

            String emailAddress = email.getEditText().getText().toString();
            String password = pass.getEditText().getText().toString();

            if (!emailAddress.trim().isEmpty() && !password.trim().isEmpty()) {
                login(
                        new Authentication(
                                emailAddress.trim() /*"mazharul15-8950@diu.edu.bd"*/,
                                password.trim()/*"u4BjCuy36"*/
                        )
                );
            } else {
                if (emailAddress.isEmpty())
                    email.setError("Email or Username should not be empty.");
                else email.setErrorEnabled(false);

                if (password.isEmpty())
                    pass.setError("Email or Username should not be empty.");
                else pass.setErrorEnabled(false);
            }
        });
    }

    private void updateUI() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void login(Authentication authentication) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Logging in...");
        dialog.show();

        disposable.add(
                authViewModel.login(
                        authentication
                )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(response -> {
                            dialog.cancel();
                            return response;
                        })
                        .subscribe(
                                this::successResponse,
                                this::handleError
                        )
        );
    }

    private void successResponse(Response<AuthenticateResponse> response) {
        if (response.isSuccessful()) {
            AuthenticateResponse authenticateResponse = response.body();
            SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(this);
            sharedPrefUtil.saveToken(authenticateResponse.getToken());
            Toast.makeText(this, "Login Successful.", Toast.LENGTH_SHORT).show();
            updateUI();
        } else {
            Toast.makeText(this, "Login Failed! Try again.", Toast.LENGTH_SHORT).show();

            ErrorResponse errorResponse = ErrorUtils.parseError(response);
            if (!errorResponse.isSuccess()) {
                pass.setErrorEnabled(false);
                email.setErrorEnabled(false);

                if (errorResponse.getMessage().contains("Password is incorrect for provided username.")) {
                    pass.setError(errorResponse.getMessage());
                } else {
                    email.setError(errorResponse.getMessage());
                }
            }
        }
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "handleError: ", throwable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}