package dev.phiona.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.phiona.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact1=Contact("Phiona","0741454086","phiona@gmail.com","616 Korongoroad","https://images.pexels.com/photos/12610414/pexels-photo-12610414.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2=Contact("Tamara","011513648","tamara@gmail.com","Komarocks","https://images.pexels.com/photos/5873743/pexels-photo-5873743.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3=Contact("Alice","0726158629","awino@gmail.com","Komarocks phase3","https://images.pexels.com/photos/9743326/pexels-photo-9743326.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4=Contact("Joe","0780025273","joe@gmail.com","Buruburu","https://images.pexels.com/photos/1149362/pexels-photo-1149362.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact5=Contact("Meare","1243484906","meare@gmail.com","Buruburu","https://images.pexels.com/photos/11038878/pexels-photo-11038878.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contactlist= listOf(contact1,contact2,contact3,contact4,contact5)
        var contactsAdapter=ContactsRvAdapter(contactlist)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }
}