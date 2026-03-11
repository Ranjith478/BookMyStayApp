import java.util.LinkedList;
import java.util.Queue;

/* ---------- Reservation Class ---------- */

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

/* ---------- Booking Request Queue ---------- */

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

/* ---------- Main Class ---------- */

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {

            Reservation r = bookingQueue.getNextRequest();

            System.out.println("Processing Request:");
            System.out.println("Guest: " + r.getGuestName());
            System.out.println("Room Type: " + r.getRoomType());
            System.out.println();
        }
    }
}