package androidatc.com.order_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onOrderButtonClicked (view: View) {
        var hotDogPrice = 0.00
        var toppingsAndSidePrice = 0.00
        when {
            radioGroup.chickenRadioBtn.isChecked -> hotDogPrice =1.00
            radioGroup.beefRadioBtn.isChecked -> hotDogPrice =1.50
            radioGroup.turkeyRadioBtn.isChecked -> hotDogPrice =2.00
        }

        if (saladCheckBox.isChecked) {toppingsAndSidePrice +=2.50}
        if (avacadoCheckBox.isChecked) {toppingsAndSidePrice +=1.00}
        if (friesCheckBox.isChecked) {toppingsAndSidePrice +=2.00}
        if (mustardCheckBox.isChecked) {toppingsAndSidePrice +=1.50}
        if (sauceCheckBox.isChecked) {toppingsAndSidePrice +=3.00}
        if (zucchiniCheckBox.isChecked) {toppingsAndSidePrice +=2.00}
        orderResult.text="Your Order Total is: $"+(hotDogPrice+toppingsAndSidePrice)
    }

    fun orderOnClick (view:View) {
        var intent= Intent(this, SecondaryActivity::class.java)
        intent.putExtra("name", nameText.text.toString())
        intent.putExtra("phone", phoneText.text.toString())
        intent.putExtra("email", emailText.text.toString())
        intent.putExtra("address", addressText.text.toString())
        intent.putExtra("city", cityText.text.toString())
        intent.putExtra("state", stateText.text.toString())
        intent.putExtra("zip", zipText.text.toString())
        startActivity(intent)
    }
}



