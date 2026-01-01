import Controller.GameController;
import Models.*;
import Strategy.WinningStrategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//package TICTACTOE;

public class main {
    static void main(String[] args) throws Exception {

        GameController gc = new GameController();
        Scanner sc = new Scanner(System.in);

        try {
            int dimension = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1,"Shashi", PlayerType.HUMAN, new Symbol('X')));
            players.add(new Bot(1,"Bot",PlayerType.BOT, new Symbol('O'), BotDifficulty.EASY));

            List<WinningStrategy> ws = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
            );
            Game g = gc.StartGame(dimension, players, ws);
            gc.displayBoard(g);

            while(g.getGameState().equals(GameState.INPROGRESS)) {
                gc.makeMove(g);
                gc.displayBoard(g);

                System.out.println("Want to undo press 1, if not 0: ");
                Integer undoAnswer = sc.nextInt();
//                String undoAnswer = sc.next();
                if(undoAnswer == 1) {
                    System.out.println("Undoing......");
                    gc.undo(g);
                }

                gc.displayBoard(g);
            }

            if(g.getGameState().equals(GameState.DRAW)) {
                System.out.println("Game Draw!!!");
            } else if(g.getGameState().equals(GameState.SUCCESS)) {
                System.out.println("Game Winner: "+g.getWinner().getName());
            }

        } catch (Exception e) {
            throw e;
        }






//        System.out.println("Debug");
    }
}