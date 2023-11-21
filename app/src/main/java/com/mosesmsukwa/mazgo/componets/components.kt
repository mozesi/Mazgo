package com.mosesmsukwa.mazgo.componets

import android.content.res.Resources
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mosesmsukwa.mazgo.R
import com.mosesmsukwa.mazgo.ui.theme.MazgoTheme


@Composable
fun Home2Screen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.heightIn(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.heightIn(16.dp))
        HomeSection(title = "Word Types") {
            WordTypesComponent()
        }
        Spacer(modifier = Modifier.heightIn(16.dp))

        HomeSection(title = "Favourite Words") {
            FavouriteWordsComponent()
        }
    }
}

@Composable
fun HeaderComponent() {
    Surface(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Moses")
            Text(text = "Moses")

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = { Text(text = "Penjani") },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
fun WordTypeElement(
    @DrawableRes imageDrawable: Int,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageDrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            modifier = Modifier.paddingFromBaseline(24.dp, 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FavouriteWord(
    @DrawableRes imageDrawable: Int,
    name: String, modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.width(255.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imageDrawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun WordTypesComponent() {
    val items = listOf<String>("Moses", "Msukwa", "Moses", "Msukwa", "Moses", "Msukwa")
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(items) { item ->
            WordTypeElement(imageDrawable = R.drawable.education, name = item.toString())
        }
    }
}

@Composable
fun FavouriteWordsComponent(modifier: Modifier = Modifier) {
    val items = listOf<String>("Moses", "Msukwa", "Moses", "Msukwa", "Moses", "Msukwa")
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier.height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            FavouriteWord(imageDrawable = R.drawable.house, name = item)
        }

    }
}

@Composable
fun HomeSection(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Text(
        text = title, style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .paddingFromBaseline(40.dp, 16.dp)
            .padding(horizontal = 16.dp)
    )
    content()
}

@Composable
fun MazgoNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier, containerColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            label = { Text(text = "Home") },
            selected = true,
            onClick = { /*TODO*/ })

        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = { Text(text = "Profile") },
            selected = true,
            onClick = { /*TODO*/ })
    }
}

@Composable
fun MazgoNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                },
                label = { Text(text = "Home") },
                selected = true,
                onClick = { /*TODO*/ })

            NavigationRailItem(
                icon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                label = { Text(text = "Profile") },
                selected = true,
                onClick = { /*TODO*/ })
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MazgoAppPortrait() {
    MazgoTheme {
        Scaffold(bottomBar = { MazgoNavigationBar() }) { padding ->
            Home2Screen(Modifier.padding(padding))
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MazgoAppLandscape() {
    MazgoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                MazgoNavigationRail()
                Home2Screen()
            }
        }
    }
}