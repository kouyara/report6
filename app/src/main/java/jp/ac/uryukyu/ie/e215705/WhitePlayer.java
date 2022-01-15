package jp.ac.uryukyu.ie.e215705;

public class WhitePlayer {
    
    public void oneMoveWhite() {
        String input;
        int[] lineRow;
        boolean bool1;
        boolean bool2;

        Player playerWhite = new Player();
        input = playerWhite.checkInput();
        lineRow = playerWhite.inputToLineRow(input);
        bool1 = playerWhite.overlapStone(lineRow);
        bool2 = playerWhite.sandwichStone(OthelloBoard.white, lineRow);
        if (bool1 && bool2) {
            playerWhite.putAStone(OthelloBoard.white, lineRow);
            int[] direction = playerWhite.directionSandwichStone(OthelloBoard.white, lineRow);
            playerWhite.turnAStone(direction, OthelloBoard.white, lineRow);
        } else {
            System.out.println("ここは置けません");
        }
        OthelloBoard.boardPrint();

    }
}