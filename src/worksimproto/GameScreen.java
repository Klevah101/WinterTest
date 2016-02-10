/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import java.util.LinkedList;

/**

 @author Chuck
 */
public class GameScreen implements Screen {
private String misc;
    private LinkedList<GUIButton> gButtons;
    GameLoop gl;

    public GameScreen(GameLoop gl) {
        this.gl = gl;
        gButtons = new LinkedList<>();
        gButtons.add(new GUIButton("GET NEW HIRES", 100, 100, 8, collisionBox.cbType.GET_NEW_HIRES, 0));
        gButtons.add(new GUIButton("HIRE", 100, 300, 8, collisionBox.cbType.GET_NEW_HIRES, 1));
        gButtons.add(new GUIButton("NEXT", 142, 300, 8, collisionBox.cbType.GET_NEW_HIRES, 2));
        gButtons.add(new GUIButton("PREV", 58, 300, 8, collisionBox.cbType.GET_NEW_HIRES, 3));
        gButtons.add(new GUIButton("NEW DAY", 600, 300, 8, collisionBox.cbType.GET_NEW_HIRES, 4));
    }

    @Override
    public void render(float delta) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int xcnt = 0, ycnt = 0;
        Gdx.gl10.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // each letter is 8x8 pixels
        Gdx.gl10.glColor4f(1, .5f, 1, .5f);
        gl.getTRender().printText(gButtons.get(0).getText(), gButtons.get(0).getXPos(), gButtons.get(0).getYPos());
        gl.getTRender().printText(gButtons.get(1).getText(), gButtons.get(1).getXPos(), gButtons.get(1).getYPos());
        gl.getTRender().printText(gButtons.get(2).getText(), gButtons.get(2).getXPos(), gButtons.get(2).getYPos());
        gl.getTRender().printText(gButtons.get(3).getText(), gButtons.get(3).getXPos(), gButtons.get(3).getYPos());
        gl.getTRender().printText(gButtons.get(4).getText(), gButtons.get(4).getXPos(), gButtons.get(4).getYPos());

        gl.getTRender().printText("NAME", 10, 600);
        misc=Integer.toString(gl.getMoney());
        misc=misc.substring(0, misc.length()-2)+"."+misc.substring(misc.length()-2, misc.length());
        gl.getTRender().printText("MONEY" + " " + "$" + misc, 600, 600);
        if (gl.getSelectedHire() != null) {
            gl.getTRender().printText(gl.getSelectedHire().getFName().toUpperCase() + " " + gl.getSelectedHire().getLName().toUpperCase(), 50, 600);
        }

        if (!gl.getEmployees().isEmpty()) {
            xcnt = 0;
            ycnt = 0;
            for (Employee e : gl.getEmployees()) {
                gl.getTRender().printText(e.getFName().toUpperCase() + " " + e.getLName().toUpperCase(), 300, 600 - ycnt);
                ycnt += 10;
            }
        }
        
        gl.getTRender().printText(gl.getWeek().getDay(gl.getCurrentDay()).getDayName().toUpperCase(), 300, 50);
        gl.getTRender().printText(gl.getCurrentTime()+"", 300, 40);
    }

    @Override
    public void resize(int width, int height) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LinkedList<GUIButton> getTextBox() {
        return gButtons;
    }

}
