package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.Player;
import exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Oleg", 300);
    Player player2 = new Player(342, "Victor", 100);
    Player player3 = new Player(123, "Alex", 300);

    @BeforeEach
    void setup() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    void shouldFirstPlayerWin() {

        assertEquals(1, game.round("Oleg", "Victor"));
    }

    @Test
    void shouldSecondPlayerWin() {
        assertEquals(2, game.round("Victor", "Alex"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0,game.round("Oleg", "Alex"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Victor", "Petya");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Oleg");
        });
    }
}