package com.example.josue.practicalogin;

import  android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class dashboardActivity extends AppCompatActivity {

    private static final String TAG = dashboardActivity.class.getSimpleName();
    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private TextView usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        usernameText = (TextView)findViewById(R.id.fullname_text);
        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // get username from SharedPreferences
        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);
        User user = UserRepository.getUser(username);
        usernameText.setText(user.getFullname());
    }
    

    public void callLogo(View view){
        // remove from SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor.putBoolean("islogged", false).commit();
//        boolean success = editor.clear().commit(); // not recommended

        finish();
    }


}