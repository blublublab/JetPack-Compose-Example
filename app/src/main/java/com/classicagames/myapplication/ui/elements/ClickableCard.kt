package com.classicagames.myapplication.ui.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.classicagames.myapplication.R
import com.classicagames.myapplication.model.entity.Card


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(card: Card, onClick: (isClicked: Boolean) -> Boolean){
    var clickedState by remember { mutableStateOf(false) }
    val animateColor = animateColorAsState(
        targetValue = if (clickedState) MaterialTheme.colors.secondary else MaterialTheme.colors.onSecondary,
        animationSpec = tween(300)
    )
    Card(
        modifier = Modifier
            .padding(10.dp)
            .height(70.dp),
        elevation = 10.dp,
        onClick = {
            clickedState = !clickedState
            onClick(clickedState)
        },
            backgroundColor = animateColor.value
    ){
        Row {
            Image(
                modifier = Modifier
                    .fillMaxHeight(),
                painter =  painterResource(id = card.imageId),
                contentDescription = card.name
            )
            Column(
                modifier = Modifier
                    .height(70.dp)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = card.name,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Start,
                    color = if(!clickedState) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSecondary,
                )
            }
        }
    }

}


@Composable
@Preview
fun ClickableCardPreview(){
    ItemCard(card = Card("preview", 32, R.drawable.item_interior)) {}
}