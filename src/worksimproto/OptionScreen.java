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
public class OptionScreen implements Screen {

    GameLoop gl;
    //   private LinkedList<collisionBox> startGUI; //not used
    private LinkedList<GUIButton> gButtons;

    public OptionScreen(GameLoop _gl) {
        this.gl = _gl;
        gButtons = new LinkedList<>();
        gButtons.add(new GUIButton("EXIT", 100, 100, 8, collisionBox.cbType.EXIT_TO_SPLASH, 0));
    }

    @Override
    public void render(float delta) {
        Gdx.gl10.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
        // gl.getBatch().draw(gl.splashTex, 0, 0);
        /*
         junk
         gl.getBatch().draw(gl.fonts[3][18],100,100);
         gl.getBatch().draw(gl.fonts[3][19],108,100);
         gl.getBatch().draw(gl.fonts[3][0],116,100);
         gl.getBatch().draw(gl.fonts[3][17],124,100);
         gl.getBatch().draw(gl.fonts[3][19],132,100);
         */

        gl.getTRender().printText(gButtons.get(0).getText(), gButtons.get(0).getXPos(), gButtons.get(0).getYPos());

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int width, int height) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public collisionBox.cbType getType(int id) {
        return gButtons.get(id).getCollBox().getType();
    }

    public LinkedList<GUIButton> getTextBox() {
        return gButtons;
    }
}
