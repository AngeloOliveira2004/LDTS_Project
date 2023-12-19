package org.space.invaders.control.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.space.invaders.control.game.KamikazeController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import com.googlecode.lanterna.input.KeyStroke;
import org.space.invaders.model.game.elements.ShotElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerControllerTest {

    @Mock
    private SpaceShip spaceShip;
    @Mock
    private Arena arena;

    @Mock
    private ShotFactory shotFactory;

    private PlayerController playerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        spaceShip = Mockito.mock(spaceShip.getClass());
        playerController = new PlayerController(spaceShip);
    }

    @Test
    public void testSwitchSpaceShips() {
        when(spaceShip.isMini()).thenReturn(false);

        playerController.switchSpaceShips();

        verify(spaceShip).toggleMini(true);
    }

    @Test
    public void testKeyPressedArrowLeftNormal() {

        spaceShip = new SpaceShip(500,15,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        int expected = spaceShip.getXposition();
        KeyType keyType = KeyType.ArrowLeft;

        for(int i = 0 ; i < 505 ; i++)
        {
            if(expected > 0 && expected < 600){
                expected -= 1;
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(expected , spaceShip.getXposition());
            assertEquals(15 , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowRightNormal() {
        spaceShip = new SpaceShip(10,15,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        int expected = spaceShip.getXposition();
        KeyType keyType = KeyType.ArrowRight;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected < 600-27){
                expected += 1;
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(expected , spaceShip.getXposition());
            assertEquals(15 , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowUpNormal() {
        spaceShip = new SpaceShip(10,250,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        int expected = spaceShip.getYposition();
        KeyType keyType = KeyType.ArrowUp;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected > 0){
                expected -= 1;
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(10 , spaceShip.getXposition());
            assertEquals(expected , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowDownNormal() {
        spaceShip = new SpaceShip(10,5,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        int expected = spaceShip.getYposition();
        KeyType keyType = KeyType.ArrowDown;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected < 300-26){
                expected += 1;
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(10 , spaceShip.getXposition());
            assertEquals(expected , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowLeftMini() {

        spaceShip = new SpaceShip(500,15,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        spaceShip.toggleMini(true);
        int expected = spaceShip.getXposition();
        KeyType keyType = KeyType.ArrowLeft;

        for(int i = 0 ; i < 505 ; i++)
        {
            if(expected > 0 && expected < 600){
                expected -= spaceShip.getXVelocity();
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(expected , spaceShip.getXposition());
            assertEquals(15 , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowRightMini() {
        spaceShip = new SpaceShip(10,15,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        spaceShip.toggleMini(true);
        int expected = spaceShip.getXposition();
        KeyType keyType = KeyType.ArrowRight;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected < 600-15){
                expected += spaceShip.getXVelocity();
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(expected , spaceShip.getXposition());
            assertEquals(15 , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowUpMini() {
        spaceShip = new SpaceShip(10,250,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        spaceShip.toggleMini(true);
        int expected = spaceShip.getYposition();
        KeyType keyType = KeyType.ArrowUp;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected > 0){
                expected -= spaceShip.getYVelocity();
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(10 , spaceShip.getXposition());
            assertEquals(expected , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedArrowDownMini() {
        spaceShip = new SpaceShip(10,5,1,1,1,0,true,1,1);
        playerController = new PlayerController(spaceShip);
        spaceShip.toggleMini(true);

        int expected = spaceShip.getYposition();
        KeyType keyType = KeyType.ArrowDown;

        for(int i = 0 ; i < 600 ; i++)
        {
            if(expected < 300-30){
                expected += spaceShip.getYVelocity();
            }

            playerController.keyPressed(new KeyStroke(keyType), arena);
            assertEquals(10 , spaceShip.getXposition());
            assertEquals(expected , spaceShip.getYposition());
        }
    }

    @Test
    public void testKeyPressedEnter() {
        KeyType keyType = KeyType.Enter;
        playerController.keyPressed(new KeyStroke(keyType), arena);
        verify(spaceShip).toggleMini(Mockito.anyBoolean());
    }
    @Test
    public void testKeyPressedCharacterSpace() {
        SpaceShip spaceShip = new SpaceShip(10, 5, 1, 1, 1, 0, true, 1, 1);
        PlayerController playerController = new PlayerController(spaceShip);
        Arena arena = spy(Arena.class);

        for(int i = 0 ; i < 600 ; i++) {
            playerController.playerShots(arena);

            ArrayList<ShotElement> arenaObjects = arena.getShots();

            assertTrue(arenaObjects.stream().anyMatch(Objects::nonNull));
            assertEquals(i + 1, arenaObjects.size());

            ShotElement shot = arenaObjects.get(0);

            assertEquals(4 , shot.getYVelocity());
        }
    }

    @Test
    public void testKeyPressedCharacterSpaceMini() {
        SpaceShip spaceShip = new SpaceShip(10, 5, 1, 1, 1, 0, true, 1, 1);
        PlayerController playerController = new PlayerController(spaceShip);
        Arena arena = spy(Arena.class);
        spaceShip.toggleMini(true);

        for(int i = 0 ; i < 600 ; i++) {
            playerController.playerShots(arena);

            ArrayList<ShotElement> arenaObjects = arena.getShots();

            assertTrue(arenaObjects.stream().anyMatch(Objects::nonNull));
            assertEquals(i + 1, arenaObjects.size());

            ShotElement shot = arenaObjects.get(0);

            assertEquals(1 , shot.getYVelocity());
        }
    }

    @Test
    public void testGetter(){
        SpaceShip spaceShip = new SpaceShip(10, 5, 1, 1, 1, 0, true, 1, 1);
        PlayerController playerController = new PlayerController(spaceShip);

        // Call the getter and assert that the return value is not null
        SpaceShip retrievedSpaceShip = playerController.getSpaceShip();
        assertNotNull(retrievedSpaceShip);
    }
}
