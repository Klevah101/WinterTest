/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksimproto;

/**

 @author Chuck
 */
public class Building {

    int loadDock;//Number of loading docks. No docks means no big shipments.
    int storeRoom;//Number of storage rooms.
    int coldStore;//Number of cold storage rooms
    int rent;//Monthly fee for leasing property
    Storage[] storages;

    public Building() {
        loadDock = 1;
        storeRoom = 2;
        coldStore = 1;
        rent = 1000;

        storages = new Storage[storeRoom+coldStore];

        setupStorage();
        
        for (Storage s : storages) {
            System.out.println(s.getCold());
        }
                
    }

    public void setupStorage() {
        if (storeRoom > 0) {
            for (int x = 0; x < storeRoom; x++) {
                storages[x] = new Storage();
                storages[x].setCold(false);

            }
        }
        if (coldStore > 0) {
            for (int x = 0; x < coldStore; x++) {
                storages[x + storeRoom] = new Storage();
                storages[x + storeRoom].setCold(true);
            }
        }
    }

    public class Storage {

        private boolean cold;
        private int space;

        public Storage() {
            cold = false;
            space = 400;
        }

        public void setCold(boolean b) {
            cold = b;
        }

        public boolean getCold() {
            return cold;
        }
    }
}
