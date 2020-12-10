
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment.response;

import com.google.gson.annotations.SerializedName;

public class CvFile {

    @SerializedName("code")
    private String mCode;
    @SerializedName("date_created")
    private Long mDateCreated;
    @SerializedName("description")
    private Object mDescription;
    @SerializedName("extension")
    private Object mExtension;
    @SerializedName("file")
    private Object mFile;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_updated")
    private Long mLastUpdated;
    @SerializedName("name")
    private String mName;
    @SerializedName("path")
    private String mPath;
    @SerializedName("tsync_id")
    private String mTsyncId;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getDateCreated() {
        return mDateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        mDateCreated = dateCreated;
    }

    public Object getDescription() {
        return mDescription;
    }

    public void setDescription(Object description) {
        mDescription = description;
    }

    public Object getExtension() {
        return mExtension;
    }

    public void setExtension(Object extension) {
        mExtension = extension;
    }

    public Object getFile() {
        return mFile;
    }

    public void setFile(Object file) {
        mFile = file;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getTsyncId() {
        return mTsyncId;
    }

    public void setTsyncId(String tsyncId) {
        mTsyncId = tsyncId;
    }

}
