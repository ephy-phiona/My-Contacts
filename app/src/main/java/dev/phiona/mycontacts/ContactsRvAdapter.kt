package dev.phiona.mycontacts

import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.phiona.mycontacts.databinding.ContactListItemBinding

class ContactsRvAdapter(var contactList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
//        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        val context=holder.itemView.context
        with(holder.binding){
            tvName.text=currentContact.name
            tvEmail.text=currentContact.email
            tvNumber.text=currentContact.phone
            tvAddress.text=currentContact.address

            Picasso.get().load(currentContact.image)
                .resize(500,500)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .into(imgContact)

            cvContacts.setOnClickListener{
                val intent=Intent(context, ViewContact::class.java)
                intent.putExtra("NAME",currentContact.name)
                intent.putExtra("PHONE_NUMBER",currentContact.phone)
                intent.putExtra("LOCATION",currentContact.address)
                intent.putExtra("EMAIL",currentContact.email)
                intent.putExtra("IMAGE",currentContact.image)
                context.startActivity(intent)
            }
            holder.binding.imgContact.setOnClickListener{
                Toast.makeText(context,"You have clicked on my face!",Toast.LENGTH_LONG)
                    .show()
            }

        }
    }

    override fun getItemCount(): Int {
        return  contactList.size
    }
}
class ContactsViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){
   

    }
