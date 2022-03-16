package demo.practice.toyrobot.board;

import demo.practice.toyrobot.model.Position;

/** Abstraction of a Board */
abstract class Board {

  protected int xUpperBound;
  protected int yUpperBound;

  public boolean isValidPosition(Position position) {
    int xPos = position.getXPos();
    int yPos = position.getYPos();
    return xPos < this.xUpperBound && xPos > 0 && yPos < this.yUpperBound && yPos > 0;
  }

  public int getXUpperBound() {
    return this.xUpperBound;
  }

  public int getYUpperBound() {
    return this.yUpperBound;
  }
}
