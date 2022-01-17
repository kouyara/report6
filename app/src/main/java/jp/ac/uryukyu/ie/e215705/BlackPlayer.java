package jp.ac.uryukyu.ie.e215705;
/**
 * 黒のプレイヤーの操作を行うクラス。
 */
public class BlackPlayer {

    /**
     * 黒のプレイヤーの一手を行うメソッド。
     */
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
            direction = playerBlack.directionStone(OthelloBoard.black, lineRow);
            playerBlack.turnAStone(direction, OthelloBoard.black, lineRow);
        }
        OthelloBoard.boardPrint();
    }
}