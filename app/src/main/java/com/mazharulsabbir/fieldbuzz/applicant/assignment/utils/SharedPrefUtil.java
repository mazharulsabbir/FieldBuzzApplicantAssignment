package com.mazharulsabbir.fieldbuzz.applicant.assignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    private static final String TAG = "SharedPrefUtil";

    private static final String DATABASE_NAME = "fieldbuzz_applicant_assignment_SharedPrefUtil";
    private static final String TOKEN = "com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil.EXTRA_TOKEN";
    private static final String UUID = "com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil.EXTRA_UUID";
    private static final String FILE_UUID = "com.mazharulsabbir.fieldbuzz.applicant.assignment.utils.SharedPrefUtil.EXTRA_FILE_UUID";

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

    public void setUUID(String uuid) {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(UUID, uuid);
        editor.apply();
        editor.commit();
    }

    public String getUUID() {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        return preferences.getString(UUID, null);
    }

    public void setCvUUID(String uuid) {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(FILE_UUID, uuid);
        editor.apply();
        editor.commit();
    }

    public String getCvFileUUID() {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        return preferences.getString(FILE_UUID, null);
    }

    public void logout() {
        SharedPreferences preferences = context.getSharedPreferences(DATABASE_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove(TOKEN);
        editor.remove(UUID);
        editor.remove(FILE_UUID);

        editor.clear();
        editor.apply();
        editor.commit();
    }
}
