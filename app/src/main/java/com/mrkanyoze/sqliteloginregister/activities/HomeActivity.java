package com.mrkanyoze.sqliteloginregister.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mrkanyoze.sqliteloginregister.R;
import com.mrkanyoze.sqliteloginregister.helpers.DBHelper;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    private TextView mLabel;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLabel = findViewById(R.id.txtLabel);
        dbHelper = new DBHelper(this);

        Cursor res = dbHelper.getAllData();

        while (res.moveToNext()) {
            String name = res.getString(1);
            mLabel.setText(name);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
