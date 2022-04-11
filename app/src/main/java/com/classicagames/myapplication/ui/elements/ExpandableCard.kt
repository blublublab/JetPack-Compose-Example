package com.classicagames.myapplication.ui.elements

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.classicagames.myapplication.ui.theme.Shapes
import com.classicagames.myapplication.ui.theme.Typography







const val TAG = "EXPANDABLE_CARD"
const val ANIMATION_DURATION = 300

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    titleText: String,
    descriptionText: String,
    titleFontSize: TextUnit = Typography.body1.fontSize,
    descriptionFontSize: TextUnit = Typography.body2.fontSize,
    descriptionLines: Int = 4,
    titleFontFamily: FontFamily? =  Typography.body1.fontFamily,
    descriptionFontFamily : FontFamily? = Typography.body2.fontFamily,
    shape: CornerBasedShape = Shapes.medium
    ){

    var expandedState by remember {
        mutableStateOf(false)
    }
    Log.d(TAG, "Expanded State : $expandedState")

    val rotationState by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )
    Log.d(TAG, "Rotation State : $rotationState")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = ANIMATION_DURATION,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {expandedState = !expandedState},
    ){
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f)
                        .padding(12.dp),
                    text = titleText,
                    fontWeight = FontWeight.Normal,
                    fontFamily = titleFontFamily,
                    fontSize = titleFontSize,
                    fontStyle = Typography.body1.fontStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState)
                        .alpha(ContentAlpha.medium),
                    onClick = { expandedState = !expandedState },
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown ,
                        contentDescription = "Expand Text"
                    )

                }
            }
            if(expandedState){
                Text(
                    text = descriptionText,
                    modifier = Modifier
                        .padding(4.dp),
                    fontWeight = FontWeight.Thin,
                    fontFamily = descriptionFontFamily,
                    fontSize = descriptionFontSize,
                    fontStyle = Typography.body2.fontStyle,
                    maxLines = descriptionLines,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ExpandableCardPreview(){
    Surface(
        modifier = Modifier
                .fillMaxSize(),
        color = Color.Gray,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)) {
            repeat(5){
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ){
                    ExpandableCard(
                        titleText = "Titletest",
                        descriptionText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\",\n",
                    )
                }
            }

        }
    }

}