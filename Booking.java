class Booking {
    String customerName;
    int roomNumber;
    String category;
    double amountPaid;
    String paymentStatus;

    public Booking(String customerName, int roomNumber, String category, double amountPaid, String paymentStatus) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
    }

    public String toString() {
        return customerName + "," + roomNumber + "," + category + "," + amountPaid + "," + paymentStatus;
    }
}
