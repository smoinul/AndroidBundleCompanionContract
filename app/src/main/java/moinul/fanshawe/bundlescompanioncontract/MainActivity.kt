package moinul.fanshawe.bundlescompanioncontract

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import moinul.fanshawe.bundlescompanioncontract.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        var tv1: String = ""
    }
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun onResume() {
        super.onResume()
        mainBinding.TV1.text = tv1

        val myPreferences = getSharedPreferences("mySettings", Context.MODE_PRIVATE)
        mainBinding.editTextName.setText(myPreferences.getString("name", ""))
        mainBinding.editTextNum.setText(myPreferences.getInt("num", 0).toString())

    }

    override fun onPause() {
        super.onPause()
        val myPreferences = getSharedPreferences("mySettings", Context.MODE_PRIVATE).edit()
        myPreferences.putString("name", mainBinding.editTextName.text.toString())
        myPreferences.putInt("num", mainBinding.editTextNum.text.toString().toInt())
        myPreferences.apply()
    }

    fun onClickCompanion(view: View) {
        tv1 = mainBinding.editText1.text.toString()
        mainBinding.TV1.text = tv1
    }

    fun onClickSecond(view: View) {
        val secondIntent: Intent = Intent(this, ChangingCompanionValue::class.java)
        startActivity(secondIntent)
    }

    fun onSendBundle(view: View) {
        var myBundle = Bundle()
        myBundle.putString("name", mainBinding.editTextName.text.toString())
        myBundle.putInt("num", mainBinding.editTextNum.text.toString().toInt())
        val thirdIntent:Intent = Intent(this, BundleReceiver::class.java)
        thirdIntent.putExtras(myBundle)
        startActivity(thirdIntent)
    }

    fun onCheckResults(view: View) {
        val contractIntent: Intent = Intent(this, ContractActivity::class.java).apply {
            putExtra("value", mainBinding.editTextContract.text.toString())
        }
        resultLauncher.launch(contractIntent)
    }

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        when(result.resultCode){
            Activity.RESULT_OK -> {
                Toast.makeText(this, "Result OK", Toast.LENGTH_SHORT).show()
            }
            Activity.RESULT_CANCELED -> {
                Toast.makeText(this, "Result Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}