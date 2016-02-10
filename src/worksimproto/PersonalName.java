/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public enum PersonalName {

    Larry("Larry"), Beth("Beth"), Brandon("Brandon"), Sarah("Sarah"), Kevin("Kevin"), Jamal("Jamal"), Eve("Eve"),
    Stephen("Stephen");
    String name;

    PersonalName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }
}
