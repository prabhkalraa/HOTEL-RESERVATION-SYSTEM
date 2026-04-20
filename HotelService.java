import java.util.*;

class HotelService {
    List<Room> rooms = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void loadRooms() {
        for (int i = 101; i <= 105; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 201; i <= 205; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 301; i <= 305; i++) rooms.add(new Room(i, "Suite"));
    }

    void searchRooms() {
        System.out.print("Enter room type: ");
        String category = scanner.nextLine();

        for (Room r : rooms) {
            if (r.category.equalsIgnoreCase(category) && !r.isBooked) {
                System.out.println("Available: Room " + r.roomNumber);
            }
        }
    }

    void bookRoom() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        for (Room r : rooms) {
            if (!r.isBooked && r.category.equalsIgnoreCase(category)) {
                r.isBooked = true;
                bookings.add(new Booking(name, r.roomNumber, category, 1000, "Paid"));
                System.out.println("Booked Room " + r.roomNumber);
                return;
            }
        }

        System.out.println("No rooms available.");
    }
}
