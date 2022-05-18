package com.joel.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

/* @Immutable
data class ExpandableCard(
    val id: Int,
    val title: String
)

class ExpandableViewModel : ViewModel(){

} */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimationCard(){
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
            ),

        onClick = {
            expandedState != expandedState
        },
        elevation = 20.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "My title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,

                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState!=expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow")
                }
                Text(
                    text = "In order to qualify to advance " +
                            "to Application Phase please watch" +
                            " 1 hour of " +
                            "content in the Associate Android " +
                            "Foundations Channel" +
                            " (2022)/Foundational Deep Dive " +
                            "(2022) and take your" +
                            " Skill IQ outlined below and complete " +
                            "this Phase before" +
                            " June 2, 2022.")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ExpandableCardPreview(){
    AnimationCard()
}
