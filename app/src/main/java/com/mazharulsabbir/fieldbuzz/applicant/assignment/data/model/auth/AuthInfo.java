
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth;

import com.google.gson.annotations.SerializedName;

public class AuthInfo {

    @SerializedName("assigned_to")
    private Long mAssignedTo;
    @SerializedName("designation")
    private Object mDesignation;
    @SerializedName("is_first_login")
    private Boolean mIsFirstLogin;
    @SerializedName("name")
    private String mName;
    @SerializedName("role_id")
    private Long mRoleId;
    @SerializedName("role_name")
    private String mRoleName;
    @SerializedName("user_id")
    private Long mUserId;
    @SerializedName("user_photo")
    private Object mUserPhoto;
    @SerializedName("user_type")
    private String mUserType;
    @SerializedName("username")
    private String mUsername;

    public Long getAssignedTo() {
        return mAssignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        mAssignedTo = assignedTo;
    }

    public Object getDesignation() {
        return mDesignation;
    }

    public void setDesignation(Object designation) {
        mDesignation = designation;
    }

    public Boolean getIsFirstLogin() {
        return mIsFirstLogin;
    }

    public void setIsFirstLogin(Boolean isFirstLogin) {
        mIsFirstLogin = isFirstLogin;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getRoleId() {
        return mRoleId;
    }

    public void setRoleId(Long roleId) {
        mRoleId = roleId;
    }

    public String getRoleName() {
        return mRoleName;
    }

    public void setRoleName(String roleName) {
        mRoleName = roleName;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public Object getUserPhoto() {
        return mUserPhoto;
    }

    public void setUserPhoto(Object userPhoto) {
        mUserPhoto = userPhoto;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
