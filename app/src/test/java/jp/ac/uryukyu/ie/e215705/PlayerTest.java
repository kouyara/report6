
package jp.ac.uryukyu.ie.e215705;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Playerクラスのユニットテストをするクラス。
 */
class PlayerTest {
    /**
     * checkInput()のテストコード。
     * "3-4"と正しく入力して、trueが返ってくるかテストする。
     */
    @Test void checkInputTest() {
        Player player = new Player();
        String input = "3-4";

        assertEquals(true, player.checkInput(input));
    }
    /**
     * checkOverlap()のテストコード。
     * 3と4を入れたlineRow[]を使って、trueが返ってくるかテストする。
     */
    @Test void checkOverlapTest(){
        Player player = new Player();
        int[] lineRow = new int[2];
        lineRow[0] = 3;
        lineRow[1] = 4;

        OthelloBoard.gameInitiation();
        assertEquals(true, player.checkOverlap(lineRow));
    }
    /**
     * checkSandwich()のテストコード。
     * 3と4を入れたlineRow[]を使って、trueが返ってくるかテストする。
     */
    @Test void checkSandwichTest(){
        Player player = new Player();
        int[] lineRow = new int[2];
        lineRow[0] = 3;
        lineRow[1] = 4;
        String stone = OthelloBoard.black;

        OthelloBoard.gameInitiation();
        assertEquals(true, player.checkSandwich(stone, lineRow));
    }
}