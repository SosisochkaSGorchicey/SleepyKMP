import androidx.compose.ui.window.ComposeUIViewController
import com.alisa.sleepy.kmp.presentation.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
