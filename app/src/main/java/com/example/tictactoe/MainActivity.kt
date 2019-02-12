package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    protected fun btnClick(view: View){
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }

        Toast.makeText(this, "ID: $cellID", Toast.LENGTH_LONG).show()

        playGame(cellID, btnSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, btnSelected: Button) {
        if (activePlayer == 1){
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        }else{
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            activePlayer = 1
        }

        btnSelected.isEnabled = false

        checkWinner();
    }

    private fun checkWinner(){
        var winner = -1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //column 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //diagonal right to left
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }
        //diagonal left to right
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1)
                Toast.makeText(this, "Player 1 Win the Game!", Toast.LENGTH_LONG).show();
            else if(winner == 2)
                Toast.makeText(this, "Player 2 Win the Game!", Toast.LENGTH_LONG).show();
        }
    }

    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        var r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells[randIndex]

        var btnSelect:Button?
        when (cellId){
            1-> btnSelect = btn1
            2-> btnSelect = btn2
            3-> btnSelect = btn3
            4-> btnSelect = btn4
            5-> btnSelect = btn5
            6-> btnSelect = btn6
            7-> btnSelect = btn7
            8-> btnSelect = btn8
            9-> btnSelect = btn9
            else -> {
                btnSelect = btn1
            }
        }

        playGame(cellId, btnSelect)
    }
}
