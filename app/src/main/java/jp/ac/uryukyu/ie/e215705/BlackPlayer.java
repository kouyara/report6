package jp.ac.uryukyu.ie.e215705;

public class BlackPlayer {

    public void oneMoveBlack() {
        String input;
        int[] lineRow;
        boolean bool1;
        boolean bool2;

        Player playerBlack = new Player();
        input = playerBlack.checkInput();
        lineRow = playerBlack.inputToLineRow(input);
        bool1 = playerBlack.overlapStone(lineRow);
        bool2 = playerBlack.sandwichStone(OthelloBoard.black, lineRow);
        if (bool1 && bool2) {
            playerBlack.putAStone(OthelloBoard.black, lineRow);
            int[] direction = playerBlack.directionSandwichStone(OthelloBoard.black, lineRow);
            playerBlack.turnAStone(direction, OthelloBoard.black, lineRow);
        } else {
            System.out.println("ここは置けません");
        }
        OthelloBoard.boardPrint();

    }
}