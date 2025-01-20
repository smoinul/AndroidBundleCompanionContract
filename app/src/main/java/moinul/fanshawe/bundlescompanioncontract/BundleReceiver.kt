package moinul.fanshawe.bundlescompanioncontract

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import moinul.fanshawe.bundlescompanioncontract.databinding.ActivityBundleReceiverBinding

class BundleReceiver : AppCompatActivity() {
    lateinit var bundleReceiverBinding: ActivityBundleReceiverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundleReceiverBinding = ActivityBundleReceiverBinding.inflate(layoutInflater)
        setContentView(bundleReceiverBinding.root)
    }

    override fun onResume() {
        super.onResume()
        val receivedBundle = intent.extras
        bundleReceiverBinding.TVName.setText(receivedBundle!!.getString("name", "not-provided"))
        bundleReceiverBinding.TVNum.setText(receivedBundle!!.getInt("num", 0).toString())
    }
}