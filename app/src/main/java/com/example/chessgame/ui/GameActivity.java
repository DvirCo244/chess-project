package com.example.chessgame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chessgame.R;

public class GameActivity extends AppCompatActivity {
    private GamePresenter presenter;
    private GridLayout gridLayout;
    private ImageView clickedPiece;
    private ImageView removePiece;
    private int fromRow;
    private int toRow;
    private int fromCol;
    private int toCol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gridLayout = findViewById(R.id.gridLayout);
        presenter = new GamePresenter(this);
    }

    public void leaveGame(View view) {
        presenter.leaveGameClicked();
    }

    public void navigateToOpen() {
        startActivity(new Intent(this, OpenActivity.class));
    }

    public void changeCode(String code) {
        TextView gameCodeText;
        gameCodeText = findViewById(R.id.textview_game_gamecode);
        gameCodeText.setText(gameCodeText.getText() + code);
    }
    public void movePiece(int toRow,int toCol,int pieceId){
        clickedPiece = findViewById(pieceId);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(clickedPiece.getLayoutParams());
        params.rowSpec = GridLayout.spec(toRow);
        params.columnSpec = GridLayout.spec(toCol);
        gridLayout.removeView(clickedPiece);
        gridLayout.addView(clickedPiece, params);
    }
    public void removePiece(int pieceId){
        removePiece = findViewById(pieceId);
        gridLayout.removeView(removePiece);
    }
    public void errorOccurredNotValidMove(){
        Toast.makeText(this,"move not possible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                fromRow = (int) y / gridLayout.getChildAt(0).getHeight()-2;
                fromCol = (int) x / gridLayout.getChildAt(0).getWidth();
                break;
            case MotionEvent.ACTION_UP:
                toRow = (int) y / gridLayout.getChildAt(0).getHeight()-2;
                toCol = (int) x / gridLayout.getChildAt(0).getWidth();
                presenter.moveOccurred(fromRow,fromCol,toRow,toCol);

        }
        return true;
    }
}