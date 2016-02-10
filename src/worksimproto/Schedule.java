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
public class Schedule {
    // schedules will be set on a week by week basis

    BusDay[] week;

    public Schedule() {
        week = new BusDay[7];
        for (int x = 0; x < 7; x++) {
            week[x] = new BusDay();
        }
    }

    public void addEmpShift(int wDay, int s, Employee e) {
        week[wDay].addEmpShift(s, e);
    }

    public BusDay getBusDay(int wd) {
        return week[wd];
    }
////////////////////////////////////////////////////////////////////////////////

    public class BusDay {

        Shift[] shifts;

        public BusDay() {
            shifts = new Shift[24 * 4];
            for (int x = 0; x < 24 * 4; x++) {
                shifts[x] = new Shift();
            }
        }

        public void addEmpShift(int s, Employee e) {
            shifts[s].addEmployee(e);
        }

        public Shift getShift(int s) {
            return shifts[s];
        }
    }
////////////////////////////////////////////////////////////////////////////////

    public class Shift {
        /*
         A shift is a unit of time that an employee works. 1 unit is 25 time/15 minutes
         *shift will be renamed for clarity later
         */

        LinkedList<Employee> employees;

        public Shift() {
            employees = new LinkedList<>();
        }

        public void addEmployee(Employee e) {
            employees.add(e);
        }

        public LinkedList<Employee> getEmp() {
            return employees;
        }
    }

}
