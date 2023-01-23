package com.example.chessgame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chessgame.R;

public class OpenActivity extends AppCompatActivity {
    private OpenPresenter Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        Presenter = new OpenPresenter(this);
    }

    public void logout(View view) {
        Presenter.logoutClicked();
    }

    public void showError() {
     //   Toast.makeText(this, "error occurred", Toast.LENGTH_SHORT).show();
    }

    public void navigateToGame() {
        startActivity(new Intent(this, GameActivity.class));
    }

    public void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void createGame(View view) {
        Presenter.createGameClicked();
    }

    public void joinGame(View view) {
        Presenter.joinGameClicked();
    }
    public String getGameCode(){
        EditText gameCode;
        gameCode = (EditText) findViewById(R.id.editext_open_gamecode);
        return gameCode.getText().toString();
    }
}