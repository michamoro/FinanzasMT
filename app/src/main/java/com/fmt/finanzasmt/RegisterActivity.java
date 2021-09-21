package com.fmt.finanzasmt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fmt.finanzasmt.db.DbHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_name, et_lastName, et_email, et_password, et_confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText) findViewById(R.id.txt_name);
        et_lastName = (EditText) findViewById(R.id.txt_last_name);
        et_email = (EditText) findViewById(R.id.txt_email);
        et_password = (EditText) findViewById(R.id.txt_password);
        et_confirmPassword = (EditText) findViewById(R.id.txt_confirm_password);
    }

    public void register(View view){

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String name = et_name.getText().toString();
        String lastName = et_lastName.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String confirmPassword = et_confirmPassword.getText().toString();

        if(!name.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){

            ContentValues user = new ContentValues();
            user.put("name", name);
            user.put("last_name", lastName);
            user.put("email", email);
            user.put("password", password);
            user.put("confirm_password", confirmPassword);

            db.insert("t_users", null, user);
            db.close();

            et_name.setText("");
            et_lastName.setText("");
            et_email.setText("");
            et_password.setText("");
            et_confirmPassword.setText("");

            Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show();

            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);

        } else{
            Toast.makeText(this, "You must fill in all the required fields", Toast.LENGTH_SHORT).show();
        }

    }


}