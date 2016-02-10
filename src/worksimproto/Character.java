/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public enum Character {

    wA('A', 0, 3),
    wB('B', 1, 3),
    wC('C', 2, 3),
    wD('D', 3, 3),
    wE('E', 4, 3),
    wF('F', 5, 3),
    wG('G', 6, 3),
    wH('H', 7, 3),
    wI('I', 8, 3),
    wJ('J', 9, 3),
    wK('K', 10, 3),
    wL('L', 11, 3),
    wM('M', 12, 3),
    wN('N', 13, 3),
    wO('O', 14, 3),
    wP('P', 15, 3),
    wQ('Q', 16, 3),
    wR('R', 17, 3),
    wS('S', 18, 3),
    wT('T', 19, 3),
    wU('U', 20, 3),
    wV('V', 21, 3),
    wW('W', 22, 3),
    wX('X', 23, 3),
    wY('Y', 24, 3),
    wZ('Z', 25, 3),
    wSpace(' ', 26, 0),
    w1('1', 0, 5),
    w2('2', 1, 5),
    w3('3', 2, 5),
    w4('4', 3, 5),
    w5('5', 4, 5),
    w6('6', 5, 5),
    w7('7', 6, 5),
    w8('8', 7, 5),
    w9('9', 8, 5),
    w0('0', 9, 5),
wDot('.', 10, 5),
wMinus('-', 11, 5)//
    /*
     bA(),
     bB(),
     bC(),
     bD(),
     bE(),
     bF(),
     bG(),
     bH(),
     bI(),
     bJ(),
     bK(),
     bL(),
     bM(),
     bN(),
     bO(),
     bP(),
     bQ(),
     bR(),
     bS(),
     bT(),
     bU(),
     bV(),
     bW(),
     bX(),
     bY(),
     bZ()
     */;

    private char symbol;
    private int xPos;
    private int yPos;

    Character() {

    }

    Character(char c, int x, int y) {
        symbol = c;
        xPos = x;
        yPos = y;
    }

    public char getChar() {
        return symbol;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
