
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreensNavigation(val route: String, val label: String, val icon: ImageVector) {
    object Home : BottomScreensNavigation(
        "Home",
        "Home",
        Icons.Rounded.Home
    )
    object Albums : BottomScreensNavigation(
        "Albums",
        "Albums",
        Icons.Rounded.Album
    )
    object Download : BottomScreensNavigation(
        "Download",
        "Download",
        Icons.Rounded.CloudDownload
    )
    object Favorite : BottomScreensNavigation(
        "Favorite",
        "Favorite",
        Icons.Rounded.FavoriteBorder
    )
    object Profile : BottomScreensNavigation(
        "Profile",
        "Profile",
        Icons.Rounded.AccountCircle
    )
}