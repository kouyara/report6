package jp.ac.uryukyu.ie.e215705;

public class BlackPlayer {

    public void oneMoveBlack() {
        String input;
        int[] lineRow;
        int[] direction;

        Player playerBlack = new Player();
        System.out.println("黒の人の番です。");
        input = playerBlack.runUntilCanPut(OthelloBoard.black);
        if (input == null){
            //パス
        }else{
            lineRow = playerBlack.inputToLineRow(input);
            playerBlack.putAStone(OthelloBoard.black, lineRow);
            direction = playerBlack.directionSandwichStone(OthelloBoard.black, lineRow);
            playerBlack.turnAStone(direction, OthelloBoard.black, lineRow);
        }
        OthelloBoard.boardPrint();
    }
}