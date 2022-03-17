package demo.practice.toyrobot.robot;

import demo.practice.toyrobot.model.CardinalDirection;
import demo.practice.toyrobot.model.Position;

/** Abstraction of a Robot */
abstract class Robot {

  private Position position;
  private CardinalDirection cardinalDirection;

  public Robot() {}

  /**
   * Handles placing the Robot
   *
   * @param position
   * @param direction
   */
  public void place(Position position, CardinalDirection direction) {
    this.position = position;
    this.cardinalDirection = direction;
  }

  /** Handles ROBOT behaviour for LEFT command */
  public void rotateLeft() {

    switch (this.cardinalDirection) {
      case NORTH:
        this.cardinalDirection = CardinalDirection.WEST;
        break;
      case EAST:
        this.cardinalDirection = CardinalDirection.NORTH;
        break;
      case SOUTH:
        this.cardinalDirection = CardinalDirection.EAST;
        break;
      case WEST:
        this.cardinalDirection = CardinalDirection.SOUTH;
    }
  }

  /** Handles Robot behaviour for RIGHT command */
  public void rotateRight() {

    switch (this.cardinalDirection) {
      case NORTH:
        this.cardinalDirection = CardinalDirection.EAST;
        break;
      case EAST:
        this.cardinalDirection = CardinalDirection.SOUTH;
        break;
      case SOUTH:
        this.cardinalDirection = CardinalDirection.WEST;
        break;
      case WEST:
        this.cardinalDirection = CardinalDirection.NORTH;
    }
  }

  /**
   * Handles Robot behaviour for REPORT command
   *
   * @return Report string in format "xpos, ypos, cardinaldirection"
   */
  public String report() {

    return this.getPosition().getXPos()
        + ","
        + this.getPosition().getYPos()
        + ","
        + this.getCardinalDirection().toString();
  }

  public Position getPosition() {
    return this.position;
  }

  public CardinalDirection getCardinalDirection() {
    return this.cardinalDirection;
  }
}
