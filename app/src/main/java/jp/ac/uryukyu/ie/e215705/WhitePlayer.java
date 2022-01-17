package jp.ac.uryukyu.ie.e215705;

/**
 * 白のプレイヤーの操作を行うクラス。
 */
public class WhitePlayer {

    /**
     * 白のプレイヤーの一手を行うメソッド。
     */
    public void oneMoveWhite() {            
        String input;
        int[] lineRow;
        int[] direction;

        Player playerWhite = new Player();
        System.out.println("白の人の番です。");
        input = playerWhite.runUntilCanPut(OthelloBoard.white);
        if (input == null){
            //パス
        }else{
            lineRow = playerWhite.inputToLineRow(input);
            playerWhite.putAStone(OthelloBoard.white, lineRow);
            direction = playerWhite.directionStone(OthelloBoard.white, lineRow);
            playerWhite.turnAStone(direction, OthelloBoard.white, lineRow);
        }
        OthelloBoard.boardPrint();
    }
}