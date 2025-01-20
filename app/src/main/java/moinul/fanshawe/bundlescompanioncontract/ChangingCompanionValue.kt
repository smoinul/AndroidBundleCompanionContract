package moinul.fanshawe.bundlescompanioncontract

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import moinul.fanshawe.bundlescompanioncontract.databinding.ActivityChangingCompanionValueBinding

class ChangingCompanionValue : AppCompatActivity() {
    lateinit var changingCompanionValueBinding: ActivityChangingCompanionValueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changingCompanionValueBinding = ActivityChangingCompanionValueBinding.inflate(layoutInflater)
        setContentView(changingCompanionValueBinding.root)
    }

    override fun onResume() {
        super.onResume()
        changingCompanionValueBinding.editText2.setText(MainActivity.tv1)
    }

    fun onClickChange(view: View) {
        MainActivity.tv1 = changingCompanionValueBinding.editText2.text.toString()
    }
    fun onClickPrev(view: View) {
        val prevIntent: Intent = Intent(this, MainActivity::class.java)
        startActivity(prevIntent)
    }
}