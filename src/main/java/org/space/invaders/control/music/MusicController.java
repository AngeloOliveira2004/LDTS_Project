package org.space.invaders.control.music;
import java.io.File;
import javax.sound.sampled.*;

public class MusicController {
    Clip clip;
    FloatControl volumeControl;
    float volume;
    public MusicController(Musics musics)
    {
        switch (musics)
        {
            case MENUSOUND -> {
                if(this.clip != null)
                {
                    clip.stop();
                }
                String path = "Background.wav";
                playMusic(path);
            }
            case HIT -> {
                String path = "GotHit.wav";
                playOnce(path);
            }
            case BACKGROUND -> {
                String path = "MenuSound.wav";
                playOnce(path);
            }
            case SHOOT -> {
                String path = "Shot.wav";
                playOnce(path);
            }
            case MOVING -> {
                String path = "Moving.wav";
                playOnce(path);
            }
        }
    }

    public void playMusic(String location)
    {
        try {
            File musicPath = new File(location);

            if(musicPath.exists()){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                this.clip = clip;
                this.volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                adjustVolume(-10.0f);
                clip.start();
            }
            else
            {

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void playOnce(String location){
        try {
            File musicPath = new File(location);

            if(musicPath.exists()){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                clip.start();
                clip.drain();
                clip.stop();
            }
            else
            {

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void adjustVolume(float value){
        this.volume = value;
        this.volumeControl.setValue(value);
    }
}

/*
        soundURL[0] = getClass().getResource("/Resources/Background.wav");
                soundURL[1] = getClass().getResource("/Resources/MenuBackground.wav");
                soundURL[2] = getClass().getResource("/Resources/Moving.wav");
                soundURL[3] = getClass().getResource("/Resources/Shot.wav");
                soundURL[4] = getClass().getResource("/Resources/GotHit.wav");

 */