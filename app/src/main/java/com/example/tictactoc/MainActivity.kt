package com.example.tictactoc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Buselect (view :View){
        val choise=view as Button
        var cellid= 0
        when(choise.id){
            R.id.btn1->cellid=1
            R.id.btn2->cellid=2
            R.id.btn3->cellid=3
            R.id.btn4->cellid=4
            R.id.btn5->cellid=5
            R.id.btn6->cellid=6
            R.id.btn7->cellid=7
            R.id.btn8->cellid=8
            R.id.btn9->cellid=9


        }

       Log.d("cellid",cellid.toString())
        PlayGame(cellid,choise)

    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1
    fun PlayGame(cellid:Int,buChoise:Button) {

        if (activePlayer==1){
            buChoise.setBackgroundResource(R.color.Bleu)
            buChoise.text="X"
            activePlayer=2
            player1.add(cellid)
        }else{
            buChoise.setBackgroundResource(R.color.Vert)
            buChoise.text="O"
            activePlayer=1
            player2.add(cellid)


        }
        buChoise.isEnabled()
        CheckWiner()
    }
     fun CheckWiner(){
         var winner=-1
         if (player1.contains(1)&& player1.contains(2)&& player1.contains(3) || player1.contains(4)&& player1.contains(5)&& player1.contains(6)
             ||player1.contains(7)&& player1.contains(8)&& player1.contains(9) || player1.contains(1)&& player1.contains(4)&& player1.contains(7)
             ||player1.contains(2)&& player1.contains(5)&& player1.contains(8) ||player1.contains(3)&& player1.contains(6)&& player1.contains(9)) {
             winner = 1
         }
         if (player2.contains(1)&& player2.contains(2)&& player2.contains(3) || player2.contains(4)&& player2.contains(5)&& player2.contains(6)
             ||player2.contains(7)&& player2.contains(8)&& player2.contains(9) || player2.contains(1)&& player2.contains(4)&& player2.contains(7)
             ||player2.contains(2)&& player2.contains(5)&& player2.contains(8) ||player2.contains(3)&& player2.contains(6)&& player2.contains(9)) {
             winner =2
         }
         if (winner!=-1) {
             if (winner == 1) {
                 Toast.makeText(this, "Player1 win the game ", Toast.LENGTH_LONG).show()
             } else {
                 Toast.makeText(this, "Player2 win the game ", Toast.LENGTH_LONG).show()
             }
         }

     }
}
