/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class GUIButton {

    private int xPos, yPos, width, height;//x postion, y position, width, height
    private collisionBox collBox;
    private String text;
    private boolean clickable;

    public GUIButton(String t, int _x, int _y, int _h, collisionBox.cbType ty,int _id) {
        clickable = true;
        text = t;
        xPos = _x;
        yPos = _y;
        height = _h;
        width = text.length() * 8;
        collBox = new collisionBox(xPos, yPos, width, height, ty,_id);
    }

    public String getText() {
        return text;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public collisionBox getCollBox() {
        return collBox;
    }
}
