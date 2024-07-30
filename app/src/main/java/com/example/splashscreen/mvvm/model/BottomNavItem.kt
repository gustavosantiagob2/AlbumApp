
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.CloudDownload
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Home : BottomNavItem(
        "Home",
        "Home",
        Icons.Rounded.Home
    )
    object Albums : BottomNavItem(
        "Albums",
        "Albums",
        Icons.Rounded.Album
    )
    object Download : BottomNavItem(
        "Download",
        "Download",
        Icons.Rounded.CloudDownload
    )
    object Favorite : BottomNavItem(
        "Favorite",
        "Favorite",
        Icons.Rounded.FavoriteBorder
    )
    object Profile : BottomNavItem(
        "Profile",
        "Profile",
        Icons.Rounded.AccountCircle
    )
}