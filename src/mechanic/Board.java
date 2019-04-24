package mechanic;

import exception.FieldOutOfBoardException;

//one object per one stage in the board
public class Board {

    private Field[][] board;
    private static int BOARD_SIZE = 12;

    /**
     * Board Contains field that held Chessman
     */

    public Board(){
        board = new Field[BOARD_SIZE][BOARD_SIZE];
    }

    public Field getField(Position position){
        try{
            return board[position.getY()][position.getX()];
        } catch (FieldOutOfBoardException e){

        } catch (Exception e){

        }
        return null;
    }
}

