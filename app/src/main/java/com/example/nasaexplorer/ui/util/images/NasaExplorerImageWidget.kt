package com.example.nasaexplorer.ui.util.images

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import timber.log.Timber


@Composable
fun NasaExplorerImageWidget(
    modifier: Modifier = Modifier,
    image: ImageBitmap? = null,
    drawable: Drawable?  = null,
    drawableId: Int? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    when {
        image != null -> {
            Image(
                bitmap = image,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alignment = alignment,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }
        drawable != null -> {
            Image(
                painter = drawable.toPainter(),
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alignment = alignment,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }
        drawableId != null -> {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alignment = alignment,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }
        else -> {
            Timber.i("everything was null")
        }
    }
}