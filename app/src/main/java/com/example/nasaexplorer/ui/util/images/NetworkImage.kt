package com.example.nasaexplorer.ui.util.images

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntSize
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.bumptech.glide.request.transition.Transition
import com.example.nasaexplorer.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


import timber.log.Timber

@Composable
fun GlideImage(
    modifier: Modifier = Modifier,
    url: String,
    defaultImage: Int = R.drawable.cute_alien,
    errorImage: Int = R.drawable.error_img,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    onImageReady: (() -> Unit)? = null,
    customize: RequestBuilder<Bitmap>.() -> RequestBuilder<Bitmap> = { this },
) {
    BoxWithConstraints {
        val image = remember { mutableStateOf<ImageBitmap?>(null) }
        val drawable = remember { mutableStateOf<Drawable?>(null) }
        val context = LocalContext.current

        DisposableEffect(key1 = url, effect = {
            val glide = Glide.with(context)
            var target: CustomTarget<Bitmap>? = null
            val job = CoroutineScope(Dispatchers.Main).launch {
                target = object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        image.value = null
                        drawable.value = placeholder
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        image.value = null
                        drawable.value = errorDrawable
                    }

                    override fun onLoadStarted(placeholder: Drawable?) {
                        image.value = null
                        drawable.value = placeholder
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?,
                    ) {
                        image.value = resource.asImageBitmap()
                        onImageReady?.invoke()
                    }
                }

                val size = constraints.run {
                    IntSize(
                        if (maxWidth in 1 until Int.MAX_VALUE) maxWidth else SIZE_ORIGINAL,
                        if (maxHeight in 1 until Int.MAX_VALUE) maxHeight else SIZE_ORIGINAL
                    )
                }

                glide
                    .asBitmap()
                    .load(url)
                    .override(size.width, size.height)
                    .let(customize)
                    .placeholder(defaultImage)
                    .error(errorImage)
                    .into(target!!)
            }

            onDispose {
                image.value = null
                drawable.value = null
                glide.clear(target)
                job.cancel()
            }
        })

        NasaExplorerImageWidget(
            image = image.value,
            drawable = drawable.value,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            alpha = alpha,
            colorFilter = colorFilter
        )
    }
}