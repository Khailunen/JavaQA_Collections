package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void winPlayerFirst() {
        Player player0 = new Player(4, "Kolya", 100);
        Player player1 = new Player(8, "Vasya", 90);
        Game game = new Game();

        game.register(player0);
        game.register(player1);

        int expected = 1;
        int actual = game.round("Kolya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winPlayerSecond() {
        Player player0 = new Player(4, "Kolya", 100);
        Player player1 = new Player(8, "Vasya", 190);
        Game game = new Game();

        game.register(player0);
        game.register(player1);

        int expected = 2;
        int actual = game.round("Kolya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notWin() {
        Player player0 = new Player(4, "Kolya", 100);
        Player player1 = new Player(8, "Vasya", 100);
        Game game = new Game();

        game.register(player0);
        game.register(player1);

        int expected = 0;
        int actual = game.round("Kolya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noRegisterPlayerFirst() {
        Player player0 = new Player(4, "Kolya", 100);
        Game game = new Game();

        game.register(player0);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Kolya"));
    }

    @Test
    public void noRegisterPlayerSecond() {
        Player player0 = new Player(8, "Vasya", 100);
        Game game = new Game();

        game.register(player0);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Kolya"));
    }
}