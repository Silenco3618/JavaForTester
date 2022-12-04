package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    // другие ваши тесты
    @Test
    public void shouldCountHoursWhenGameInstalled() {

        GameStore store = new GameStore();
        Player player = new Player("Petya");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player.installGame(game);

        int actual = player.play(game, 3);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void exceptionGameNotInstalled() {

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test
    public void allSumHoursGame() {
        GameStore store = new GameStore();
        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Пираты Карибского моря", "Аркады");
        Game game3 = store.publishGame("Корсары", "Аркады");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 5);
        player.play(game2, 1);
        player.play(game3, 7);

        int expected = 13;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void allSumHoursDifferentGenresGames() {
        //если добавить несколько жанров
        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Пираты Карибского моря", "Аркады");
        Game game3 = store.publishGame("Rice", "Стрелялки");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 5);
        player.play(game2, 1);
        player.play(game3, 7);

        int expected = 6;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void theBiggestSumHoursIfOnceGenreGames() {
        GameStore store = new GameStore();
        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Пираты Карибского моря", "Аркады");

        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 5);
        player.play(game2, 1);

        Game expected = game1 ;
        Game actual = player.mostPlayerByGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void theBiggestSumHoursIfSeveralGames() {
        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Пираты Карибского моря", "Аркады");
        Game game3 = store.publishGame("Rice", "Стрелялки");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 5);
        player.play(game2, 1);
        player.play(game3, 7);

        Game expected = game3;
        Game actual =  player.mostPlayerByGenre(game3.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void ifNotToPlay() {
        GameStore store = new GameStore();
        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Rice", "Стрелялки");

        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 5);
        player.play(game2, 1);

        assertNull(player.mostPlayerByGenre("Гонки"));
    }

}