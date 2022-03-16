package demo.practice.toyrobot.board;

/** Default Board Object for Simulation. Creates a concrete {@link Board} of size 5x5 */
public class DefaultBoard extends Board {

  final int DEFAULT_GRID_BOUND = 5;

  public DefaultBoard() {
    this.xUpperBound = DEFAULT_GRID_BOUND;
    this.yUpperBound = DEFAULT_GRID_BOUND;
  }
}
