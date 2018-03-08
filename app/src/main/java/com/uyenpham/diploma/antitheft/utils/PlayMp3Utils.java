package com.uyenpham.diploma.antitheft.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;

public class PlayMp3Utils {

    private static MediaPlayer mediaPlayer;

    public static void stopSong() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }

    public static void playSongInRaw(Context context, int sound) throws IOException {
        mediaPlayer = MediaPlayer.create(context, sound);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public static void playSongInPath(Context context, Uri path) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.reset();
        mediaPlayer.setDataSource(context,path);
        mediaPlayer.prepare();
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public static void setVolume(float volume){
        mediaPlayer.setVolume(volume, volume);
    }

    public static boolean checkUri(Uri uri, Context context){
        boolean isValid;
        ContentResolver cr = context.getContentResolver();
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cur = cr.query(uri, projection, null, null, null);
        if (cur != null) {
            if (cur.moveToFirst()) {
                String filePath = cur.getString(0);
                isValid = new File(filePath).exists();
            } else {
                isValid = false;
            }
            cur.close();
        } else {
            isValid = false;
        }
        return isValid;
    }
}