package juandahurt.payan.modules.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import juandahurt.purace.ui.basic.text.PuraceTextView
import juandahurt.purace.ui.basic.image.PuraceImageView
import juandahurt.purace.ui.style.PuraceStyle

@Composable
fun FeedPageView() {
    Column {
        PlaceCategories()
    }
}
// region Place categories
private const val placeCategoryTitle = "Explora lugares"
private const val placeCategorySubtitle = "Adentrate en el corazón de la ciudad blanca"
private const val dummyImage = "https://payan-dev-images.s3.us-east-2.amazonaws.com/santo-domingo.jpg" // TODO: remove

@Composable
fun PlaceCategories() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        PlaceCategoriesHeader()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PlaceCategory()
            PlaceCategory()
            PlaceCategory()
            PlaceCategory()
        }
    }
}

@Composable
fun PlaceCategoriesHeader() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .fillMaxWidth()
    ) {
        PuraceTextView(
            text = placeCategoryTitle,
            size = 22,
            weight = FontWeight.Medium
        )
        PuraceTextView(
            text = placeCategorySubtitle,
            color = PuraceStyle.Color.N3
        )
    }
}

@Composable
fun PlaceCategory() {
    val localConfiguration = LocalConfiguration.current
    val screenHeight = localConfiguration.screenHeightDp.dp

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.18f)
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
    ) {
        PuraceImageView(
            url = dummyImage,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .zIndex(1f),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,
                        )
                    )
                )
                .zIndex(2f)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(3f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.weight(1.0f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp, vertical = 13.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PuraceTextView(
                        text = "Iglesias",
                        size = 16,
                        weight = FontWeight.Medium,
                        color = Color.White
                    )
                    PuraceTextView(
                        text = "3 lugares",
                        color = Color.White,
                        size = 10
                    )
                }
            }
        }
    }
}
// endregion