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
public class SplashScreen implements Screen {

    GameLoop gl;
    //  private LinkedList<collisionBox> startGUI;
    private LinkedList<GUIButton> gButtons;

    public SplashScreen(GameLoop _gl) {
        this.gl = _gl;
        gButtons = new LinkedList<>();
        gButtons.add(new GUIButton("START", 100, 100, 8, collisionBox.cbType.START, 0));
        gButtons.add(new GUIButton("OPTIONS", 100, 90, 8, collisionBox.cbType.OPTION, 1));
        //  startGUI = new LinkedList<>();
        //   startGUI.add(new collisionBox(100, 100, 5 * 8, 8));
    }

    @Override
    public void render(float delta) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Gdx.gl10.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.getBatch().draw(gl.splashTex, 0, 0);
        /*
         junk
         gl.getBatch().draw(gl.fonts[3][18],100,100);
         gl.getBatch().draw(gl.fonts[3][19],108,100);
         gl.getBatch().draw(gl.fonts[3][0],116,100);
         gl.getBatch().draw(gl.fonts[3][17],124,100);
         gl.getBatch().draw(gl.fonts[3][19],132,100);
         */

        gl.getTRender().printText(gButtons.get(0).getText(), gButtons.get(0).getXPos(), gButtons.get(0).getYPos());
        gl.getTRender().printText(gButtons.get(1).getText(), gButtons.get(1).getXPos(), gButtons.get(1).getYPos());

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
