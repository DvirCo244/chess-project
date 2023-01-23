package com.example.chessgame.ui;

import com.example.chessgame.persitence.Repository;

import java.util.Random;

public class OpenPresenter {
    private OpenActivity view;

    public OpenPresenter(OpenActivity view) {
        this.view = view;
    }

    public void logoutClicked() {
        Repository.getInstance().getAUTH().signOut();
        view.navigateToLogin();
    }

    public void createGameClicked() {
        int maxId = 9999999;
        String gameCode;
        int lobbyId;
        Random rand;
        rand = new Random();
        lobbyId = rand.nextInt(maxId);
        gameCode = String.format("%06d", lobbyId);
        Repository.getInstance().updateId(gameCode);
        if (Repository.getInstance().createGame())
            view.navigateToGame();
        else
            view.showError();
    }

    public void joinGameClicked() {
        Repository.getInstance().updateId(view.getGameCode());
        if (Repository.getInstance().joinGame())
            view.navigateToGame();
        else
            view.showError();
    }
}
