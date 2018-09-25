package com.mrkanyoze.sqliteloginregister.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mrkanyoze.sqliteloginregister.R;
import com.mrkanyoze.sqliteloginregister.helpers.DBHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName, mEmail, mPass, mPassConfirm;
    private Button mRegister;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHelper = new DBHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mPass = findViewById(R.id.etPassword);
        mPassConfirm = findViewById(R.id.etConfirmPassword);

        mRegister = findViewById(R.id.btRegister);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String password =  mPass.getText().toString();
        String passwordconfirm = mPassConfirm.getText().toString();
        if (name.equals("")||email.equals("")||password.equals("")||passwordconfirm.equals("")){
            Toast.makeText(getApplicationContext(), "Error: Please Fill In the Required Fields", Toast.LENGTH_LONG).show();

        }else {
            if (!password.equals(passwordconfirm)){
                Toast.makeText(getApplicationContext(), "Error: Passowrd don't Match", Toast.LENGTH_LONG).show();
            }else {
                dbHelper.registerUser(name, email, password);
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }

    }
}
