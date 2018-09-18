package tech.bts.rooms;

import java.util.*;

public class Main {

    /** Creates the rooms, links them and returns the initial room */
    private static Room prepareRooms() {

        Room red = new Room("red");
        Room green = new Room("green");
        Room blue = new Room("blue");
        Room purple = new Room("purple");
        Room yellow = new Room("yellow");
        Room white = new Room("white");

        red.rooms = Arrays.asList(green);
        green.rooms = Arrays.asList(red, blue, purple);
        blue.rooms = Arrays.asList(green, white);
        purple.rooms = Arrays.asList(green, yellow);
        yellow.rooms = Arrays.asList(purple);
        white.rooms = Arrays.asList(blue);

        return green;
    }

    /** Displays where you are and where you can go */
    private static void displaySituation(Room currentRoom) {

        System.out.println("You are in: " + currentRoom);

        System.out.println("You can go to:");
        List<Room> rooms = currentRoom.rooms;
        for (int i = 0; i < rooms.size(); i++) {
            Room other = rooms.get(i);
            System.out.println(" - " + other);
        }
    }

    /** Searches for the room with the given roomName in the rooms, and returns it */
    private static Room searchRoom(String roomName, List<Room> rooms) {

        Room result = null;

        for (Room room : rooms) {
            if (roomName.equals(room.name)) {
                result = room;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Room initialRoom = prepareRooms();
        Room currentRoom = initialRoom;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            displaySituation(currentRoom);

            System.out.print("Where do you want to go? ");
            String roomName = scanner.nextLine();

            Room destination = searchRoom(roomName, currentRoom.rooms);

            System.out.println("Let's go to: " + destination);
            currentRoom = destination;
        }
    }
}
