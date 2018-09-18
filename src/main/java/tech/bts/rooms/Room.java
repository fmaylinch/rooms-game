package tech.bts.rooms;

import java.util.List;

public class Room {

    // Fields
    public String name;
    public List<Room> rooms;
    public boolean exit;

    // Constructor
    public Room(String name, boolean exit) {
        this.name = name;
        this.exit = exit;
    }

    // Methods


    @Override
    public String toString() {
        return this.name + " room";
    }
}
