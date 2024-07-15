package ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(dp: Int, modifier: Modifier = Modifier) = Spacer(modifier = modifier.height(dp.dp))

@Composable
fun VerticalSpacer(space: Dp, modifier: Modifier = Modifier) = Spacer(modifier = modifier.height(space))

@Composable
fun HorizontalSpacer(dp: Int, modifier: Modifier = Modifier) = Spacer(modifier = modifier.width(dp.dp))

@Composable
fun HorizontalSpacer(space: Dp, modifier: Modifier = Modifier) = Spacer(modifier = modifier.width(space))

