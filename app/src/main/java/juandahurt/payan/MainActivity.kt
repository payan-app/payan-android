package juandahurt.payan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import juandahurt.payan.modules.feed.FeedBuilder
import juandahurt.payan.modules.feed.ui.FeedPageView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedBuilder()
                .Build()
        }
    }
}