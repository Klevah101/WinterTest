/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**

 @author Chuck
 */
public class GameLoop extends Game implements ActionListener {

    /*
     100 time = 1 hour;  25 time = 15 minutes
     I will eventually generate money and payout to employees based on scheduling 
     and payrate.
     */
    /*
    
     */
    public static enum gameLoopState {

        SPLASH, GAME, CREDITS, OPTION
    };
    //
    private Random ranGen;
    private boolean oGui;
    private boolean startClicked = false;
    private boolean optionClicked = false;
    private boolean exit_to_splash = false;
    private boolean hireClicked = false;
    private boolean nextClicked = false;
    private boolean prevClicked = false;
    private boolean new_hire_list = false;
    private boolean newDayClicked = false;
    //  
    private OrthographicCamera cam;
    private SplashScreen sScreen;
    private GameScreen gScreen;
    private OptionScreen oScreen;
    private gameLoopState loopState;
    private Schedule schedule;
    private int day = 1;
    // 365/7 
    private Week week;
    private int uph = 100; //Average units per hour
    private int money = 1000000;
    private int expense = 0;
    private int gUnits, bUnits;
    private Building building;
    private Timer daySlotTimer;
    private static final Path path = Paths.get("Images/Splash.png");
    private LinkedList<Employee> employees;
    public Texture splashTex;
    public Texture fontSheet;
    public TextureRegion[][] fonts;
    private Texture gameTex;
    public SpriteBatch batch;
    private Timer FrameTimer;
    private Timer InputTimer;
    private boolean btn1;
    private LinkedList<Employee> hirePool;
    //private LinkedList<collisionBox> startGUI;
    private Employee selectedHire;
    private int selectedHireID;

    public Character character;
    private TextRenderer tRender;
    private int currentTime;
    private int currentDay;

    @Override
    public void create() {
        try {
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn1 = false;

        employees = new LinkedList<>();
        //  hire();

        schedule = new Schedule();

        ranGen = new Random();
       // createHirePool();

        //  work();
        building = new Building();
        init();
    }

    @Override
    public void resize(int i, int i1) {
        super.resize(i, i1);

    }

    @Override
    public void render() {
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        switch (loopState) {
            case SPLASH:
                sScreen.render(0f);
                break;
            case GAME:
                gScreen.render(0f);
                break;
            case OPTION:
                oScreen.render(0f);
                break;
            default:
                break;
        }
        batch.end();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        InputTimer.stop();
        Keyboard.destroy();
        Mouse.destroy();
    }

    public void hire_Test() {
        for (int x = 0; x < 10; x++) {
            employees.add(new Employee());
            employees.get(x).setID(x);
            /*
             set name and other stuff here
             */

        }

        for (int x = 0; x < employees.size(); x++) {
            System.out.println(employees.get(x).getLName() + ',' + employees.get(x).getFName());
            System.out.println("ID:" + employees.get(x).getID());
        }
        System.out.println();

    }

    public void createHirePool() {
        String tempFamName;
        int numOfHires;
        int famNameIndex;
        int perNameIndex;
        numOfHires = ranGen.nextInt(10) + 1;
        hirePool = new LinkedList<>();
        for (int count = 0; count < numOfHires; count++) {
            hirePool.add(new Employee());
            famNameIndex = ranGen.nextInt(FamilyName.values().length);
            perNameIndex = ranGen.nextInt(PersonalName.values().length);
            hirePool.get(count).setLName(FamilyName.values()[famNameIndex].getName());
            hirePool.get(count).setFName(PersonalName.values()[perNameIndex].getName());
            hirePool.get(count).setID(count);
        }
        selectedHireID = 0;
    }

    public void processMouse() {
        oGui = overGUI();
        switch (loopState) {
            case SPLASH:

                if (oGui) {
                    if (Mouse.isButtonDown(0) && !btn1) {
                        //get mouse location to seeif clickrd on start

                        if (startClicked) {
                            startGame();
                        } else if (optionClicked) {
                            loopState = loopState.OPTION;
                            btn1 = true;
                        }
                    } else if (!Mouse.isButtonDown(0)) {

                        btn1 = false;
                    }
                }
                break;
            case GAME:
                if (oGui) {
                    if (Mouse.isButtonDown(0) && !btn1) {
                        //  loopState = loopState.SPLASH;
                        if (new_hire_list) {
                            createHirePool();
                            // selectedHireID = 0;
                            selectedHire = hirePool.get(selectedHireID);
                            System.out.println(hirePool.size());
                        }
                        if (nextClicked) {

                            nextHire();

                        }
                        if (prevClicked) {

                            prevHire();

                        }
                        if (hireClicked) {
                            // employees.add(selectedHire);
                            //System.out.println("new Employee hired.");
                            if (selectedHire != null) {
                                hire();
                            }
                        }

                        if (newDayClicked) {
                            calcDay();
                        }
                        btn1 = true;
                    } else if (!Mouse.isButtonDown(0)) {
                        btn1 = false;

                    }
                }
                break;

            case OPTION:
                if (oGui) {
                    if (Mouse.isButtonDown(0) && !btn1) {
                        if (exit_to_splash) {
                            loopState = loopState.SPLASH;
                            btn1 = true;
                        }

                    } else if (!Mouse.isButtonDown(0)) {
                        btn1 = false;

                    }

                }
                break;
            default:

                break;

        }
        startClicked = false;
        optionClicked = false;
        exit_to_splash = false;
        hireClicked = false;
        nextClicked = false;
        prevClicked = false;
        new_hire_list = false;
        newDayClicked = false;
    }

    public void work_proto() {
        for (Employee e : employees) {
            gUnits += 10;
            bUnits += 3;

            /*
             eventually refer to a schedule for payout. Check if an employee has called in sick before paying
             */
        }
        //  System.out.println("Good units made today:" + gUnits);
        // System.out.println("Bad units made today:" + bUnits);

        for (int x = 0; x < 8 * 4; x++) {
            schedule.addEmpShift(0, x, employees.get(0));
        }

        for (int xx = 0; xx < 7; xx++) {
            for (int x = 0; x < 24 * 4; x++) {
                for (Employee e : schedule.getBusDay(xx).getShift(x).getEmp()) {
                    expense += e.getPay() / 4;
                }
            }
        }
        //  System.out.println("Expense is " + expense);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(FrameTimer)) {
            //   work();
        }
        if (ae.getSource().equals(InputTimer)) {
            processMouse();
        }
        if (ae.getSource().equals(daySlotTimer)) {

            currentTime++;
            if (currentTime >= 24 || currentTime < 0) {
                currentTime=0;
                currentDay++;
                if (currentDay >= 7 || currentDay < 0) {
                    currentDay = 0;
                }
            }
        }
     // schedule.addEmpShift(1, 1, employees.get(1));

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void init() {
        currentTime = 0;
        currentDay = 0;
        cam = new OrthographicCamera(960, 640);
        cam.position.set(960 / 2, 640 / 2, 0);
        cam.update();
        tRender = new TextRenderer(this);
        sScreen = new SplashScreen(this);
        // startGUI = new LinkedList<collisionBox>();
        //  startGUI.add(new collisionBox(100, 100, 8, 8));
        gScreen = new GameScreen(this);
        oScreen = new OptionScreen(this);
        loopState = gameLoopState.SPLASH;
        loadImages();
        week = new Week();
        InputTimer = new Timer(16, this);
        InputTimer.start();
        FrameTimer = new Timer(1000, this);
        FrameTimer.start();
        daySlotTimer = new Timer(2000, this);
        daySlotTimer.start();

    }

    public void loadImages() {
        splashTex = new Texture(Gdx.files.internal("Images/Splash.png"));
        fontSheet = new Texture(Gdx.files.internal("Images/fonttest.png"));
        fonts = new TextureRegion[32][32];
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                fonts[y][x] = new TextureRegion(fontSheet, x * 8, y * 8, 8, 8);
            }
        }
        batch = new SpriteBatch();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void startGame() {
        loopState = loopState.GAME;
        btn1 = true;
    }

    public boolean overGUI() {
        boolean over = false;
        switch (loopState) {
            case SPLASH:
                for (GUIButton gb : sScreen.getTextBox()) {
                    if (Mouse.getX() > gb.getCollBox().getX()
                            && Mouse.getX() < gb.getCollBox().getX() + gb.getCollBox().getW()
                            && Mouse.getY() > gb.getCollBox().getY()
                            && Mouse.getY() < gb.getCollBox().getY() + gb.getCollBox().getH()) {
                     //   System.out.println("inside of " + gb.getText() + " box");
                        //
                     /*   if (gb.getText().matches("start")) {
                         startClicked = true;
                         return true;
                         }
                         */
                        //*
                        switch (gb.getText()) {
                            case "START":
                                startClicked = true;
                                over = true;
                                break;
                            case "OPTIONS":
                                optionClicked = true;
                                over = true;
                                break;
                            default:
                                startClicked = false;
                                optionClicked = false;
                                break;
                        }
                        //  */
                        // return true;

                    }
                }
                break;
            case OPTION:

                for (GUIButton gb : oScreen.getTextBox()) {
                    if (Mouse.getX() > gb.getCollBox().getX()
                            && Mouse.getX() < gb.getCollBox().getX() + gb.getCollBox().getW()
                            && Mouse.getY() > gb.getCollBox().getY()
                            && Mouse.getY() < gb.getCollBox().getY() + gb.getCollBox().getH()) {
                       // System.out.println("inside of " + gb.getText() + " box");
                        //
                     /*   if (gb.getText().matches("start")) {
                         startClicked = true;
                         return true;
                         }
                         */
                        //*
                        switch (gb.getText()) {
                            case "EXIT":

                                exit_to_splash = true;
                                over = true;
                                break;
                            default:
                                exit_to_splash = false;

                                break;
                        }
                        //  */
                        // return true;
                    }
                }
                break;
            case GAME:

                for (GUIButton gb : gScreen.getTextBox()) {
                    if (Mouse.getX() > gb.getCollBox().getX()
                            && Mouse.getX() < gb.getCollBox().getX() + gb.getCollBox().getW()
                            && Mouse.getY() > gb.getCollBox().getY()
                            && Mouse.getY() < gb.getCollBox().getY() + gb.getCollBox().getH()) {
                      //  System.out.println("inside of " + gb.getText() + " box");
                        //
                     /*   if (gb.getText().matches("start")) {
                         startClicked = true;
                         return true;
                         }
                         */
                        //*
                        switch (gb.getText()) {
                            case "NEXT":
                                nextClicked = true;

                                over = true;
                                break;
                            case "PREV":
                                prevClicked = true;
                                over = true;
                                break;
                            case "HIRE":
                                hireClicked = true;
                                over = true;
                                break;
                            case "GET NEW HIRES":
                                new_hire_list = true;
                                over = true;
                                break;
                            case "NEW DAY":
                                newDayClicked = true;
                                over = true;
                                break;
                            default:
                                exit_to_splash = false;

                                break;
                        }
                        //  */
                        // return true;
                    }
                }
                break;
            default:
                break;
        }

        //  System.out.println("outside of box");
        return over;
    }
    /*
     Check if the mouse is over a gui element before executing a game function/mechanic
     */

    public TextRenderer getTRender() {
        return tRender;
    }

    public Week getWeek() {
        return week;
    }

    public void hire() {
        if (!employees.contains(selectedHire)) {
            employees.add(hirePool.get(selectedHireID));
            hirePool.remove(selectedHire);
            if (!hirePool.isEmpty()) {
                selectedHire = hirePool.getFirst();
            }
            if (hirePool.isEmpty()) {
                selectedHire = null;
            }
        }
    }

    public void nextHire() {
        if (selectedHire != null) {

            selectedHireID++;
            if (selectedHireID >= hirePool.size()) {
                selectedHireID = 0;
            }
            selectedHire = hirePool.get(selectedHireID);
            System.out.println(selectedHireID);
            System.out.println(selectedHire.getFName() + " " + selectedHire.getLName());
        }
    }

    public void prevHire() {
        if (selectedHire != null) {

            selectedHireID--;
            if (selectedHireID < 0) {
                selectedHireID = hirePool.size() - 1;
            }
            selectedHire = hirePool.get(selectedHireID);
            System.out.println(selectedHireID);
            System.out.println(selectedHire.getFName() + " " + selectedHire.getLName());
        }
    }

    public Employee getSelectedHire() {
        return selectedHire;
    }

    public int getSelectedHireID() {
        return selectedHireID;
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    public void calcDay() {
        payEmployee();
    }

    public int getMoney() {

        return money;
    }

    public void payEmployee() {
        for (Employee e : employees) {
            money -= 875;
        }
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public int getCurrentDay() {
        return currentDay;
    }
}
