/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

import java.util.LinkedList;

/**

 @author Chuck
 */
public class Week {

    LinkedList<Day> week;

    public Week() {
        week = new LinkedList<>();
        week.add(new Day("SUNDAY"));
        week.add(new Day("MONDAY"));
        week.add(new Day("TUESDAY"));
        week.add(new Day("WEDNESDAY"));
        week.add(new Day("THURSDAY"));
        week.add(new Day("FRIDAY"));
        week.add(new Day("SATURDAY"));      
    }
    
    public Day getDay(int i){
        return week.get(i);
    }
}
