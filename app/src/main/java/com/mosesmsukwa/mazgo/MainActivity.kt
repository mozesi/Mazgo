package com.mosesmsukwa.mazgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mosesmsukwa.mazgo.componets.Home2Screen
import com.mosesmsukwa.mazgo.componets.MazgoAppLandscape
import com.mosesmsukwa.mazgo.componets.MazgoAppPortrait
import com.mosesmsukwa.mazgo.componets.MazgoNavigationBar
import com.mosesmsukwa.mazgo.ui.theme.MazgoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // MazgoAppPortrait()
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            MazgoApp(windowSize =windowSizeClass )
        }
    }
}

@Composable
private fun MazgoApp(windowSize: WindowSizeClass, modifier: Modifier = Modifier) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MazgoAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            MazgoAppLandscape()
        }
    }
    /**
    var showOnBoardingScreen by rememberSaveable { mutableStateOf(true) }

    Surface(
    modifier = modifier,
    color = MaterialTheme.colorScheme.background
    ) {
    if (showOnBoardingScreen) {
    OnBoardingScreen(onContinueClicked = { showOnBoardingScreen = false })
    } else {
    Home2Screen()
    }

    }
     **/


}

@Composable
fun HomeScreen() {

    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp, label = ""
    )
    Column {
        Text(text = "Moses Msukwa")
        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "show less" else "show more")
        }
    }
}


@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {
    Column() {
        Button(onClick = onContinueClicked) {
            Text(text = "continue")
        }

    }
}
