package com.example.salahuddin.humansafety;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainSignUpButton,alreadyLoginButton;
    private EditText nameEditText,emailEditText,phoneEditText,passwordEditText,confirm_password_EditText;
    private RadioButton genderButton;
    private RadioGroup radioGroup;
    private Context context;
    DatabaseHelper databaseHelper;
    SignUpUserDetails signUpUserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.nameSignUpEditTextId);
        emailEditText = (EditText) findViewById(R.id.emailSignUpEditTextId);
        phoneEditText = (EditText) findViewById(R.id.phoneSignUpEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordSignUpEditTextId);
        confirm_password_EditText = (EditText) findViewById(R.id.confirm_passwordSignUpEditTextId);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);


        alreadyLoginButton = (Button) findViewById(R.id.alreadyLoginButtonId);
        mainSignUpButton = (Button) findViewById(R.id.mainSignUpButtonId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signUpUserDetails = new SignUpUserDetails();

        alreadyLoginButton.setOnClickListener(this);
        mainSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderButton = (RadioButton) findViewById(selectedId);

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirm_password = confirm_password_EditText.getText().toString();
        String gender = genderButton.getText().toString();

        signUpUserDetails.setName(name);
        signUpUserDetails.setEmail(email);
        signUpUserDetails.setPhone(phone);
        signUpUserDetails.setPassword(password);
        signUpUserDetails.setConfirm_password(confirm_password);
        signUpUserDetails.setGender(gender);

        long rowId = databaseHelper.insertData(signUpUserDetails);

        if (v.getId() == R.id.mainSignUpButtonId){

            if (rowId>0){
                Toast.makeText(getApplicationContext(),"Row "+rowId+" Inserted Successfully",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Error data not inserted",Toast.LENGTH_SHORT).show();
            }
            //-------------------------------------
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        if (v.getId() == R.id.alreadyLoginButtonId){

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
