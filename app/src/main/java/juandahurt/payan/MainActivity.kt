package juandahurt.payan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import juandahurt.purace.ui.basic.PuraceTextView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuraceTextView(text = "gjfhdgs")
        }
    }
}