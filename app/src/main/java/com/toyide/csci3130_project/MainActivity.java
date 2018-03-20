package com.toyide.csci3130_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Luwei Cai & Zhiyuan Wang on 2018/2/21.
 * This activity is used to read password and username.
 * It is used to check whether users exist.
 */
public class MainActivity extends AppCompatActivity {
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Button button = findViewById(R.id.btn_login);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            EditText userField = findViewById(R.id.input_username);
            EditText psField = findViewById(R.id.input_password);
            String username = userField.getText().toString();
            String password = psField.getText().toString();
            TextView view = findViewById(R.id.login_error);
            checkPassword check = new checkPassword();
            if (check.check(username, password)) {
                startActivity(new Intent(MainActivity.this, NavActivity.class));
            } else {
                String text = "Incorrect username or password. Please try again.";
                view.setText(text);
            }
        }
    });
}

}


