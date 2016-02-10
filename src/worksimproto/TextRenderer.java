/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class TextRenderer {
//private Character character;

    private GameLoop gl;

    public TextRenderer(GameLoop _gl) {
        gl = _gl;
    }

    public void printText(String s, float _x, float _y) {
        for (int cnt = 0; cnt < s.length(); cnt++) {
            for (Character c : Character.values()) {
                if (s.charAt(cnt) == c.getChar()) {                   
                     gl.getBatch().draw(gl.fonts[c.getYPos()][c.getXPos()], _x, _y);
                    _x =_x+ 8;

                }
            }
        }
    }
}
