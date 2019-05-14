package chesswar;

import chesswar.mechanic.ChessWarGame;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChessWarCommandExecutor {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String pattern = "(\\s+)";
        String[] command = scanner.nextLine().split(pattern);

        ChessWarGame chessWarGameController;
        while (command != null) {
            try {
                System.out.println(Arrays.stream(command).collect(Collectors.joining(" + ")));
                command = scanner.nextLine().split(pattern);
                switch (command.length){
                    case 1:
                        if(command[0].equalsIgnoreCase("init")) {
                            chessWarGameController = new ChessWarGame();
                            chessWarGameController.init();
                        } else
                        break;
                    case 3:
                        if(command[0].equalsIgnoreCase("check")) {

                        }
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                System.exit(0);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.exit(0);
    }
}
