
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth;

import com.google.gson.annotations.SerializedName;

public class OrganizationInfo {

    @SerializedName("code")
    private String mCode;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("organization_status")
    private Long mOrganizationStatus;
    @SerializedName("project_name")
    private String mProjectName;
    @SerializedName("translated_project_name")
    private String mTranslatedProjectName;
    @SerializedName("vat_registration_number")
    private String mVatRegistrationNumber;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getOrganizationStatus() {
        return mOrganizationStatus;
    }

    public void setOrganizationStatus(Long organizationStatus) {
        mOrganizationStatus = organizationStatus;
    }

    public String getProjectName() {
        return mProjectName;
    }

    public void setProjectName(String projectName) {
        mProjectName = projectName;
    }

    public String getTranslatedProjectName() {
        return mTranslatedProjectName;
    }

    public void setTranslatedProjectName(String translatedProjectName) {
        mTranslatedProjectName = translatedProjectName;
    }

    public String getVatRegistrationNumber() {
        return mVatRegistrationNumber;
    }

    public void setVatRegistrationNumber(String vatRegistrationNumber) {
        mVatRegistrationNumber = vatRegistrationNumber;
    }

}
