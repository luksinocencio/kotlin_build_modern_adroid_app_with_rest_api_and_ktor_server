package com.devmeist3r.borutoapp.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devmeist3r.borutoapp.R
import com.devmeist3r.borutoapp.ui.theme.StarColor

@Composable
fun RatingWidget(
    modifier: Modifier = Modifier,
    rating: Double
) {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    FilledStar(starPath = starPath, starPathBounds = starPathBounds)
}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float = 2f
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = this.size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = starPath,
                    color = StarColor
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun FilledStarPreview() {
    RatingWidget(rating = 1.0)
}
