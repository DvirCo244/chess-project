package com.example.chessgame.model.pieces;

import android.util.Log;

import com.example.chessgame.model.Chess;

public class ChessPiece {
    private ChessPlayer player;
    private  Type pieceType;
    private int resID;
    private int id;
public enum ChessPlayer{
    WHITE,
    BLACK
}
public enum Type{
    KING,
    QUEEN,
    BISHOP,
    ROOK,
    KNIGHT,
    PAWN
}
    public ChessPiece(ChessPlayer player, Type type, int resID, int id){
        this.player = player;
        this.pieceType = type;
        this.resID = resID;
        this.id = id;
    }
    public ChessPiece(ChessPiece piece){
        this.player = piece.player;
        this.pieceType = piece.pieceType;
        this.resID = piece.resID;
        this.id = piece.id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType(){
        if(pieceType == Type.KING)
            return "KING";
        else
            if(pieceType == Type.QUEEN)
        return "QUEEN";
            else
        if(pieceType == Type.ROOK)
            return "ROOK";
        else
        if(pieceType == Type.BISHOP)
            return "BISHOP";
        else
        if(pieceType == Type.KNIGHT)
            return "KNIGHT";
        else
            return "PAWN";
    }
    public String getPlayer(){
    if(player == ChessPlayer.WHITE)
        return "WHITE";
    else
        return "BLACK";
    }

    public void printPiece() {
        String piece = "ChessPiece{" +
                ", player=" + player +
                ", pieceType=" + pieceType +
                ", resID=" + resID +
                '}';
        Log.e("piece",piece);
    }
}
