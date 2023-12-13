package org.space.invaders.control.music;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicController {
    Clip clip;
    FloatControl volumeControl;
    float volume;

    Musics musics;
    public MusicController()
    {
    }


    public void changeMusic(Musics musics)
    {
        this.musics = musics;
        switch (musics)
        {
            case MENUSOUND -> {
                if(this.clip != null)
                {
                    clip.stop();
                }
                String fileName = "Background.wav";
                String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

                playMusic(filePath);
                adjustVolume();
            }
            case BACKGROUND -> {
                if(this.clip != null)
                {
                    clip.stop();
                }
                String fileName = "MenuSound.wav";
                String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

                playMusic(filePath);
                adjustVolume();
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
                adjustVolume();
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

    public void adjustVolume() {
        String fileName = "sound.txt";
        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

        int musicVolume = readMusicVolume(filePath);
        System.out.println(musicVolume);

        if (clip != null && volumeControl != null) {
            if (clip.isRunning()) {
                // If the clip is running, adjust the volume without restarting
                switch (musicVolume) {
                    case 1 -> volumeControl.setValue(-6f);
                    case 2 -> volumeControl.setValue(-3f);
                    case 3 -> volumeControl.setValue(0f);
                    case 4 -> volumeControl.setValue(3f);
                    case 5 -> volumeControl.setValue(6f);
                }

                this.volume = musicVolume;
            } else {
                // If the clip is not running, start it with the adjusted volume
                playMusic(filePath);
            }
        }
    }


    private static int readMusicVolume(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Music Volume:")) {
                    // Extract the number after "Music Volume:"
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        return Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public Musics getMusics(){return musics;}
}
