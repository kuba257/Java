public class CreateCommand implements ICommand {
    private final SquaresSystem squaresSystem;
    private final int number;
    private final double side;

    public CreateCommand(SquaresSystem squaresSystem, int number, double side) {
        this.squaresSystem = squaresSystem;
        this.number = number;
        this.side = side;
    }

    @Override
    public void execute() {
        this.squaresSystem.create(number, side);
    }

    @Override
    public void unexecute() {
        this.squaresSystem.uncreate(number);
    }
}
