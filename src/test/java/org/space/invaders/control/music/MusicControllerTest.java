package org.space.invaders.control.music;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.space.invaders.control.game.KamikazeController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.space.invaders.control.music.MusicController.readMusicVolume;

public class MusicControllerTest {
    private MusicController musicController;
    private Clip mockClip;
    private FloatControl mockVolumeControl;

    @BeforeEach
    void setUp() {
        musicController = new MusicController();
        mockClip = mock(Clip.class);
        mockVolumeControl = mock(FloatControl.class);
        musicController.clip = mockClip;
        musicController.volumeControl = mockVolumeControl;
    }

    @Test
    void testChangeMusic_MenuSound() {
        musicController = mock(MusicController.class);
        musicController.clip = mockClip;
        musicController.volumeControl = mockVolumeControl;

        doAnswer(invocation -> {
            mockClip.start();
            mockVolumeControl.setValue(anyFloat());
            return null;

        }).when(musicController).changeMusic(Musics.MENUSOUND);

        musicController.changeMusic(Musics.MENUSOUND);

        verify(mockVolumeControl, times(1)).setValue(anyFloat());
        verify(mockClip, times(1)).start();

        musicController = new MusicController();

        musicController.changeMusic(Musics.MENUSOUND);

        assertEquals(Musics.MENUSOUND , musicController.getMusics());
        assertNotNull(musicController.getClip().toString());
    }

    @Test
    void testChangeMusic_Background() {
        musicController = mock(MusicController.class);
        musicController.clip = mockClip;
        musicController.volumeControl = mockVolumeControl;

        doAnswer(invocation -> {
            mockClip.start();
            mockVolumeControl.setValue(anyFloat());
            return null;

        }).when(musicController).changeMusic(Musics.BACKGROUND);

        musicController.changeMusic(Musics.BACKGROUND);

        verify(mockVolumeControl, times(1)).setValue(anyFloat());
        verify(mockClip, times(1)).start();

        musicController = new MusicController();

        musicController.changeMusic(Musics.BACKGROUND);

        assertEquals(Musics.BACKGROUND , musicController.getMusics());
        assertNotNull(musicController.getClip().toString());
    }

    @Test
    void testPlayMusic_FileExists() {
        musicController = new MusicController();
        String fileName = "Background.wav";
        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

        musicController.playMusic(filePath);
        System.out.println(musicController.getClip());
        assertTrue(musicController.getClip().isRunning());

        String newFileName = "MenuSound.wav";
        String newFilePath = System.getProperty("user.dir") + "/src/main/Resources/" + newFileName;
        musicController.playMusic(newFilePath);
        System.out.println(musicController.getClip());
        assertTrue(musicController.getClip().isRunning());

    }

    @Test
    void testPlayMusic_FileDoesNotExist() {
        String nonExistingFilePath = "non/existing/path";
        musicController.playMusic(nonExistingFilePath);
        verify(mockClip, never()).start(); // Clip should not start if file does not exist
    }

    @Test
    void testAdjustVolume_MenuSound() {
        musicController = new MusicController();
        musicController.changeMusic(Musics.MENUSOUND);

        String fileName1 = "sound.txt";
        String filePath1 = System.getProperty("user.dir") + "/src/main/Resources/" + fileName1;

        assertEquals(Musics.MENUSOUND , musicController.getMusics());

        int musicVolume = readMusicVolume(filePath1);

        float volume = 0f;

        switch (musicVolume) {
            case 0 -> volume = Float.NEGATIVE_INFINITY;
            case 1 -> volume = -6f ;
            case 2 -> volume = -3f ;
            case 3 -> volume = 0f ;
            case 4 -> volume = 3f ;
            case 5 -> volume = 6f ;
        }
        double roundedValue = Math.round(musicController.getVolumeControl().getValue());
        assertEquals(Math.round( volume) , roundedValue);
    }

    @Test
    void testAdjustVolume_Background() {

        //TODO maybe change the switch to an interface

        musicController = new MusicController();
        musicController.changeMusic(Musics.BACKGROUND);
        
        String fileName1 = "sound.txt";
        String filePath1 = System.getProperty("user.dir") + "/src/main/Resources/" + fileName1;

        int musicVolume = readMusicVolume(filePath1);

        float volume = 0f;
        switch (musicVolume) {
            case 0 -> volume = Float.NEGATIVE_INFINITY;
            case 1 -> volume = -19f ;
            case 2 -> volume = -18f ;
            case 3 -> volume = -17f ;
            case 4 -> volume = -16f ;
            case 5 -> volume = -15f ;
        }
        double roundedValue = Math.round(musicController.getVolumeControl().getValue());
        assertEquals(Math.round(volume) , roundedValue);
    }

    @Test
    void testReadMusicVolumeGibberish()
    {
        String filePath1 = "gibberish";
        int musicVolume = readMusicVolume(filePath1);
        assertEquals(-1 , musicVolume);
    }
    @Test
    void testGetMusics() {
        musicController.changeMusic(Musics.MENUSOUND);
        Musics result = musicController.getMusics();
        assert result == Musics.MENUSOUND;

        musicController.changeMusic(Musics.BACKGROUND);
        Musics result2 = musicController.getMusics();
        assert result2 == Musics.BACKGROUND;
    }

    @Test
    void testStop() {
        musicController.stop();
        verify(mockClip).stop();
    }
}

