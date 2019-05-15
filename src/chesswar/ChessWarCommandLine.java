package chesswar;

import chesswar.entity.AttackType;
import chesswar.entity.Chessman;
import chesswar.mechanic.ChessWarGameController;

import java.util.Scanner;

public class ChessWarCommandLine {

    private ChessWarGameController chessWarGameController;

    private Scanner scanner = new Scanner(System.in);
    private String pattern = "(\\s+)";
    private String[] command;

    public ChessWarCommandLine(ChessWarGameController c) {
        chessWarGameController = c;
    }

    public void run() {

        while (true) {
            try {
                command = scanner.nextLine().split(pattern);
                System.out.println(command.toString());
                switch (command[0].toLowerCase()) {
                    case "debug":
                        if (command[1].equalsIgnoreCase("true")) {
                            chessWarGameController.getChessWarGame().setDebugMode(true);
                        } else if (command[1].equalsIgnoreCase("false")) {
                            chessWarGameController.getChessWarGame().setDebugMode(false);
                        } else {
                            invalidCommand();
                        }
                        System.out.println("debug mode: " + chessWarGameController.getChessWarGame().isDebugMode());
                        break;
                    case "maxcost":
                        int i = 0;
                        for(Chessman chessman : chessWarGameController.getChessWarGame().getPlayerAndChess().get(chessWarGameController.getChessWarGame().getTurnController().getTurn().getPlayer())){
                            if(chessman.isAlive()){
                                if(chessman.getAttackType() == AttackType.MELEE)
                                    i+=2;
                                else
                                    i+=4;
                            }
                        }
                        System.out.println("Max cost: " + i);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void invalidCommand() {
        System.out.println("Invalid command.");
    }
}
