package tech.bts.rooms;

import java.util.*;

/**
 *
 * Add another field in Room, called `exit`, which is a boolean
 * that indicates if the room is an exit (to escape).
 *
 * Initialize that field in the constructor.
 *
 * For now, only one room is the exit (the white room).
 *
 * In the game (main method) you have to check if the player is in an exit room.
 * If the player is in an exit room, you finish the game (you can use `break;` to exit the loop).
 */

public class Main {

    /** Creates the rooms, links them and returns the initial room */
    private static Room prepareRooms() {

        Room red = new Room("red", false);
        Room green = new Room("green", false);
        Room blue = new Room("blue", false);
        Room purple = new Room("purple", false);
        Room yellow = new Room("yellow", false);
        Room white = new Room("white", true);

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

            if (destination == null) {
                System.out.println("You can't go to: " + roomName);
            } else {
                currentRoom = destination;

                if (currentRoom.exit) {
                    System.out.println("You found the exit, well done, you won!");
                    break;
                }
            }
        }
    }
}
