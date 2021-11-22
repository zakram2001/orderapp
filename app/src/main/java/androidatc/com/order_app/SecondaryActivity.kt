package androidatc.com.order_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.activity_main.view.*

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        var name = intent.getStringExtra("name")
        var phone =intent.getStringExtra("phone")
        var email =intent.getStringExtra("email")
        var address =intent.getStringExtra("address")
        var city=intent.getStringExtra("city")
        var state=intent.getStringExtra("state")
        var zip=intent.getStringExtra("zip")
        secondName.text=name
        secondPhone.text=phone
        secondEmail.text=email
        secondAddress.text=address
        secondCity.text=city+ "," + "\t" + state + "\t" + zip
    }

    fun previousOnClick (view:View) {
        var intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}