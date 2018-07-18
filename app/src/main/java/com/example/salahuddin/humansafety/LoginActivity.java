package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    private Button signUpNowButton,forgetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        signUpNowButton = (Button) findViewById(R.id.signUpfromLoginPageButtonId);
        forgetPasswordButton = (Button) findViewById(R.id.forgetPasswordButtonId);

        final Intent intentSignUp = new Intent(this,SignUpActivity.class);
        final Intent intentForgetPass = new Intent(this,Re_setPassword.class);

        signUpNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(intentSignUp);
                finish();
            }
        });

        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentForgetPass);
                finish();
            }
        });

    }


}
