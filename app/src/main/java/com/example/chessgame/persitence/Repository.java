package com.example.chessgame.persitence;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.chessgame.model.Game;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Repository
{
    private static Repository firebaseManager = null;
    private static FirebaseAuth firebaseAuth = null;
    private static FirebaseDatabase firebaseDatabase = null;
    private Boolean Successful = false;
    private static String gameId = "";
    //private static boolean gameActive = false;
    private Repository()
    {
       firebaseAuth = FirebaseAuth.getInstance();
       firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public static Repository getInstance(){
        if(firebaseManager == null)
            firebaseManager = new Repository();
        return firebaseManager;
    }

    public void reset(){
        firebaseManager = null;
        firebaseDatabase = null;
        firebaseAuth = null;
        Successful = false;
        gameId = null;
    }
    public FirebaseAuth getAUTH() {
        if(firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }

    public FirebaseDatabase getDATABASE(){
        if(firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
        }
        return firebaseDatabase;
    }

    public FirebaseUser getCurrentUser(){
        return firebaseAuth.getCurrentUser();
    }

    public boolean register(String email,String password) {
      Task t=   firebaseAuth.createUserWithEmailAndPassword(email, password);
         t.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                    Successful = true;
                else{
                    Log.e("ruti", "register unsuccesful");
                }
            }
        });
         t.addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Log.e("ruti", e.toString());

             }
         });
        if(Successful){
            Successful = false;
            return true;
        }
        return false;
    }
  /*  public void updateGameStatus(){
        gameActive = true;
    }*/

   /* public void setActivity(){
        DatabaseReference gameActive = firebaseDatabase.getReference("lobbies").child(gameId).child("second_user_id");
        gameActive.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                updateGameStatus();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public String updateGame(){
        DatabaseReference gameStatusRef = firebaseDatabase.getReference("lobbies").child(gameId);
        gameStatusRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lobby lobby = snapshot.getValue(com.example.chessgame.game.lobby.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return "working";
    }*/
    public boolean login(String email,String password){

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Successful = true;
                            }
                        }
                    });
        if(Successful){
            Successful = false;
            return true;
        }
        return false;
    }

    public void updateId(String id){
        gameId = id;
    }
    public String getId(){
        return this.gameId;
    }
    public boolean createGame()
    {
        try {
            DatabaseReference myRef = firebaseDatabase.getReference("lobbies/"+ gameId);
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            Game lobby = new Game(Integer.valueOf(gameId), firebaseAuth.getUid(), null, firebaseAuth.getUid());
            myRef.setValue(lobby);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean joinGame(){
        try {
            DatabaseReference databaseReference = firebaseDatabase.getReference("lobbies").child(gameId);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        Game lobby = snapshot.getValue(Game.class);
                        lobby.setSecond_user_id(firebaseAuth.getUid());
                        databaseReference.setValue(lobby);
                        Successful = true;
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        catch (Exception e){
        }
        return Successful;
    }
}
