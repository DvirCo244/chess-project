package com.example.chessgame.model.pieces;

import com.example.chessgame.model.Chess;

public class Pawn extends Chess{
    private int row;
    private int col;
    private String color;
    private int id;

    public Pawn(int row, int col, String color, int id){
        this.row = row;
        this.col = col;
        this.color = color;
        this.id = id;
    }

    public boolean possibleMove(int fromRow,int fromCol,int toRow,int toCol) {
        if (color.equals("white")) {
            if(fromRow == toRow+1 && fromCol == toCol && pieceAt(toRow , toCol) == null)
                return true;
            else
             if(fromRow == toRow+1 && (fromCol == toCol+1) && pieceAt(toRow,toCol+1) != null
                    && pieceAt(toRow,toCol+1).getPlayer().equals("black"))
                return  true;
            else
                if(fromRow == toRow-1 && (fromCol == toCol-1) && pieceAt(toRow,toCol-1) != null
                    && pieceAt(toRow,toCol-1).getPlayer().equals("black"))
                return  true;
        }
        else if(color.equals("black")) {
            if(fromRow == toRow-1 && fromCol == toCol && pieceAt(toRow , toCol) == null)
                return true;
            else
            if(fromRow == toRow-1 && (fromCol == toCol-1) && pieceAt(toRow,toCol-1) != null
                    && pieceAt(toRow,toCol-1).getPlayer().equals("white"))
                return  true;
           else if(fromRow == toRow-1 && (fromCol == toCol+1) && pieceAt(toRow,toCol+1) != null
                    && pieceAt(toRow,toCol+1).getPlayer().equals("white"))
                return  true;
        }
        return false;
    }
}
