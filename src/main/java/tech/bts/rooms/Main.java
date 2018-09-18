package tech.bts.rooms;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        Room currentRoom = green;

        while (true) {

            System.out.println("You are in: " + currentRoom);

            System.out.println("You can go to:");
            List<Room> rooms = currentRoom.rooms;
            for (int i = 0; i < rooms.size(); i++) {
                Room room = rooms.get(i);
                System.out.println(" - " + room);
            }

            System.out.print("Where do you want to go? ");
            String roomName = scanner.nextLine();

            Room destination = null;
            for (Room room : rooms) {
                if (roomName.equals(room.name)) {
                    destination = room;
                }
            }

            System.out.println("Let's go to: " + destination);
            currentRoom = destination;
        }
    }
}
