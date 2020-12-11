
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.response;

import com.google.gson.annotations.SerializedName;

public class RecruitmentResponse {

    @SerializedName("applying_in")
    private String mApplyingIn;
    @SerializedName("cgpa")
    private Double mCgpa;
    @SerializedName("current_work_place_name")
    private String mCurrentWorkPlaceName;
    @SerializedName("cv_file")
    private CvFile mCvFile;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("expected_salary")
    private Long mExpectedSalary;
    @SerializedName("experience_in_months")
    private Long mExperienceInMonths;
    @SerializedName("field_buzz_reference")
    private String mFieldBuzzReference;
    @SerializedName("full_address")
    private String mFullAddress;
    @SerializedName("github_project_url")
    private String mGithubProjectUrl;
    @SerializedName("graduation_year")
    private Long mGraduationYear;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("name")
    private String mName;
    @SerializedName("name_of_university")
    private String mNameOfUniversity;
    @SerializedName("on_spot_creation_time")
    private Long mOnSpotCreationTime;
    @SerializedName("on_spot_update_time")
    private Long mOnSpotUpdateTime;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("success")
    private Boolean mSuccess;
    @SerializedName("tsync_id")
    private String mTsyncId;

    public RecruitmentResponse() {
    }

    public RecruitmentResponse(String mMessage, Boolean mSuccess) {
        this.mMessage = mMessage;
        this.mSuccess = mSuccess;
    }

    public String getApplyingIn() {
        return mApplyingIn;
    }

    public void setApplyingIn(String applyingIn) {
        mApplyingIn = applyingIn;
    }

    public Double getCgpa() {
        return mCgpa;
    }

    public void setCgpa(Double cgpa) {
        mCgpa = cgpa;
    }

    public String getCurrentWorkPlaceName() {
        return mCurrentWorkPlaceName;
    }

    public void setCurrentWorkPlaceName(String currentWorkPlaceName) {
        mCurrentWorkPlaceName = currentWorkPlaceName;
    }

    public CvFile getCvFile() {
        return mCvFile;
    }

    public void setCvFile(CvFile cvFile) {
        mCvFile = cvFile;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Long getExpectedSalary() {
        return mExpectedSalary;
    }

    public void setExpectedSalary(Long expectedSalary) {
        mExpectedSalary = expectedSalary;
    }

    public Long getExperienceInMonths() {
        return mExperienceInMonths;
    }

    public void setExperienceInMonths(Long experienceInMonths) {
        mExperienceInMonths = experienceInMonths;
    }

    public String getFieldBuzzReference() {
        return mFieldBuzzReference;
    }

    public void setFieldBuzzReference(String fieldBuzzReference) {
        mFieldBuzzReference = fieldBuzzReference;
    }

    public String getFullAddress() {
        return mFullAddress;
    }

    public void setFullAddress(String fullAddress) {
        mFullAddress = fullAddress;
    }

    public String getGithubProjectUrl() {
        return mGithubProjectUrl;
    }

    public void setGithubProjectUrl(String githubProjectUrl) {
        mGithubProjectUrl = githubProjectUrl;
    }

    public Long getGraduationYear() {
        return mGraduationYear;
    }

    public void setGraduationYear(Long graduationYear) {
        mGraduationYear = graduationYear;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNameOfUniversity() {
        return mNameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        mNameOfUniversity = nameOfUniversity;
    }

    public Long getOnSpotCreationTime() {
        return mOnSpotCreationTime;
    }

    public void setOnSpotCreationTime(Long onSpotCreationTime) {
        mOnSpotCreationTime = onSpotCreationTime;
    }

    public Long getOnSpotUpdateTime() {
        return mOnSpotUpdateTime;
    }

    public void setOnSpotUpdateTime(Long onSpotUpdateTime) {
        mOnSpotUpdateTime = onSpotUpdateTime;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public String getTsyncId() {
        return mTsyncId;
    }

    public void setTsyncId(String tsyncId) {
        mTsyncId = tsyncId;
    }

    @Override
    public String toString() {
        return "RecruitmentResponse{" +
                "mApplyingIn='" + mApplyingIn + '\'' +
                ", mCgpa=" + mCgpa +
                ", mCurrentWorkPlaceName='" + mCurrentWorkPlaceName + '\'' +
                ", mCvFile=" + mCvFile +
                ", mEmail='" + mEmail + '\'' +
                ", mExpectedSalary=" + mExpectedSalary +
                ", mExperienceInMonths=" + mExperienceInMonths +
                ", mFieldBuzzReference='" + mFieldBuzzReference + '\'' +
                ", mFullAddress='" + mFullAddress + '\'' +
                ", mGithubProjectUrl='" + mGithubProjectUrl + '\'' +
                ", mGraduationYear=" + mGraduationYear +
                ", mMessage='" + mMessage + '\'' +
                ", mName='" + mName + '\'' +
                ", mNameOfUniversity='" + mNameOfUniversity + '\'' +
                ", mOnSpotCreationTime=" + mOnSpotCreationTime +
                ", mOnSpotUpdateTime=" + mOnSpotUpdateTime +
                ", mPhone='" + mPhone + '\'' +
                ", mSuccess=" + mSuccess +
                ", mTsyncId='" + mTsyncId + '\'' +
                '}';
    }
}
