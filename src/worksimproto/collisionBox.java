/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class collisionBox {

    public enum cbType {

        START, OPTION, DAMAGE, EXIT_TO_SPLASH,GET_NEW_HIRES,NEW_DAY
    }
    cbType type;
    int x; //x coordinate
    int y; //y coordinate
    int w; //width
    int h; //height
    int id;

    public collisionBox(int _x, int _y, int _w, int _h, cbType t,int _id) {
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        type = t;
        id=_id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
    public cbType getType(){
        return type;
    }
}
