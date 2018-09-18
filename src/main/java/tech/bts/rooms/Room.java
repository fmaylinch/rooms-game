package tech.bts.rooms;

import java.util.List;

public class Room {

    // Fields
    public String name;
    public List<Room> rooms;

    // Constructor
    public Room(String name) {
        this.name = name;
    }

    // Methods


    @Override
    public String toString() {
        return this.name + " room";
    }
}
