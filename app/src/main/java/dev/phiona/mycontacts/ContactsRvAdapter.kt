package dev.phiona.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class ContactsRvAdapter(var contactList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return ContactsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        holder.tvName.text=currentContact.name
        holder.tvEmail.text=currentContact.email
        holder.tvNumber.text=currentContact.phone
        holder.tvAddress.text=currentContact.address
    }

    override fun getItemCount(): Int {
        return  contactList.size
    }
}
class ContactsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
   var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvAddress=itemView.findViewById<TextView>(R.id.tvAddress)
    var tvNumber=itemView.findViewById<TextView>(R.id.tvNumber)
    var imgContact=itemView.findViewById<ImageView>(R.id.imgContact)

    }