import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SquaresSystem squaresSystem = new SquaresSystem();
        boolean isLastCommandUndoOrRedo = false;
        String[] params;
        String input;

        ArrayList<ICommand> CommandsList = new ArrayList<>();
        ArrayList<ICommand> CanceledCommandsList = new ArrayList<>();

        while(true) {
            input = scan.nextLine();
            params =  input.split(" ");
            switch (params[0]) {
                case "C": CommandsList.add(new CreateCommand(squaresSystem, Integer.parseInt(params[1]),
                        Double.parseDouble(params[2])));
                        CommandsList.get(CommandsList.size() - 1).execute();
                        isLastCommandUndoOrRedo = false;
                    break;
                case "M": CommandsList.add(new MoveCommand(squaresSystem, Integer.parseInt(params[1]),
                        Double.parseDouble(params[2]), Double.parseDouble(params[3])));
                        CommandsList.get(CommandsList.size() - 1).execute();
                        isLastCommandUndoOrRedo = false;
                    break;
                case "S": CommandsList.add(new ScaleCommand(squaresSystem, Integer.parseInt(params[1]),
                        Double.parseDouble(params[2])));
                        CommandsList.get(CommandsList.size() - 1).execute();
                        isLastCommandUndoOrRedo = false;
                    break;
                case "U":   if (!CommandsList.isEmpty()) {
                                CommandsList.get(CommandsList.size() - 1).unexecute();
                                CanceledCommandsList.add(CommandsList.get(CommandsList.size() - 1));
                                CommandsList.remove(CommandsList.size() - 1);
                                isLastCommandUndoOrRedo = true;
                            }
                    break;
                case "R":   if (!CanceledCommandsList.isEmpty() && isLastCommandUndoOrRedo) {
                                CanceledCommandsList.get(CanceledCommandsList.size() - 1).execute();
                                CommandsList.add(CanceledCommandsList.get(CanceledCommandsList.size() - 1));
                                CanceledCommandsList.remove(CanceledCommandsList.size() - 1);
                                isLastCommandUndoOrRedo = true;
                            }
                    break;
                case "P": new PrintCommand(squaresSystem).execute();
                    break;
            }
        }
    }
}
