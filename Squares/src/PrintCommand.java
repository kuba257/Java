public class PrintCommand implements ICommand{
    private final SquaresSystem squaresSystem;

    public PrintCommand(SquaresSystem squaresSystem) {
        this.squaresSystem = squaresSystem;
    }

    @Override
    public void execute() {
        this.squaresSystem.print();
    }

    @Override
    public void unexecute() {}
}
