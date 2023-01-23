package com.example.chessgame.ui;

import android.util.Log;

import com.example.chessgame.model.Chess;
import com.example.chessgame.persitence.Repository;

public class GamePresenter {
    private GameActivity view;
    private Chess gameModel;

    public GamePresenter(GameActivity view) {
        this.view = view;
        changeCode();
        gameModel = new Chess();
    }

    private void changeCode() {
        view.changeCode(Repository.getInstance().getId());
    }

    public void leaveGameClicked() {
        view.navigateToOpen();
    }

    public void moveOccurred(int fromRow, int fromCol, int toRow, int toCol) {
        int option = gameModel.movePiece(fromCol,toCol,fromRow,toRow);
        switch (option)
        {
            case 0:
                view.errorOccurredNotValidMove();
                return;
            case 1:
                view.movePiece(toRow,toCol,gameModel.pieceAt(toCol,toRow).getId());
                return;
            default:
                view.removePiece(option);
                view.movePiece(toRow,toCol,gameModel.pieceAt(toCol,toRow).getId());
                return;
        }
    }
}