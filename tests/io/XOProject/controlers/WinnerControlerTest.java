package io.XOProject.controlers;

import io.XOProject.model.Field;
import io.XOProject.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class WinnerControlerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.X);
            field.setFigure(new Point(0, 2), Figure.X);
            assertEquals(Figure.X, winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.X);
            assertEquals(Figure.X, winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);
            assertNull(winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 2), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 0), Figure.X);
            assertEquals(Figure.X, winnerControler.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerControler winnerControler = new WinnerControler();
        for (int i = 0; i <3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 2), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 0), Figure.O);
            assertNull(winnerControler.getWinner(field));
        }
    }
}