package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() { //сумма времени одной игры
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test // тест №4. Считает количество часов, которое играли в игру, если она УСТАНОВЛЕНА

    public void shouldCountHoursWhenGameInstalled() { //количество часов, если игра установлена

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        player.installGame(game);

        int actual = player.play(game, 3);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void exceptionGameNotInstalled() { //исключение, если игра не установлена

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test
    public void allSumHoursGame() { // суммирует время, проигранное во
                                    // все игры одного жанра этим игроком
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
    public void allSumHoursDifferentGenresGames() { // суммирует время, проигранное во все игры одного жанра
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

    @Test // тест №6.  Выдает игру заданного жанра "Аркады",
    // в которую играли бОльшее количество часов если играли только в игры одного жанра

    public void theBiggestSumHoursIfOnceGenreGames() { //большее количество часов
                                                  //несколько игр одного жанра

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Пираты Карибского моря", "Аркады");

        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 5);
        player.play(game2, 1);

        String expected = "Пираты Карибского моря";
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void theBiggestSumHoursIfSeveralGames() { //большее количество часов
                                                     //несколько игр нескольких жанров
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

        String expected = "Нетология Баттл Онлайн";
        Game actual =  player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void ifNotToPlay() { //выдает  null, если не играли в этот жанр

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



    // другие ваши тесты
}
