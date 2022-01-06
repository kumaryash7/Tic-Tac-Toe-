package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoe.R.drawable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Button btn0;
  Button btn1;
  Button btn2;
  Button btn3;
  Button btn4;
  Button btn5;
  Button btn6;
  Button btn7;
  Button btn8;
  TextView headertext;
  int PLAYER_O=0;
  int PLAYER_X=1;

  int activePlayer=PLAYER_O;
  int[] filledPos={-1,-1,-1,-1,-1,-1,-1,-1,-1};
  boolean isGameActive=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headertext = findViewById(R.id.header_text);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        //LOFIC FOR BUTTONS


        Button clickedBtn=findViewById(v.getId());
        int clickedTag =Integer.parseInt(v.getTag().toString());


        if(filledPos[clickedTag]!=-1){
            return;
        }
        filledPos[clickedTag]=activePlayer;

        if(activePlayer==PLAYER_O){
            clickedBtn.setText("O");
            clickedBtn.setBackground(getDrawable(android.R.color.holo_blue_bright));
            activePlayer=PLAYER_X;

            headertext.setText(" X Turn");
    }
        else {
            clickedBtn.setText("X");
            clickedBtn.setBackground(getDrawable(android.R.color.holo_orange_light));
            activePlayer=PLAYER_O;
            headertext.setText("O Turn");
        }

        checkForWin();

}

    private void checkForWin() {

        //CHECKING WHO IS WINNER
        int[][] winningPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        for(int i=0;i<8;i++){
            int val0 =winningPos[i][0];
            int val1 =winningPos[i][1];
            int val2 =winningPos[i][2];

            if(filledPos[val0]==filledPos[val1] && filledPos[val1]==filledPos[val2]){
                if(filledPos[val0]!=-1)
                //winner is declared


                    if(filledPos[val0]==PLAYER_O)
                showDialog("O is Winner");
                else
                    showDialog("X is winner");

                }


            }
        }private void showDialog(String winnerText){
        new AlertDialog.Builder(this)
                .setTitle(winnerText)
                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame();
                    }
                })
                .show();
    }

    private void restartGame() {
        activePlayer=PLAYER_O;
        filledPos=new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");

    }
    }
