package com.bukky.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.Editable
import android.text.TextWatcher
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.bukky.contactlist.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter.setupContacts(mutableListOf(ContactList("Bukky", "0000000000"),
            ContactList("Wunmi", "0800000000")))


        setUpData(binding)

    }
     private fun setUpData(binding: ActivityMainBinding){
        binding.contactRv.adapter = adapter
         binding.contactRv.addItemDecoration(DividerItemDecoration(this, GridLayoutManager.VERTICAL))
            val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.category, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val number = view.findViewById<TextView>(R.id.phoneNoEt)
        val save = view.findViewById<TextView>(R.id.save)
        number.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                save.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        val alertDialog = builder.create()
        save.setOnClickListener{
            val contactList =ContactList(name.text.toString(),number.text.toString())
            val contacts = mutableListOf(contactList)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()
        }


        binding.floatbutton.setOnClickListener{
            alertDialog.show()
        }

    }
}