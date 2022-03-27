import java.util.ArrayList;

public class SquaresSystem {
    private final ArrayList<Square> squares = new ArrayList<>();
    private final ArrayList<Square> removedSquares = new ArrayList<>();

    public void create(int number, double side) {
        for (Square square: squares) {
            if(square.getNumber() == number) {
                removedSquares.add(square);
                squares.remove(square);
                break;
            }
        }
        squares.add(new Square(number, side, 0, 0));
    }

    public void uncreate(int number) {
        squares.removeIf(square -> square.getNumber() == number);
        if (!removedSquares.isEmpty()) {
            squares.add(removedSquares.get(removedSquares.size() - 1));
            removedSquares.remove(removedSquares.get(removedSquares.size() - 1));
        }
    }

    public void move(int number, double x, double y) {
        for (Square square: squares) {
            if(square.getNumber() == number) {
                square.setXY(square.getX() + x, square.getY() + y);
                break;
            }
        }
    }

    public void unmove(int number, double x, double y) {
        for (Square square: squares) {
            if(square.getNumber() == number) {
                square.setXY(square.getX() - x, square.getY() - y);
                break;
            }
        }
    }

    public void scale(int number, double factor) {
        for (Square square: squares) {
            if(square.getNumber() == number) {
                square.setSide(square.getSide() * factor);
                break;
            }
        }
    }

    public void unscale(int number, double factor) {
        for (Square square: squares) {
            if(square.getNumber() == number) {
                square.setSide(square.getSide() / factor);
                break;
            }
        }
    }

    public void print() {
        for (Square square: squares) {
            System.out.println(square);
        }
    }
}
