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


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //title and back bar
        val actionbar = supportActionBar
        actionbar!!.title = "Settings"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //saves and stores information so user doesn't have to enter it over and over again
        val pref =getPreferences(Context.MODE_PRIVATE)
        val name = pref.getString("name", "")
        val address = pref.getString("address", "")
        val city = pref.getString("city", "")
        val state = pref.getString("state", "")
        val zip = pref.getInt("zip", 0)
        val phone = pref.getInt("phone", 0)
        val email = pref.getString("email", "")
        storeName.setText(name)
        storeAddress.setText(address)
        storeCity.setText(city)
        storeState.setText(state)
        storeZip.setText(zip.toString())
        storePhone.setText(phone.toString())
        storeEmail.setText(email)

    }
    //goes back to previous activity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    //saves information entered, display toast and sends information to fields in main activity
    fun saveOnClick (view:View) {

        val pref =getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

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

        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", storeName.getText().toString())
        intent.putExtra("phone", storePhone.getText().toString())
        intent.putExtra("email", storeEmail.getText().toString())
        intent.putExtra("address", storeAddress.getText().toString())
        intent.putExtra("city", storeCity.getText().toString())
        intent.putExtra("state", storeState.getText().toString())
        intent.putExtra("zip", storeZip.getText().toString())
        startActivity(intent)
    }

    //clears information entered
    fun clearOnClick(view:View) {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()


        val toast = Toast.makeText(applicationContext, "Clear", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM, 0, 140)
        toast.show()
    }

}
