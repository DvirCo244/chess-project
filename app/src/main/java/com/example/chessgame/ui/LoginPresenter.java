package com.example.chessgame.ui;

import com.example.chessgame.persitence.Repository;

public class LoginPresenter {
    private static LoginActivity view;

    public LoginPresenter(LoginActivity view) {
        this.view = view;
        Repository.getInstance().reset();
    }

    public void registerClicked() {
        String email,password;
        email = view.getEmail();
        password = view.getPassword();
        if (Repository.getInstance().register(email, password))
            view.navigateToOpenActivity();
        else
            view.showError();
    }

    public void loginClicked() {
        String email,password;
        email = view.getEmail();
        password = view.getPassword();
        if (Repository.getInstance().login(email, password))
            view.navigateToOpenActivity();
        else
            view.showError();
    }

    public void onStart() {
        if (Repository.getInstance().getCurrentUser() != null) {
            view.navigateToOpenActivity();
        }
        view.showError();
    }
}
