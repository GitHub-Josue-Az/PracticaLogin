package com.example.josue.practicalogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText usernameInput;
    private EditText passwordInput;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView usersList;
    private ProgressBar progressBar;
    private View loginPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        loginPanel = findViewById(R.id.login_panel);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // username remember
        String username = sharedPreferences.getString("username", null);
        if(username != null){
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }
        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }
    }


    public void callRegistrar(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }


    public void callLogin(View view){
        loginPanel.setVisibility(View.GONE);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();


        //LLENAR LOS DATOS SINO ERROR
        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completa los campos iama", Toast.LENGTH_SHORT).show();
            return;
        }
        /*// Login logic
        User user = UserRepository.log(username, password);
        if(user == null){
            Toast.makeText(this, "Estas mal xd", Toast.LENGTH_SHORT).show();
            loginPanel.setVisibility(View.VISIBLE);
            return;
        }
        //MENSAJE DE INICIO DE SECION
        Toast.makeText(this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("username", user.getFullname())
                .putBoolean("islogged", true)
                .commit();
        // Go to Dashboard
        goDashboard();*/
    }

    private void goDashboard(){
        startActivity(new Intent(this, dashboardActivity.class));
        finish();
    }


}
