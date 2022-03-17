package demo.practice.toyrobot.robots;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import demo.practice.toyrobot.model.CardinalDirection;
import demo.practice.toyrobot.model.Position;
import demo.practice.toyrobot.robot.DefaultRobot;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Unit tests for {@link Robot} object */
class defaultRobotTest {

  private DefaultRobot robotUnderTest;
  private int INIT_X = 0;
  private int INIT_Y = 0;
  private CardinalDirection INIT_CARDINAL_DIRECTION = CardinalDirection.NORTH;
  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setup() {
    this.robotUnderTest = new DefaultRobot();

    robotUnderTest.place(new Position(INIT_X, INIT_Y), INIT_CARDINAL_DIRECTION);
  }

  @BeforeEach
  void setStreams() {
    System.setOut(new PrintStream(out));
  }

  @AfterEach
  void restoreInitialStreams() {
    System.setOut(originalOut);
  }

  @Test
  void robotIsPlaced() {
    // Robot Under Test has been placed during setup
    assertAll(
        () -> assertEquals(INIT_X, robotUnderTest.getPosition().getXPos()),
        () -> assertEquals(INIT_Y, robotUnderTest.getPosition().getYPos()),
        () -> assertEquals(INIT_CARDINAL_DIRECTION, robotUnderTest.getCardinalDirection()));
  }

  @Test
  void robotRotatesCounterClockwise() {

    robotUnderTest.rotateLeft();
    assertEquals(CardinalDirection.WEST, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateLeft();
    assertEquals(CardinalDirection.SOUTH, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateLeft();
    assertEquals(CardinalDirection.EAST, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateLeft();
    assertEquals(CardinalDirection.NORTH, robotUnderTest.getCardinalDirection());
  }

  @Test
  void robotRotatesClockwise() {

    robotUnderTest.rotateRight();
    assertEquals(CardinalDirection.EAST, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateRight();
    assertEquals(CardinalDirection.SOUTH, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateRight();
    assertEquals(CardinalDirection.WEST, robotUnderTest.getCardinalDirection());
    robotUnderTest.rotateRight();
    assertEquals(CardinalDirection.NORTH, robotUnderTest.getCardinalDirection());
  }

  @Test
  void robotReportsPositionAndDirection() {

    String expectedString = "0,0,NORTH";

    String reportedString = robotUnderTest.report();

    assertEquals(expectedString, reportedString);
  }
}
