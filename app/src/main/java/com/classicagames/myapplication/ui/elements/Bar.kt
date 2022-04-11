package com.classicagames.myapplication.ui.elements

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.classicagames.myapplication.R


@Composable
fun AppBar(){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(80.dp),
                painter= painterResource(id = R.drawable.logo),
                contentDescription = "Home"
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings" )
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FloatingBottomButton(visible : Boolean){
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + scaleIn(),
        exit =  fadeOut() + scaleOut(),
    ) {
            FloatingActionButton(onClick = {}){
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = "Place"
                )
            }
        }
}
