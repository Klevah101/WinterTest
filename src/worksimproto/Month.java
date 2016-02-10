/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public enum Month {

    Jan("January", 31, 1),
    Feb("February", 28, 2),
    Mar("March", 31, 3),
    Apr("April", 30, 4),
    May("May", 31, 5),
    Jun("June", 30, 6),
    Jul("July", 31, 7),
    Aug("August", 31, 8),
    Sep("September", 30, 9),
    Oct("October", 31, 10),
    Nov("November", 30, 11),
    Dec("December", 31, 12);

    String name;
    int days;
    int mNum;

    Month(String n, int d, int mn) {
        name = n;
        days = d;
        mNum = mn;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }
}
