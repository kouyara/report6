package jp.ac.uryukyu.ie.e215705;

public class Main {
    public static void main(String[] args) {
        BlackPlayer blackPlayer = new BlackPlayer();
        WhitePlayer whitePlayer = new WhitePlayer();

        OthelloBoard.gameInitiation();
        
        while ( ! OthelloBoard.checkEndBoard()) {
            blackPlayer.oneMoveBlack();
            whitePlayer.oneMoveWhite();
        }
        OthelloBoard.endBoard();
    }
}