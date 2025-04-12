package com.feature.audioContent.presentation.detail.service

//todo all
class PlaybackService
//    : MediaSessionService(), MediaSession.Callback {
//    private val mediaSession: MediaSession by inject<MediaSession>()
//
//    @UnstableApi
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
//    }
//
//    override fun onTaskRemoved(rootIntent: Intent?) {
//        super.onTaskRemoved(rootIntent)
//        stopSelf()
//    }
//
//    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession =
//        mediaSession
//
//    override fun onDestroy() {
//        println("TAG: SERVICE onDestroy")
//        mediaSession.apply {
//            release()
//            player.release()
//        }
//        super.onDestroy()
//    }
//}