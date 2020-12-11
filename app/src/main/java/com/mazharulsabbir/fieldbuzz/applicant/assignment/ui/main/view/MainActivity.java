package com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.main.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.R;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api.RetrofitBuilder;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.ErrorResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.cv.CvUploadResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.CvFile;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.Recruitment;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.response.RecruitmentResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.auth.view.AuthActivity;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.ErrorUtils;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.FileUtils;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil;

import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String[] APPLYING_IN = new String[]{
            "Mobile", "Backend"
    };

    private final CompositeDisposable disposable = new CompositeDisposable();
    private TextInputLayout name, email, phone, fullAddress, nameOfUniversity, graduationYear, cgpa,
            experienceInMonth, currentWorkPlace, expectedSalary, fieldBuzzReference, githubProjectUrl;

    private MaterialAutoCompleteTextView applyingIn;

    private Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, APPLYING_IN);

        MaterialAutoCompleteTextView applyingIn = findViewById(R.id.applying_in);
        applyingIn.setAdapter(adapter);

        initTextInputLayout();
    }

    private void initTextInputLayout() {
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        fullAddress = findViewById(R.id.full_address);
        nameOfUniversity = findViewById(R.id.name_of_university);
        graduationYear = findViewById(R.id.graduation_year);
        cgpa = findViewById(R.id.cgpa);
        experienceInMonth = findViewById(R.id.experience_in_months);
        currentWorkPlace = findViewById(R.id.current_work_place_name);
        applyingIn = findViewById(R.id.applying_in);
        expectedSalary = findViewById(R.id.expected_salary);
        fieldBuzzReference = findViewById(R.id.field_buzz_reference);
        githubProjectUrl = findViewById(R.id.github_project_url);
    }

    private Recruitment getRecruitmentFromInput() {
        Recruitment recruitment = new Recruitment();

        recruitment.setTsyncId(UUID.randomUUID().toString()); // this uuid will create new data.

        CvFile cvFile = new CvFile();
        cvFile.setTsyncId(UUID.randomUUID().toString());
        recruitment.setCvFile(cvFile);

        if (validateTextInputLayout(name))
            recruitment.setName(name.getEditText().getText().toString().trim());

        if (validateTextInputLayout(email))
            recruitment.setEmail(email.getEditText().getText().toString().trim());

        if (validateTextInputLayout(phone))
            recruitment.setPhone(phone.getEditText().getText().toString().trim());

        recruitment.setFullAddress(fullAddress.getEditText().getText().toString().trim());

        if (validateTextInputLayout(nameOfUniversity))
            recruitment.setNameOfUniversity(nameOfUniversity.getEditText().getText().toString().trim());

        if (validateTextInputLayout(graduationYear)) {
            if (!graduationYear.getEditText().getText().toString().trim().isEmpty())
                recruitment.setGraduationYear(Integer.parseInt(graduationYear.getEditText().getText().toString().trim()));
        }

        if (!cgpa.getEditText().getText().toString().trim().isEmpty())
            recruitment.setCgpa(Double.parseDouble(cgpa.getEditText().getText().toString().trim()));

        if (!experienceInMonth.getEditText().getText().toString().trim().isEmpty())
            recruitment.setExperienceInMonths(Long.parseLong(experienceInMonth.getEditText().getText().toString().trim()));

        recruitment.setCurrentWorkPlaceName(currentWorkPlace.getEditText().getText().toString().trim());

        if (applyingIn.getText().toString() != null) {
            recruitment.setApplyingIn(applyingIn.getText().toString().trim());
        }

        if (validateTextInputLayout(expectedSalary))
            if (!expectedSalary.getEditText().getText().toString().trim().isEmpty())
                recruitment.setExpectedSalary(Long.parseLong(expectedSalary.getEditText().getText().toString().trim()));

        recruitment.setFieldBuzzReference(fieldBuzzReference.getEditText().getText().toString().trim());

        if (validateTextInputLayout(githubProjectUrl))
            recruitment.setGithubProjectUrl(githubProjectUrl.getEditText().getText().toString().trim());

        return recruitment;
    }

    private boolean validateTextInputLayout(TextInputLayout layout) {
        if (layout.getEditText().getText().toString().trim() != null && !layout.getEditText().getText().toString().trim().isEmpty()) {
            layout.setErrorEnabled(false);
            Logger.getLogger(TAG).warning("Valid");
            return true;
        } else {
            Logger.getLogger(TAG).warning("Required!");
            layout.setError("This field is required!");
            return false;
        }
    }

    private boolean isValidForm(Recruitment recruitment) {
        return isValidInput(recruitment.getName()) && isValidInput(recruitment.getEmail()) && isValidInput(recruitment.getPhone()) &&
                isValidInput(recruitment.getNameOfUniversity()) && isValidInput(String.valueOf(recruitment.getGraduationYear())) &&
                isValidInput(recruitment.getApplyingIn()) && isValidInput(String.valueOf(recruitment.getExpectedSalary())) &&
                isValidInput(recruitment.getGithubProjectUrl());
    }

    private boolean isValidInput(String s) {
        return s != null && !s.isEmpty();
    }

    public void saveRecruitment(View view) {
        Recruitment recruitment = getRecruitmentFromInput();
        RetrofitBuilder builder = new RetrofitBuilder();

        if (isValidForm(recruitment)) {
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setMessage("Loading...");
            dialog.show();

            disposable.add(
                    builder.getFieldBuzzApiService(client)
                            .recruitment(recruitment)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .map(response -> {
                                dialog.dismiss();
                                return response;
                            })
//                            .doOnError(this::handleError)
//                            .doOnSuccess(this::handleRecruitmentResponse)
                            .subscribe(
                                    this::handleRecruitmentResponse,
                                    this::handleError
                            )
            );
        } else
            Toast.makeText(this, "Please enter required information first.", Toast.LENGTH_SHORT)
                    .show();
    }

    private void handleRecruitmentResponse(Response<RecruitmentResponse> response) {
        if (response.code() == 201) {
            alertDialog("Success", response.body().getMessage()).show();
            uploadCv(fileUri, response.body().getCvFile().getId());
        } else {
            ErrorResponse errorResponse = ErrorUtils.parseError(response);
            if (!errorResponse.isSuccess()) {
                alertDialog("Warning", "Failed to save recruitment. " + errorResponse.getMessage()).show();
            }
        }

        Logger.getLogger(TAG).warning("Recruitment Response: " + response.body());
        Logger.getLogger(TAG).warning("Recruitment Response: " + response.errorBody());
    }

    public void chooseCvFromFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        startActivityForResult(Intent.createChooser(intent, "Select Your CV"), 9181);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9181) {
            try {
                fileUri = data.getData();
                File file = FileUtils.getFile(this, fileUri);

                TextView textView = findViewById(R.id.pdf_url);
                textView.setText(file.getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadCv(Uri fileUri, int fileId) {
        if (fileUri == null) {
            alertDialog("Warning", "Cv not found to upload. Please attach cv and try again.");
            return;
        }

        File file = FileUtils.getFile(this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part
                .createFormData("file", file.getName(), requestFile);

        RetrofitBuilder builder = new RetrofitBuilder();

        disposable.add(
                builder.getFieldBuzzApiService(client).uploadCv(fileId, body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(response -> response)
                        .subscribe(
                                this::handleResponse,
                                this::handleError
                        )
        );
    }

    private void handleResponse(Response<CvUploadResponse> response) {
        if (response.code() == 201) {
            alertDialog("Success", response.body().getMessage()).show();
        } else {
            ErrorResponse errorResponse = ErrorUtils.parseError(response);
            if (!errorResponse.isSuccess()) {
                alertDialog("Warning", "Failed to upload your cv. " + errorResponse.getMessage()).show();
            }
        }

        Logger.getLogger(TAG).warning("Response: " + response.body());
        Logger.getLogger(TAG).warning("Response: " + response.errorBody());
    }

    private void handleError(Throwable throwable) {
        alertDialog("Warning", "An unexpected error occurred. Try again later.").show();
    }

    private AlertDialog alertDialog(String title, String message) {
        return new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                })
                .create();
    }

    private final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                String token = new SharedPrefUtil(getApplicationContext()).getToken();
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "token " + token)
                        .build();
                return chain.proceed(newRequest);
            }).build();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            SharedPrefUtil util = new SharedPrefUtil(this);
            util.logout();

            startActivity(new Intent(this, AuthActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        disposable.clear();
    }
}