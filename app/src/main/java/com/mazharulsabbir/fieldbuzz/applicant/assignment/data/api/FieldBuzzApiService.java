package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api;

import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.AuthenticateResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth.Authentication;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.cv.CvUploadResponse;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.Recruitment;
import com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.response.RecruitmentResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface FieldBuzzApiService {
    @POST("api/login/")
    Observable<Response<AuthenticateResponse>> login(@Body Authentication authentication);

    @POST("api/v0/recruiting-entities/")
    Observable<Response<RecruitmentResponse>> recruitment(
            @Body Recruitment recruitment
    );

    @Multipart
    @POST("api/file-object/{fileId}/")
    Single<Response<CvUploadResponse>> uploadCv(
            @Path("fileId") int fileId,
            @Part MultipartBody.Part pdfFile
    );
}
