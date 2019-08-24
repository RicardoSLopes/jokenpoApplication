package br.com.ricardo.jokenpoapplication.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.ricardo.jokenpoapplication.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        if  (savedInstanceState == null) {
            viewModel.initGame()
        }

        rockIm.setOnClickListener {
            viewModel.doAPlay(GameMove.PEDRA)
        }
        paperIv.setOnClickListener {
            viewModel.doAPlay(GameMove.PAPEL)
        }
        scissors.setOnClickListener {
            viewModel.doAPlay(GameMove.TESOURA)
        }
        viewModel.gameLiveData.observe(this, Observer {
            vitoriasTv.text = "Vitórias: ${it.player1Score}"
            derrotasTv.text = "Derrotas: ${it.androidScore}"

            if  (viewModel.isGameFinished()){
                Toast.makeText(this,"Alguem Ganhou!",Toast.LENGTH_LONG).show()
            }
        })




    }







}
