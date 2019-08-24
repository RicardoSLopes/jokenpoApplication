package br.com.ricardo.jokenpoapplication.splash

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ricardo.jokenpoapplication.R
import br.com.ricardo.jokenpoapplication.menu.MenuActivity

class SplashScreenActivity : AppCompatActivity() {

    interface OnTaskExecute {
        fun onExecute()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        SleepTask().execute(object : OnTaskExecute {
            override fun onExecute() {
                startNextActivity()
            }
        })
    }

    fun startNextActivity(){
        startActivity(Intent(this, MenuActivity::class.java))
    }


    class SleepTask: AsyncTask<OnTaskExecute, Void, OnTaskExecute?>(){
        override fun doInBackground(vararg p0: OnTaskExecute?): OnTaskExecute? {
            Thread.sleep(3000)
            return p0[0]
        }

        override fun onPostExecute(result: OnTaskExecute?) {
            super.onPostExecute(result)
            result?.onExecute()
        }
    }





}
