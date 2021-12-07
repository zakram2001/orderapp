package androidatc.com.order_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.activity_settings.*

class MainActivity : AppCompatActivity() {
    val pref_Name="myPrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var databack: SharedPreferences =getSharedPreferences(pref_Name,0)
        var name = databack.getString("name", "")
        val address = databack.getString("address", "")
        val city = databack.getString("city", "")
        val state = databack.getString("state", "")
        val zip = databack.getInt("zip", 0)
        val phone = databack.getInt("phone", 0)
        val email = databack.getString("email", "")
        nameText.setText(name)
        addressText.setText(address)
        cityText.setText(city)
        stateText.setText(state)
        zipText.setText(zip.toString())
        phoneText.setText(phone.toString())
        emailText.setText(email)

    }

    override fun onStart(){
        super.onStart()
        var databack: SharedPreferences =getSharedPreferences(pref_Name,0)
        var name = databack.getString("name", "")
        val address = databack.getString("address", "")
        val city = databack.getString("city", "")
        val state = databack.getString("state", "")
        val zip = databack.getInt("zip", 0)
        val phone = databack.getInt("phone", 0)
        val email = databack.getString("email", "")

        nameText.setText(name)
        addressText.setText(address)
        cityText.setText(city)
        stateText.setText(state)
        zipText.setText(zip.toString())
        phoneText.setText(phone.toString())
        emailText.setText(email)

    }

    fun onOrderButtonClicked(view: View) {
        var hotDogPrice = 0.00
        var toppingsAndSidePrice = 0.00
        when {
            radioGroup.chickenRadioBtn.isChecked -> hotDogPrice = 1.00
            radioGroup.beefRadioBtn.isChecked -> hotDogPrice = 1.50
            radioGroup.turkeyRadioBtn.isChecked -> hotDogPrice = 2.00
        }

        if (saladCheckBox.isChecked) {
            toppingsAndSidePrice += 2.50
        }
        if (avacadoCheckBox.isChecked) {
            toppingsAndSidePrice += 1.00
        }
        if (friesCheckBox.isChecked) {
            toppingsAndSidePrice += 2.00
        }
        if (mustardCheckBox.isChecked) {
            toppingsAndSidePrice += 1.50
        }
        if (sauceCheckBox.isChecked) {
            toppingsAndSidePrice += 3.00
        }
        if (zucchiniCheckBox.isChecked) {
            toppingsAndSidePrice += 2.00
        }
        orderResult.text = "Your Order Total is: $" + (hotDogPrice + toppingsAndSidePrice)
    }


    fun orderOnClick(view: View) {
        var intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("name", nameText.text.toString())
        intent.putExtra("phone", phoneText.text.toString())
        intent.putExtra("email", emailText.text.toString())
        intent.putExtra("address", addressText.text.toString())
        intent.putExtra("city", cityText.text.toString())
        intent.putExtra("state", stateText.text.toString())
        intent.putExtra("zip", zipText.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.help -> {
                this.startActivity(Intent(this, HelpActivity::class.java))
                return true
            }
            R.id.settings -> {
                this.startActivity(Intent(this, SettingsActivity::class.java))
                return true
            }

            R.id.login -> {
                this.startActivity(Intent(this, LoginActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}




