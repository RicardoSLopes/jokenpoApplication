package br.com.ricardo.jokenpoapplication.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val gameLiveData = MutableLiveData<Game>()
    private val game = Game(0,0)


    fun initGame(){
        game.androidScore = 0
        game.player1Score = 0
        gameLiveData.postValue(game)
    }

    fun goalPlayer(){
        game.player1Score = game.player1Score.plus(1)
        gameLiveData.postValue(game)
    }

    fun goalAndroid(){
        game.androidScore = game.androidScore.plus(1)
        gameLiveData.postValue(game)
    }

    fun isGameFinished(): Boolean{
        if (game.player1Score == 2 || game.androidScore == 2){
            return true
        }
        return false
    }

    fun doAPlay(playerMove: GameMove){
        val androidMove = GameMove.TESOURA
        if (playerMove == androidMove){
            return
        }

        var youWin = false
        when(playerMove){
            GameMove.PEDRA -> youWin = androidMove == GameMove.TESOURA
            GameMove.PAPEL -> youWin = androidMove == GameMove.PEDRA
            GameMove.TESOURA -> youWin = androidMove == GameMove.PAPEL
        }
        if  (youWin){
            goalPlayer()
        }else{
            goalAndroid()
        }
    }
}