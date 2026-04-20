import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService();
        service.loadRooms();

        FileHandler.load(service.bookings, service.rooms);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.searchRooms();
                case 2 -> service.bookRoom();
            }

        } while (choice != 3);

        FileHandler.save(service.bookings);
    }
}
