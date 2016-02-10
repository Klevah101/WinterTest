/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class Day {

    TimeSlot[] hour;
    String name;
   // int currentTime;

    public Day(String _n) {
       // currentTime=0;
        name = _n;
        hour = new TimeSlot[24];
        for (int x = 0; x < 24; x++) {
            hour[x] = new TimeSlot();
        }
    }

    public void nextTimeSlot() {
        //currentTime++;
    }

    public void resetDay() {
       // currentTime = 0;
    }
    public String getDayName(){
        return name;
    }
}
