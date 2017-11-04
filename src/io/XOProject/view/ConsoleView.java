package io.XOProject.view;

import io.XOProject.controlers.CurrentMoveController;
import io.XOProject.controlers.MoveControler;
import io.XOProject.controlers.WinnerControler;
import io.XOProject.model.Exceptions.AlreadyOccupiedException;
import io.XOProject.model.Exceptions.InvalidPointException;
import io.XOProject.model.Field;
import io.XOProject.model.Figure;
import io.XOProject.model.Game;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerControler winnerControler = new WinnerControler();

    private MoveControler moveControler = new MoveControler();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if ( x != 0)  printSeparator();
            printLine(field, x);
        }

    }

    public boolean move(final Game game) {
        final Field field = game.getField();

        final Figure winner = winnerControler.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
                System.out.println("No winner and no moves left");
                return false;

        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveControler.applyFigure(field, point, currentFigure);
        } catch ( final InvalidPointException |AlreadyOccupiedException e) {

           System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("x")-1, askCoordinate("y")-1);
    }

    private int askCoordinate (final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("O_o idiot?");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine( final Field field, final int x) {


        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
               figure = field.getFigure(new Point(y,x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");

        }
        System.out.println();
    }

    private void printSeparator () {
        System.out.println("-----------");
    }




}
