package com.classicagames.myapplication.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.classicagames.myapplication.R



@Composable
fun CustomTitleText(text : String, textAlign: TextAlign = TextAlign.Start){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h2.fontSize,
                    color = MaterialTheme.colors.secondary
                )
                ){
                    append(text[0])
                }
                withStyle(style = SpanStyle(
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (3.5).sp,

                    baselineShift = BaselineShift(+0.3f)
                )
                ){
                    append(text.removeRange(0, 1))
                }
            },
            textAlign = textAlign,
            modifier = Modifier.fillMaxWidth(),
        )
    }


}
