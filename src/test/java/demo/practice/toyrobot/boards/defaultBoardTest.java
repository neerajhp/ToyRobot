package demo.practice.toyrobot.boards;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import demo.practice.toyrobot.board.DefaultBoard;
import demo.practice.toyrobot.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Unit Test for {@link DefaultBoard} Object */
class defaultBoardTest {

  private DefaultBoard boardUnderTest;

  @BeforeEach
  void setup() {
    this.boardUnderTest = new DefaultBoard();
  }

  @Test
  void boardIsInitialisedWithDefaultSize() {

    assertAll(
        "Default dimensions",
        () -> assertEquals(5, boardUnderTest.getXUpperBound()),
        () -> assertEquals(5, boardUnderTest.getYUpperBound()));
  }

  @Test
  void isValidPosition() {
    assertTrue(boardUnderTest.isValidPosition(new Position(2, 2)));
  }

  @Test
  void isInvalidPosition() {
    assertFalse(boardUnderTest.isValidPosition(new Position(10, 10)));
  }
}
