
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.cv;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CvUploadResponse {
    @Expose
    private String code;
    @SerializedName("date_created")
    private Long dateCreated;
    @Expose
    private Object description;
    @Expose
    private Object extension;
    @Expose
    private Object file;
    @Expose
    private Long id;
    @SerializedName("last_updated")
    private Long lastUpdated;
    @Expose
    private String message;
    @Expose
    private String name;
    @Expose
    private String path;
    @Expose
    private Boolean success;
    @SerializedName("tsync_id")
    private String tsyncId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getExtension() {
        return extension;
    }

    public void setExtension(Object extension) {
        this.extension = extension;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getTsyncId() {
        return tsyncId;
    }

    public void setTsyncId(String tsyncId) {
        this.tsyncId = tsyncId;
    }

}
