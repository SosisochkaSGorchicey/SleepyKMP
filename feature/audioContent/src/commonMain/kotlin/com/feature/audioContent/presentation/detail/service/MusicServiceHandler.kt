package com.feature.audioContent.presentation.detail.service

//todo all
class MusicServiceHandler(
    //private val exoPlayer: Player,
) {
    //: Player.Listener {
//
//    private val _musicStates: MutableStateFlow<MusicStates> = MutableStateFlow(MusicStates.Initial)
//    val musicStates: StateFlow<MusicStates> = _musicStates.asStateFlow()
//
//    private var job: Job? = null
//
//    init {
//        runCatching {
//            exoPlayer.addListener(this)
//        }
//    }
//
//    @androidx.annotation.OptIn(UnstableApi::class)
//    override fun onPlayerError(error: PlaybackException) {
//        val cause = error.cause
//        when (cause) {
//            is FileDataSource.FileDataSourceException -> {}
//            is HttpDataSource.HttpDataSourceException ->
//                _musicStates.value = MusicStates.ConnectionError
//        }
//    }
//
//    fun setMediaItem(mediaItem: MediaItem) {
//        runCatching {
//            exoPlayer.setMediaItem(mediaItem)
//        }
//    }
//
//    suspend fun onMediaStateEvents(
//        mediaStateEvents: MediaStateEvents,
//        selectedMusicIndex: Int = -1,
//        seekPosition: Long = 0,
//    ) {
//        withContext(Dispatchers.Main) {
//            println("TAG: onMediaStateEvents $mediaStateEvents")
//            when (mediaStateEvents) {
//                MediaStateEvents.Backward -> exoPlayer.seekBack()
//                MediaStateEvents.Forward -> exoPlayer.seekForward()
//                MediaStateEvents.PlayPause -> playPauseMusic()
//                MediaStateEvents.SeekTo -> exoPlayer.seekTo(seekPosition)
//                MediaStateEvents.Stop -> stopProgressUpdate()
//                is MediaStateEvents.SelectedMusicChange -> {
//                    exoPlayer.prepare()
//
//                    when (selectedMusicIndex) {
//                        exoPlayer.currentMediaItemIndex -> {
//                            playPauseMusic()
//                        }
//
//                        else -> {
//                            exoPlayer.setMediaItem(
//                                MediaItem.fromUri(mediaStateEvents.url)
//                            )
//                            exoPlayer.seekToDefaultPosition(selectedMusicIndex)
//                            _musicStates.value = MusicStates.MediaPlaying(
//                                isPlaying = true
//                            )
//                            exoPlayer.playWhenReady = true
//                            startProgressUpdate()
//                        }
//                    }
//                }
//
//                is MediaStateEvents.MediaProgress -> {
//                    exoPlayer.seekTo(
//                        (exoPlayer.duration * mediaStateEvents.progress).toLong()
//                    )
//                }
//            }
//        }
//    }
//
//    override fun onPlaybackStateChanged(playbackState: Int) {
//        when (playbackState) {
//            ExoPlayer.STATE_BUFFERING -> _musicStates.value =
//                MusicStates.MediaBuffering(exoPlayer.currentPosition)
//
//            ExoPlayer.STATE_READY -> _musicStates.value = MusicStates.MediaReady(exoPlayer.duration)
//
//            Player.STATE_ENDED -> exoPlayer.seekToDefaultPosition()
//
//            Player.STATE_IDLE -> Unit
//        }
//    }
//
//    @OptIn(DelicateCoroutinesApi::class)
//    override fun onIsPlayingChanged(isPlaying: Boolean) {
//        _musicStates.value = MusicStates.MediaPlaying(isPlaying = isPlaying)
//        if (isPlaying) {
//            GlobalScope.launch(Dispatchers.Main) { //todo!!!!!!!
//                startProgressUpdate()
//            }
//        } else {
//            stopProgressUpdate()
//        }
//    }
//
//    private suspend fun playPauseMusic() {
//        if (exoPlayer.isPlaying) {
//            exoPlayer.pause()
//            stopProgressUpdate()
//        } else {
//            exoPlayer.prepare()
//            exoPlayer.play()
//            _musicStates.value = MusicStates.MediaPlaying(
//                isPlaying = true
//            )
//            startProgressUpdate()
//        }
//    }
//
//    private suspend fun startProgressUpdate() = job.run {
//        while (true) {
//            delay(500)
//            _musicStates.value = MusicStates.MediaProgress(exoPlayer.currentPosition)
//        }
//    }
//
//    private fun stopProgressUpdate() {
//        job?.cancel()
//        _musicStates.value = MusicStates.MediaPlaying(isPlaying = false)
//    }
}