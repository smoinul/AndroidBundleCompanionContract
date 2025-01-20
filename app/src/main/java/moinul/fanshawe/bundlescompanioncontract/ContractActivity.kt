package moinul.fanshawe.bundlescompanioncontract

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import moinul.fanshawe.bundlescompanioncontract.databinding.ActivityContractBinding

class ContractActivity : AppCompatActivity() {
    lateinit var contractBinding: ActivityContractBinding
    var passedValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contractBinding = ActivityContractBinding.inflate(layoutInflater)
        setContentView(contractBinding.root)
        passedValue = intent.extras!!.getString("value", "0").toString().toInt()
    }

    override fun onResume() {
        super.onResume()
        contractBinding.textViewValue.setText(passedValue.toString())
    }

    fun onClickResult(view: View) {
        val backToHome : Intent = Intent(this, MainActivity::class.java)
        var enteredValue: Int = contractBinding.ETEnteredNum.text.toString().toInt()
        if(passedValue*2 == enteredValue){
            setResult(RESULT_OK, backToHome)
            finish()
        }
        else{
            setResult(RESULT_CANCELED, backToHome)
            finish()
        }
    }
}