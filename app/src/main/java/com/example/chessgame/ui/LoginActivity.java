package com.example.chessgame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chessgame.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private static LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
    }

    public String getEmail() {
        TextInputLayout textInputLayout = findViewById(R.id.inputlayout_login_emailinput);
        return textInputLayout.getEditText().getText().toString();
    }

    public String getPassword() {
        TextInputLayout textInputLayout = findViewById(R.id.inputlayout_login_passwordinput);
        return textInputLayout.getEditText().getText().toString();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    public void register(View view) {
        presenter.registerClicked();
    }

    public void login(View view) {
        presenter.loginClicked();
    }

    public void navigateToOpenActivity() {
        startActivity(new Intent(LoginActivity.this, OpenActivity.class));
    }

    public void showError() {
      //  Toast.makeText(this, "error occurred", Toast.LENGTH_SHORT).show();
    }
}