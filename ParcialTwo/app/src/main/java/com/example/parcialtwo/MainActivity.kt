package com.example.parcialtwo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.parcialtwo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        changeImage()
        binding.submitButton.setOnClickListener{
            addNamecharacter(it)
        }

    }
    private fun  changeImage()
    {
        binding.apply {
            photoIma.setImageResource(R.drawable.ironman)
            movie1Ima.setImageResource(R.drawable.peli_1)
            movie2Ima.setImageResource(R.drawable.peli_2)
            movie3Ima.setImageResource(R.drawable.peli_3)
            movie4Ima.setImageResource(R.drawable.peli_4)
        }
    }

    private fun addNamecharacter (view: View){
        binding.apply {
            if (nameCharacterText.text.toString().toUpperCase().trim()==nameSubmitEdit.text.toString().toUpperCase().trim())
            {
                nameCharacterText.visibility=TextView.VISIBLE
                view.submit_button.visibility=TextView.GONE
                nameSubmitEdit.visibility=TextView.GONE
            }
            else
            {
                Toast.makeText(applicationContext,"Nombre incorrecto, Pista: No me quiero ir Sr. stark.", Toast.LENGTH_SHORT).show()
                nameSubmitEdit.setText("")
            }
            //hide keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}


