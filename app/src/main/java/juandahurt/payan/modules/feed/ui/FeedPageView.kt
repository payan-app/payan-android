package juandahurt.payan.modules.feed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
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
import juandahurt.payan.core.network.NetworkManager
import juandahurt.payan.modules.feed.data.FeedDataRemoteDataRepository
import juandahurt.payan.modules.feed.interfaces.FeedService
import juandahurt.payan.modules.feed.models.FeedData
import juandahurt.payan.modules.feed.models.FeedPlaceCategory
import juandahurt.purace.ui.basic.text.PuraceTextView
import juandahurt.purace.ui.basic.image.PuraceImageView
import juandahurt.purace.ui.style.PuraceStyle
import retrofit2.Retrofit
import retrofit2.create

@Composable
fun FeedPageView(viewModel: FeedViewModel) {
    if (viewModel.viewState.value.isLoading) {
        CircularProgressIndicator()
    }
    if (viewModel.viewState.value.data != null) {
        PlaceCategories(data = viewModel.viewState.value.data!!)
    }
}
// region Place categories
private const val placeCategoryTitle = "Explora lugares"
private const val placeCategorySubtitle = "Adentrate en el corazón de la ciudad blanca"
private const val dummyImage = "https://payan-dev-images.s3.us-east-2.amazonaws.com/santo-domingo.jpg" // TODO: remove

@Composable
fun PlaceCategories(data: FeedData) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            PlaceCategoriesHeader()
        }
        items(data.placeCategories.size) { index ->
            PlaceCategory(data = data.placeCategories[index])
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
fun PlaceCategory(data: FeedPlaceCategory) {
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
            url = data.imageUrl,
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
                        text = data.title,
                        size = 16,
                        weight = FontWeight.Medium,
                        color = Color.White
                    )
                    PuraceTextView(
                        text = "${data.numberOfPlaces} lugares",
                        color = Color.White,
                        size = 10
                    )
                }
            }
        }
    }
}
// endregion