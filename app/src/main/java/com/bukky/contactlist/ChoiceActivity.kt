package com.bukky.contactlist

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bukky.contactlist.databinding.ChoiceBinding

class ChoiceActivity :AppCompatActivity() {
     private lateinit var binding: ChoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun choiceAction (view: View){
        Intent(this,MainActivity::class.java ).also {
//            it.putStringArrayListExtra()
            startActivity(it)
        }

    }

}