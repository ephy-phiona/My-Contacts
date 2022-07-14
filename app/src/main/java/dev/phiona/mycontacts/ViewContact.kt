package dev.phiona.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.phiona.mycontacts.databinding.ActivityMainBinding
import dev.phiona.mycontacts.databinding.ActivityViewContactBinding
import dev.phiona.mycontacts.databinding.ContactListItemBinding

class ViewContact : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
    val extras=intent.extras
        
    var name=extras?.getString("NAME","")
    var phone=extras?.getString("PHONE_NUMBER","")
     var email=extras?.getString("EMAIL")
     var address=extras?.getString("LOCATION")
        var image=binding.imgProfile




    Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,phone,Toast.LENGTH_SHORT).show()
        binding.tvName2.text=name
        binding.tvPhoneNumber.text=phone
        binding.tvEmail2.text=email
        binding.tvLocation2.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)

}
 }