package br.com.fiap.challengedeemail.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.fiap.challengedeemail.ui.theme.Blue200
import br.com.fiap.challengedeemail.ui.theme.Blue500
import br.com.fiap.challengedeemail.ui.theme.Blue700

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 4.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Blue500, Blue200)),
    animatioDuration: Int = 100000,
    content: @Composable () -> Unit
){

    val infiniteTransition = rememberInfiniteTransition(label = "Animação de cores infinitas")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animatioDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Cores infinitas"
    )

    Surface(
        modifier = modifier,
        shape = shape
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn
                        )
                    }
                    drawContent()
                },
            color = Blue700,
            shape = shape
        ) {
            content()
        }
    }
}