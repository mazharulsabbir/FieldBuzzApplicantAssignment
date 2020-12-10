package com.mazharulsabbir.fieldbuzz.applicant.assignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    private static final String DATABASE_NAME = "fieldbuzz_applicant_assignment_SharedPrefUtil";
    private static final String TOKEN = "com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil.EXTRA_TOKEN";
    private final Context context;

    public SharedPrefUtil(Context context) {
        this.context = context;
    }

    public void saveToken(String token) {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(TOKEN, token);
        editor.apply();
        editor.commit();
    }

    public String getToken() {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        return preferences.getString(TOKEN, null);
    }
}
