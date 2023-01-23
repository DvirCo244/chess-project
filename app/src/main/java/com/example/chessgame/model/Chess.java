package com.example.chessgame.model;

import android.util.Log;
import android.widget.ImageView;

import com.example.chessgame.R;
import com.example.chessgame.model.pieces.ChessPiece;

public class Chess {
   private static ChessPiece pieceBox[][] = {
           { new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.ROOK, R.drawable.blackcastle_new,R.id.black_castle),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.KNIGHT, R.drawable.blackknight_new,R.id.black_knight),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.BISHOP, R.drawable.blackbishop_new,R.id.black_bishop),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.QUEEN, R.drawable.blackqueen_new,R.id.black_queen),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.KING, R.drawable.blackking_new,R.id.black_king),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.BISHOP, R.drawable.blackbishop_new,R.id.black_bishop_2),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.KNIGHT, R.drawable.blackknight_new,R.id.black_knight_2),
                   new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.ROOK, R.drawable.blackcastle_new,R.id.black_castle_2),},
          {new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_0),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_1),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_2),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_3),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_4),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_5),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_6),
                  new ChessPiece(ChessPiece.ChessPlayer.BLACK, ChessPiece.Type.PAWN, R.drawable.blackpawn_new,R.id.black_pawn_7)},
           {null,null,null,null,null,null,null,null},
           {null,null,null,null,null,null,null,null},
           {null,null,null,null,null,null,null,null},
           {null,null,null,null,null,null,null,null},
          {
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_0),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_1),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_2),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_3),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_4),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_5),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_6),
                  new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.PAWN, R.drawable.whitepawn_new, R.id.white_pawn_7),
          },
           {new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.ROOK, R.drawable.whitecastle_new,R.id.white_castle),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.KNIGHT, R.drawable.whiteknight_new,R.id.white_knight),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.BISHOP, R.drawable.whitebishop_new,R.id.white_bishop),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.QUEEN, R.drawable.whitequeen_new,R.id.white_queen),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.KING, R.drawable.whiteking_new,R.id.white_king),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.BISHOP, R.drawable.whitebishop_new,R.id.white_bishop_2),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.KNIGHT, R.drawable.whiteknight_new,R.id.white_knight_2),
                           new ChessPiece(ChessPiece.ChessPlayer.WHITE, ChessPiece.Type.ROOK, R.drawable.whitecastle_new,R.id.white_castle_2),
                   }
   };
   public Chess(){
   }
   public int movePiece(int fromCol,int toCol,int fromRow,int toRow){
        int minimumRow = 0;
       int maximumRow = 7;
       if(fromRow>maximumRow || fromRow < minimumRow
               || fromCol > maximumRow || fromCol <minimumRow
               || toCol>maximumRow || toCol<minimumRow
               || toRow>maximumRow || toRow<minimumRow || pieceBox[fromRow][fromCol] == null)
           return 0;
       ChessPiece piece = pieceBox[fromRow][fromCol];

       switch(piece.getType()){
           case "PAWN":
               return pawnMoveCheck(fromRow,fromCol,toRow,toCol);
           case "ROOK":
               return rookMoveCheck(fromRow,fromCol,toRow,toCol);
           case "KNIGHT":
               return knightMoveCheck(fromRow,fromCol,toRow,toCol);
           case "BISHOP":
               return bishopMoveCheck(fromRow,fromCol,toRow,toCol);
           case "KING":
               return kingMoveCheck(fromRow,fromCol,toRow,toCol);
           case "QUEEN":
               return queenMoveCheck(fromRow,fromCol,toRow,toCol);
           default:
               return 0;
       }
   }
    public int pawnMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
       int id;
       ChessPiece piece = pieceBox[fromRow][fromCol];
       if(fromRow == toRow)
           return 0;
        if(fromCol == toCol){
            if(pieceBox[toRow][toCol] != null)
                return 0;
        }
        if(toCol == fromCol-1)
            if(pieceBox[toRow][toCol] == null)
                return 0;
        if(toCol == fromCol+1)
            if(pieceBox[toRow][toCol] == null)
                return 0;
        if(fromCol -toCol >1 || fromCol -toCol <-1)
            return 0;
    if(piece.getPlayer().equals("WHITE")){
           if((fromRow-toRow) != 1 && fromRow != 6 )
               return 0;
            if(fromRow == 6 && toRow != 4  && toRow != 5)
                return 0;
           if(fromRow == 6 && toRow == 4){
               if(pieceBox[toRow][toCol] != null || pieceBox[toRow+1][toCol] != null)
                   return 0;
           }
       }
    else {
        if((toRow-fromRow) != 1 && fromRow != 1)
            return 0;
        if(fromRow == 1 && toRow != 3 && toRow != 2)
            return 0;
        if(fromRow == 1 && toRow == 3){
            if(pieceBox[toRow][toCol] != null || pieceBox[toRow-1][toCol] != null)
                return 0;
        }
    }
       if(pieceBox[toRow][toCol] != null) {
           id = pieceBox[toRow][toCol].getId();
           pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol, fromRow));
           pieceBox[fromRow][fromCol] = null;
           return id;
       }

        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol, fromRow));
        pieceBox[fromRow][fromCol] = null;
        return 1;
    }

    //----------------------------------------------------------------------------------
    public int rookMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol,fromRow));
        pieceBox[fromRow][fromCol] = null;
        Log.e("rook","rook moved");
        return 1;
    }
    //----------------------------------------------------------------------------------
    public int bishopMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol,fromRow));
        pieceBox[fromRow][fromCol] = null;
        Log.e("bishop","bishop moved");
        return 1;
    }
    //----------------------------------------------------------------------------------
    public int knightMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol,fromRow));
        pieceBox[fromRow][fromCol] = null;
        Log.e("knight","knight moved");
        return 1;
    }
    //----------------------------------------------------------------------------------
    public int kingMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol,fromRow));
        pieceBox[fromRow][fromCol] = null;
        Log.e("king","king moved");
        return 1;
    }
    //----------------------------------------------------------------------------------
    public int queenMoveCheck(int fromRow,int fromCol,int toRow,int toCol){
        pieceBox[toRow][toCol] = new ChessPiece(pieceAt(fromCol,fromRow));
        pieceBox[fromRow][fromCol] = null;
        Log.e("queen","queen moved");
        return 1;
    }
    //----------------------------------------------------------------------------------
   public ChessPiece pieceAt(int col,int row){
    return pieceBox[row][col];
   }
}
