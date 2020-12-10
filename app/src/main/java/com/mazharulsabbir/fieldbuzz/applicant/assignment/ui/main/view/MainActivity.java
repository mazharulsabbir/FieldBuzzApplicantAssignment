package com.mazharulsabbir.fieldbuzz.applicant.assignment.ui.main.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.R;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api.RetrofitBuilder;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.cv.CvUploadResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.CvFile;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.Recruitment;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.response.RecruitmentResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.FileUtils;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil;

import java.io.File;
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
            experienceInMonth, currentWorkPlace, applyingIn, expectedSalary, fieldBuzzReference, githubProjectUrl;

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

        recruitment.setTsyncId("d1213026-3ac1-11eb-adc1-0242ac120002"); // this uuid will update existing data. to create new use 'UUID.randomUUID().toString()'
        CvFile cvFile = new CvFile();
        cvFile.setTsyncId("dc33c924-3ac1-11eb-adc1-0242ac120002");
        recruitment.setCvFile(cvFile);

        recruitment.setName(name.getEditText().getText().toString());
        recruitment.setEmail(email.getEditText().getText().toString());
        recruitment.setPhone(phone.getEditText().getText().toString());
        recruitment.setFullAddress(fullAddress.getEditText().getText().toString());
        recruitment.setNameOfUniversity(nameOfUniversity.getEditText().getText().toString());
        recruitment.setGraduationYear(Integer.parseInt(graduationYear.getEditText().getText().toString()));
        recruitment.setCgpa(Double.parseDouble(cgpa.getEditText().getText().toString()));
        recruitment.setExperienceInMonths(Long.parseLong(experienceInMonth.getEditText().getText().toString()));
        recruitment.setCurrentWorkPlaceName(currentWorkPlace.getEditText().getText().toString());
        recruitment.setApplyingIn(applyingIn.getEditText().getText().toString());
        recruitment.setExpectedSalary(Long.parseLong(expectedSalary.getEditText().getText().toString()));
        recruitment.setFieldBuzzReference(fieldBuzzReference.getEditText().getText().toString());
        recruitment.setGithubProjectUrl(githubProjectUrl.getEditText().getText().toString());

        return recruitment;
    }

    public void saveRecruitment(View view) {
        Recruitment recruitment = getRecruitmentFromInput();
        RetrofitBuilder builder = new RetrofitBuilder();

        disposable.add(
                builder.getFieldBuzzApiService(client)
                        .recruitment(recruitment)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(response -> response)
                        .subscribe(
                                this::handleRecruitmentResponse,
                                this::handleError
                        )
        );
    }

    private void handleRecruitmentResponse(Response<RecruitmentResponse> response) {
        Logger.getLogger(TAG).warning("Response: " + response.body());
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
            Uri fileUri = data.getData();
            uploadCv(fileUri);
        }
    }

    private void uploadCv(Uri fileUri) {
        if (fileUri == null) return;

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
                builder.getFieldBuzzApiService(client).uploadCv(661, body)
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
        Logger.getLogger(TAG).warning("Response: " + response.body());
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "handleError: ", throwable);
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
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
        disposable.clear();
    }
}