package demo.practice.toyrobot.model;

/** Cartesian Coordinate Object */
public class Position {

  private int xPos;
  private int yPos;

  public Position(int x, int y) {
    this.xPos = x;
    this.yPos = y;
  }

  public int getXPos() {
    return this.xPos;
  }

  public int getYPos() {
    return this.yPos;
  }
}
