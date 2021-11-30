package controller;

import model.Database;
import model.Item;

import java.util.ArrayList;

public class Controller {
    Database db = new Database();

    public ArrayList<Item> getInventory() {
        return db.getInventory();
    }

}
