package com.bukky.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bukky.contactlist.databinding.ContactListItemsBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    private val contacts = mutableListOf<ContactList>()

    inner class ContactViewHolder(private val binding : ContactListItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bindContactData(contactList:ContactList){
            binding.nameTv.text = contactList.name
            binding.numberTv.text = contactList.number
        }
    }
    fun setupContacts(contactList: List<ContactList>){
       this.contacts.addAll(contactList)
           notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
return ContactViewHolder(com.bukky.contactlist.databinding.ContactListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindContactData(contact)

    }

    override fun getItemCount(): Int {
        return contacts.size

    }

}