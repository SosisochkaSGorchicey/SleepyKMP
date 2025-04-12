package com.feature.audioContent.presentation.detail.utils

fun Long.toProgressCalculate(duration: Long): Float =
    if (this > 0) (this.toFloat() / duration.toFloat()) * 100f else 0f

//fun AudioItem.toMediaItem(): MediaItem = //todo
//    MediaItem.Builder()
//        .setUri(this.url)
//        .setMediaMetadata( //todo
//            MediaMetadata.Builder()
////                        .setAlbumArtist(audioItem.artist)
////                .setDisplayTitle("Titleee")
//                //.setSubtitle(audioItem.displayName)
//                .build()
//        )
//        .build()
