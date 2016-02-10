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

public class TimeSlot {
    LinkedList<Employee> empsOnShift;
    public TimeSlot(){
        empsOnShift = new LinkedList();
    }
    
    public void addEmployee(Employee e){
        empsOnShift.add(e);
    }
    
    public void removeEmployee(Employee e){
        empsOnShift.remove(e);
    }
    
}
