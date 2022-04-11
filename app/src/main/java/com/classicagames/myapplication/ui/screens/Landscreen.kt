package com.classicagames.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.classicagames.myapplication.R
import com.classicagames.myapplication.model.entity.Card
import com.classicagames.myapplication.model.entity.cards
import com.classicagames.myapplication.ui.elements.FloatingBottomButton
import com.classicagames.myapplication.ui.elements.ItemCard
import com.classicagames.myapplication.ui.theme.CustomTitleText


@Composable
fun LandScreen(){
    val clickedCards = remember {
        mutableStateListOf<Card>()
    }
    Scaffold(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = contentColorFor(MaterialTheme.colors.background)
            .takeOrElse { LocalContentColor.current },
        floatingActionButton = { FloatingBottomButton(clickedCards.size >= 3) },
        topBar = { com.classicagames.myapplication.ui.elements.AppBar() },
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
        ){
            TopicsText(stringResource(id = R.string.choose_topics))

            CustomTitleText(text = "Flexibility", TextAlign.Start)
            CustomTitleText(text = "Mobility", TextAlign.Center)
            CustomTitleText(text = "Fast learning", TextAlign.Start)
            CustomTitleText(text = "Development", TextAlign.Center)
            CustomTitleText(text = "Healthcare", TextAlign.Start)

            TopicsGrid(cards = cards, clickedCards = clickedCards)
        }

    }
}

@Composable
private fun TopicsText(text : String){
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.End,
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 16.dp),
    )
}


@Composable
private fun TopicsGrid(cards: List<Card>, rowNumbers: Int = 2, clickedCards: MutableList<Card>) {
    val cardLists = cards.chunked(cards.size/rowNumbers)
    Column(
        modifier = Modifier
            .padding(vertical = 32.dp)
    ) {
                repeat(rowNumbers) {
                    val additionalHorizontalPadding = if (it % 2 == 1) it.dp * 10 else 0.dp
                    LazyRow(
                        modifier = Modifier
                            .padding(start = 8.dp + additionalHorizontalPadding, bottom = 5.dp),
                        ) {
                        items(cardLists[it]) { card ->
                            ItemCard(card) { clicked ->
                                if (clicked) clickedCards.add(card) else clickedCards.remove(card)
                            }
                        }
                    }
                }
            }

}