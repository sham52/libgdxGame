package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class AppPreferences {
    private static final String PREF_MUSIC_VOLUME = "volume";
    private static final String PREF_MUSIC_ENABLED = "music.enabled";
    private static final String PREF_SOUND_ENABLED = "sound.enabled";
    private static final String PREF_SOUND_VOL = "sound";
    private static final String PREFS_NAME = "mygame";

    protected Preferences getPrefs(){
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public float getSoundVolume(){
        return getPrefs().getFloat(PREF_SOUND_VOL,0.5f);
    }
    public void setSoundVolume(float volume){
        getPrefs().putFloat(PREF_SOUND_VOL,volume);
        getPrefs().flush();
    }
    public void setMusicEnabled(boolean musicEnabled){
        getPrefs().putBoolean(PREF_MUSIC_ENABLED,musicEnabled);
        getPrefs().flush();
    }
    public boolean isMusicEnabled(){
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED,true);
    }
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled){
        getPrefs().putBoolean(PREF_SOUND_ENABLED,soundEffectsEnabled);
        getPrefs().flush();
    }
    public boolean isSoundEffectsEnabled(){
        return getPrefs().getBoolean(PREF_SOUND_ENABLED,true);
    }

    public float getMusicVolume(){
        return getPrefs().getFloat(PREF_MUSIC_VOLUME,0.5f);
    }

    public void setMusicVolume(float volume){
        getPrefs().putFloat(PREF_MUSIC_VOLUME,volume);
        getPrefs().flush();
    }



}
