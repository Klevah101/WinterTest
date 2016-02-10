/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public enum FamilyName {

    Brown("Brown"), Stone("Stone"), Danvers("Danvers"), Booth("Booth"), Charles("Charles"), Moody("Moody"), Durousseau("Durousseau"), Escarda("Escarda"), Johnson("Johnson"), Williams("Williams"), Rodriguez("Rodriguez"), King("King"), Perez("Perez"), Bass("Bass"), Gallivan("Gallivan"),
    Jacobs("jacobs"), Hall("Hall"), Moore("Moore"), Douglas("Douglas"), Roth("Roth"), Boston("Boston");
    String name;

    FamilyName(String s) {
        name = s;
    }
    
    public String getName(){
        return name;
    }
}
