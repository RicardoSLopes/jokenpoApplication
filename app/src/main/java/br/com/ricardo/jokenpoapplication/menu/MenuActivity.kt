package br.com.ricardo.jokenpoapplication.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ricardo.jokenpoapplication.R
import br.com.ricardo.jokenpoapplication.game.GameActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        bt_start.setOnClickListener{
            startActivity(Intent(this, GameActivity::class.java))
        }
    }




}
