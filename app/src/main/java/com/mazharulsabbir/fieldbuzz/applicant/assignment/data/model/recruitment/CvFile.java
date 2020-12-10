
package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.recruitment;

import com.google.gson.annotations.SerializedName;

public class CvFile {

    @SerializedName("tsync_id")
    private String tsyncId;

    public String getTsyncId() {
        return tsyncId;
    }

    public void setTsyncId(String tsyncId) {
        this.tsyncId = tsyncId;
    }

}
