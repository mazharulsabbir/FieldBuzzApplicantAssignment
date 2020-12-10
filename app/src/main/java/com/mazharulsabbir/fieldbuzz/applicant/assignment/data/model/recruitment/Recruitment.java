
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recruitment {

    @SerializedName("applying_in")
    private String applyingIn;
    @Expose
    private Double cgpa;
    @SerializedName("current_work_place_name")
    private String currentWorkPlaceName;
    @SerializedName("cv_file")
    private CvFile cvFile;
    @Expose
    private String email;
    @SerializedName("expected_salary")
    private Long expectedSalary;
    @SerializedName("experience_in_months")
    private Long experienceInMonths;
    @SerializedName("field_buzz_reference")
    private String fieldBuzzReference;
    @SerializedName("full_address")
    private String fullAddress;
    @SerializedName("github_project_url")
    private String githubProjectUrl;
    @SerializedName("graduation_year")
    private int graduationYear;
    @Expose
    private String name;
    @SerializedName("name_of_university")
    private String nameOfUniversity;
    @SerializedName("on_spot_creation_time")
    private Long onSpotCreationTime;
    @SerializedName("on_spot_update_time")
    private Long onSpotUpdateTime;
    @Expose
    private String phone;
    @SerializedName("tsync_id")
    private String tsyncId;

    public String getApplyingIn() {
        return applyingIn;
    }

    public void setApplyingIn(String applyingIn) {
        this.applyingIn = applyingIn;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getCurrentWorkPlaceName() {
        return currentWorkPlaceName;
    }

    public void setCurrentWorkPlaceName(String currentWorkPlaceName) {
        this.currentWorkPlaceName = currentWorkPlaceName;
    }

    public CvFile getCvFile() {
        return cvFile;
    }

    public void setCvFile(CvFile cvFile) {
        this.cvFile = cvFile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Long expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Long getExperienceInMonths() {
        return experienceInMonths;
    }

    public void setExperienceInMonths(Long experienceInMonths) {
        this.experienceInMonths = experienceInMonths;
    }

    public String getFieldBuzzReference() {
        return fieldBuzzReference;
    }

    public void setFieldBuzzReference(String fieldBuzzReference) {
        this.fieldBuzzReference = fieldBuzzReference;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getGithubProjectUrl() {
        return githubProjectUrl;
    }

    public void setGithubProjectUrl(String githubProjectUrl) {
        this.githubProjectUrl = githubProjectUrl;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    public Long getOnSpotCreationTime() {
        return onSpotCreationTime;
    }

    public void setOnSpotCreationTime(Long onSpotCreationTime) {
        this.onSpotCreationTime = onSpotCreationTime;
    }

    public Long getOnSpotUpdateTime() {
        return onSpotUpdateTime;
    }

    public void setOnSpotUpdateTime(Long onSpotUpdateTime) {
        this.onSpotUpdateTime = onSpotUpdateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTsyncId() {
        return tsyncId;
    }

    public void setTsyncId(String tsyncId) {
        this.tsyncId = tsyncId;
    }

}
