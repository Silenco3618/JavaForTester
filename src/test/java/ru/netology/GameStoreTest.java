package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();


    @Test //добавление игры
    public void AddGame() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game1));
    }

    @Test //добавление всех игр
    public void AddAllGame() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Корсары", "Стратегии");
        Game game3 = store.publishGame("Ведьмак", "RPG");
        Game game4 = store.publishGame("Call of Duty", "Шутер");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));

    }

    @Test // добавление фальшивой игры
    public void AddAllGameFalse() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Корсары", "Стратегии");
        Game game3 = store.publishGame("Ведьмак", "RPG");
        Game game4 = store.publishGame("Call of Duty", "Шутер");
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertFalse(store.containsGame(null));
    }

    @Test // самое большое время из игроков
    public void GetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("1", 15);
        store.addPlayTime("2", 20);
        store.addPlayTime("3", 18);

        String[] expected = {"2"};
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test // время 1 час
    public void MostPlayerOne() {

        GameStore store = new GameStore();

        store.addPlayTime("1", 1);

        String[] expected = {"1"};
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test // время игры 0
    public void MostPlayerZero() {

        GameStore store = new GameStore();

        store.addPlayTime("1", 0);

        String[] expected = null;
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test // самое большое время из игроков, если у всех 0
    public void MostPlayerTimeZero() {

        GameStore store = new GameStore();

        store.addPlayTime("1", 0);
        store.addPlayTime("2", 0);
        store.addPlayTime("3", 0);

        String[] expected = null;
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test // сумма времени всех игроков
    public void SumPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("1", 15);
        store.addPlayTime("2", 20);
        store.addPlayTime("3", 18);

        int expected = 53;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test // сумма времени всех игроков с 0 часами
    public void SumPlayedTimeZero() {
        GameStore store = new GameStore();

        store.addPlayTime("1", 0);
        store.addPlayTime("2", 0);
        store.addPlayTime("3", 18);

        int expected = 18;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test // сумма времени всех игроков, у всех 0 часов
    public void SumPlayedTimeZeroAll() {
        GameStore store = new GameStore();

        store.addPlayTime("1", 0);
        store.addPlayTime("2", 0);
        store.addPlayTime("3", 0);

        int expected = 0;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }
}