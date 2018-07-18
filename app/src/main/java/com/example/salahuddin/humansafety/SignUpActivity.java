package com.example.salahuddin.humansafety;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button mainSignUpButton,alreadyLoginButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        alreadyLoginButton = (Button) findViewById(R.id.alreadyLoginButtonId);
        mainSignUpButton = (Button) findViewById(R.id.mainSignUpButtonId);

        final Intent signUpIntent = new Intent(this,LoginActivity.class);

        alreadyLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signUpIntent);
                finish();
            }
        });


        mainSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signUpIntent);
                finish();
            }
        });
    }
}
