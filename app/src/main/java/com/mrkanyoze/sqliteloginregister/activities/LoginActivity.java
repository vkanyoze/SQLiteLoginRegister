package com.mrkanyoze.sqliteloginregister.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrkanyoze.sqliteloginregister.R;
import com.mrkanyoze.sqliteloginregister.helpers.DBHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEmail, mPassword;
    private Button mLogin;
    private TextView mTxtRegister;
    private String email = "";
    private String password = "";
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);

        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        mLogin = findViewById(R.id.btLogin);
        mLogin.setOnClickListener(this);
        mTxtRegister = findViewById(R.id.txtRegister);
        mTxtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


    }


    @Override
    public void onClick(View v) {
        Cursor res = dbHelper.getAllData();

        while (res.moveToNext()) {
            email= res.getString(2);
            password = res.getString(3);
        }

        if (password.equals(mPassword.getText().toString())){
            Toast.makeText(getApplicationContext(), "Congrats: Login Successful", Toast.LENGTH_LONG).show();
            Intent loginSuccess = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(loginSuccess);


        }else{

            Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_LONG).show();

        }
    }
}
