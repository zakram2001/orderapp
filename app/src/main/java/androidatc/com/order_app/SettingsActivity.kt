package androidatc.com.order_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    val pref_Name = "myPrefs"
    var myPref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnClear = findViewById<Button>(R.id.clearButton)

        //title and back bar
        val actionbar = supportActionBar
        actionbar!!.title = "Settings"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //saves and stores information so user doesn't have to enter it over and over again
        var databack: SharedPreferences = getSharedPreferences(pref_Name, 0)
        val name = databack.getString("name", "")
        val address = databack.getString("address", "")
        val city = databack.getString("city", "")
        val state = databack.getString("state", "")
        val zip = databack.getInt("zip", 0)
        val phone = databack.getInt("phone", 0)
        val email = databack.getString("email", "")
        storeName.setText(name)
        storeAddress.setText(address)
        storeCity.setText(city)
        storeState.setText(state)
        storeZip.setText(zip.toString())
        storePhone.setText(phone.toString())
        storeEmail.setText(email)


        btnClear.setOnClickListener(View.OnClickListener {
            myPref = getSharedPreferences(pref_Name, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()
            editor.clear()
            editor.commit()
            storeName.setText("").toString()
            storeAddress.setText("").toString()
            storeCity.setText("").toString()
            storeState.setText("").toString()
            storeZip.setText("".toString())
            storePhone.setText("".toString())
            storeEmail.setText("").toString()

            val toast = Toast.makeText(applicationContext, "Cleared", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM, 0, 140)
            toast.show()


        })

    }

    //goes back to previous activity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    //saves information entered, display toast and sends information to fields in main activity
    fun saveOnClick(view: View) {

        myPref = getSharedPreferences(pref_Name, 0)
        var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

        editor.putString("name", storeName.text.toString())
        editor.putString("address", storeAddress.text.toString())
        editor.putString("city", storeCity.text.toString())
        editor.putString("state", storeState.text.toString())
        editor.putInt("zip", storeZip.text.toString().toInt())
        editor.putInt("phone", storePhone.text.toString().toInt())
        editor.putString("email", storeEmail.text.toString())
        editor.commit()

        val toast = Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM, 0, 140)
        toast.show()


    }
}


