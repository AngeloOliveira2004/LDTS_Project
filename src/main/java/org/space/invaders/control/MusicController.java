package org.space.invaders.control;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class MusicController {
    Clip clip;
    URL soundURL[] = new URL[5];
    public MusicController(){
        soundURL[0] = getClass().getResource("/Resources/Background.wav");
        soundURL[1] = getClass().getResource("/Resources/MenuBackground.wav");
        soundURL[2] = getClass().getResource("/Resources/Moving.wav");
        soundURL[3] = getClass().getResource("/Resources/Shot.wav");
        soundURL[4] = getClass().getResource("/Resources/GotHit.wav");
    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
