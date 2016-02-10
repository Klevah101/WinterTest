/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

import java.util.LinkedList;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
/**
 *
 * @author Chuck
 */
public class WorkSimProto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "window";
        cfg.width = 960;
        cfg.height =640;
        cfg.useGL20 = false;
        cfg.resizable=false;
        new LwjglApplication(new GameLoop(), cfg);
        // TODO code application logic here
      
       
    }

}
