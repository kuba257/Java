public class MoveCommand implements ICommand {
    private final SquaresSystem squaresSystem;
    private final int number;
    private final double x;
    private final double y;

    public MoveCommand(SquaresSystem squaresSystem, int number, double x, double y) {
        this.squaresSystem = squaresSystem;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.squaresSystem.move(number, x, y);
    }

    @Override
    public void unexecute() {
        this.squaresSystem.unmove(number, x, y);
    }
}
