package com.example.chessgame.model;

public class Game {
    private int lobby_id;
    private String first_user_id;
    private String second_user_id;
    private String current_player;
    private String lastMove;
    public Game(int lobby_id, String first_user_id, String second_user_id, String current_turn){
        this.lobby_id = lobby_id;
        this.first_user_id = first_user_id;
        this.second_user_id = second_user_id;
        this.current_player = current_turn;
        this.lastMove = " ";
    }
    public Game(){

    }

    public void setCurrent_player(String current_player) {
        this.current_player = current_player;
    }

    public String getCurrent_player() {
        return current_player;
    }

    public Game(Game lobby){
        this.lobby_id = lobby.lobby_id;
        this.first_user_id = lobby.first_user_id;
        this.second_user_id = lobby.second_user_id;
    }
    public void setLastMove(String lastMove){
        this.lastMove = lastMove;
    }
    public String getLastMove(){
        return this.lastMove;
    }
    public void setLobby_id(int lobby_id) {
        this.lobby_id = lobby_id;
    }

    public void setFirst_user_id(String first_user_id) {
        this.first_user_id = first_user_id;
    }

    public void setSecond_user_id(String second_user_id) {
        this.second_user_id = second_user_id;
    }

    public int getLobby_id() {
        return lobby_id;
    }

    public String getFirst_user_id() {
        return first_user_id;
    }

    public String getSecond_user_id() {
        return second_user_id;
    }
}
