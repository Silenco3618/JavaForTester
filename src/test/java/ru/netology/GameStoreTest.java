package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты
    @Test
    public void addGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Загадки Нью-Йорка", "Головоломка");
        assertFalse(store.containsGame(game2));


    }

    @Test
    public void containsGame1() {
        GameStore store = new GameStore();
        Game game = new Game("Загадки Нью-Йорка", "Головоломка", store);
        assertFalse(store.containsGame(game));
    }

    @Test
    public void theBiggestTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Anna", 5);
        store.addPlayTime("Olga", 12);
        store.addPlayTime("Oleg", 2);


        String actual = store.getMostPlayer();
        String expected = "Olga";
        assertEquals(expected, actual);

    }

    @Test
    public void theBiggestTimeZero() {
        GameStore store = new GameStore();

        store.addPlayTime("Anna", 0);
        store.addPlayTime("Olga", 0);
        store.addPlayTime("Oleg", 0);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);

    }

    @Test
    public void mostPlayer1() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 2);
        String expected = "Anna";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerZero() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 0);
        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerOne() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 1);
        String expected = "Anna";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void sumPlayedTime1() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 1);
        store.addPlayTime("Olga", 4);
        store.addPlayTime("Oleg", 2);
        int expected = 7;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);

    }

    @Test
    public void sumPlayedTime2() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 0);
        store.addPlayTime("Olga", 0);
        store.addPlayTime("Oleg", 2);
        int expected = 2;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);

    }

    @Test
    public void sumPlayedTimeZero() {
        GameStore store = new GameStore();
        store.addPlayTime("Anna", 0);
        store.addPlayTime("Olga", 0);
        store.addPlayTime("Oleg", 0);
        int expected = 0;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);

    }





}

