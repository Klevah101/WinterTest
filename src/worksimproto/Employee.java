/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class Employee {

    /*
     SLOW workers produce 50% product
     AVER workers produce 100% product
     FAST workers produce 150% product
     */
    
    static public enum wSpeed {

        SLOW, AVER, FAST
    };
    /*
     POOR work quality will produce 50% waste
     AVER work quality will produce 25% waste
     GOOD work quality will produce 0% waste
     */

    static public enum wQual {

        POOR, AVER, GOOD
    };
    ///////////////////////////////////////////////////////////////////////////
    private String fName, lName;
    private int id;
    private wSpeed workSpeed;
    private wQual workQuality;
    private int pay;
    ///////////////////////////////////////////////////////////////////////////

    public Employee() {
        fName = "";
        lName = "";
        id = 0;
        workSpeed = wSpeed.AVER;
        workQuality = wQual.AVER;
        pay = 8;
    }
public Employee(String _fname,String _lname){
    
}
    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public int getID() {
        return id;
    }

    public wSpeed getWorkSpeed() {
        return workSpeed;
    }

    public wQual getWorkQual() {
        return workQuality;
    }
    public void setPay(int p){
        pay=p;
    }
    public int getPay(){
        return pay;
    }

    public void setFName(String fn) {
        fName = fn;
    }

    public void setLName(String ln) {
        lName = ln;
    }

    public void setID(int ID) {
        id = ID;
    }

    public void setWorkSpeed(wSpeed ws) {
        workSpeed = ws;
    }

    public void getWorkQual(wQual wq) {
        workQuality = wq;
    }
}
