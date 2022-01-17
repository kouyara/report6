/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e215705;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test void checkInputTest() {
        Player player = new Player();
        String input = "3-4";

        assertEquals(true, player.checkInput(input));
    }
    @Test void checkOverlapTest(){
        Player player = new Player();
        int[] lineRow = new int[2];
        lineRow[0] = 3;
        lineRow[1] = 4;

        OthelloBoard.gameInitiation();
        assertEquals(true, player.checkOverlap(lineRow));
    }
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