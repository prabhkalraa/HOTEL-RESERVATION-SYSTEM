import java.io.*;
import java.util.*;

class FileHandler {
    static final String FILE_NAME = "bookings.txt";

    static void save(List<Booking> bookings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                writer.write(b.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void load(List<Booking> bookings, List<Room> rooms) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Booking b = new Booking(data[0], Integer.parseInt(data[1]), data[2],
                        Double.parseDouble(data[3]), data[4]);
                bookings.add(b);

                for (Room r : rooms) {
                    if (r.roomNumber == b.roomNumber) {
                        r.isBooked = true;
                        break;
                    }
                }
            }
        } catch (IOException ignored) {}
    }
}
