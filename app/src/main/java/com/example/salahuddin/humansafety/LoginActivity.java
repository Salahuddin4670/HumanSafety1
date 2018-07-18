package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper databaseHelper;

    private Button mainLogInButton,signUpNowButton,forgetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        mainLogInButton = (Button) findViewById(R.id.loginButtonId);
        signUpNowButton = (Button) findViewById(R.id.signUpfromLoginPageButtonId);
        forgetPasswordButton = (Button) findViewById(R.id.forgetPasswordButtonId);

        mainLogInButton.setOnClickListener(this);
        signUpNowButton.setOnClickListener(this);
        forgetPasswordButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.mainLoginButtonId){


        }

        if(v.getId() == R.id.signUpfromLoginPageButtonId){
            Intent intent= new Intent(this,SignUpActivity.class);
            startActivity(intent);
            finish();
        }

        if(v.getId() == R.id.forgetPasswordButtonId){
            Intent intent= new Intent(this,Re_setPassword.class);
            startActivity(intent);
            finish();

        }
    }
}
