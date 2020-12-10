
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AuthenticateResponse {
    @SerializedName("app_top_module_assignment")
    private List<Object> mAppTopModuleAssignment;
    @SerializedName("auth_info")
    private AuthInfo mAuthInfo;
    @SerializedName("organization_info")
    private OrganizationInfo mOrganizationInfo;
    @SerializedName("organization_logo")
    private String mOrganizationLogo;
    @SerializedName("organization_name")
    private String mOrganizationName;
    @SerializedName("success")
    private Boolean mSuccess;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("token")
    private String mToken;

    public List<Object> getAppTopModuleAssignment() {
        return mAppTopModuleAssignment;
    }

    public void setAppTopModuleAssignment(List<Object> appTopModuleAssignment) {
        mAppTopModuleAssignment = appTopModuleAssignment;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public AuthInfo getAuthInfo() {
        return mAuthInfo;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        mAuthInfo = authInfo;
    }

    public OrganizationInfo getOrganizationInfo() {
        return mOrganizationInfo;
    }

    public void setOrganizationInfo(OrganizationInfo organizationInfo) {
        mOrganizationInfo = organizationInfo;
    }

    public String getOrganizationLogo() {
        return mOrganizationLogo;
    }

    public void setOrganizationLogo(String organizationLogo) {
        mOrganizationLogo = organizationLogo;
    }

    public String getOrganizationName() {
        return mOrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        mOrganizationName = organizationName;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
