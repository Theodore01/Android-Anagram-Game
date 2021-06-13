package com.example.teo.anagramgame;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Teo on 20/2/2018.
 */

public class CommonMethod {
    public static MediaPlayer player;
    public static void SoundPlayer(Context ctx, int raw_id){
        player = MediaPlayer.create(ctx, raw_id);
        if (player.isPlaying()) {
            player.stop();
        }
        else{
            player.setLooping(false);
            player.setVolume(100, 100);
            try {
                player.prepare();
            } catch (Exception e) {
                System.out.println("Error with playback");
            }
            player.start();
        }
    }
}
