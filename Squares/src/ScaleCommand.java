public class ScaleCommand implements ICommand{
    private final SquaresSystem squaresSystem;
    private final int number;
    private final double factor;

    public ScaleCommand(SquaresSystem squaresSystem, int number, double factor) {
        this.squaresSystem = squaresSystem;
        this.number = number;
        this.factor = factor;
    }

    public void execute() {
        this.squaresSystem.scale(number, factor);
    }

    public void unexecute() {
        this.squaresSystem.unscale(number, factor);
    }
}
