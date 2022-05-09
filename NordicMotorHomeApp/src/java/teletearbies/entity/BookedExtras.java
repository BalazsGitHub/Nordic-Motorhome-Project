package teletearbies.entity;

public class BookedExtras {
    private int booking_id;
    private int extra_id;

    public BookedExtras(int booking_id, int extra_id) {
        this.booking_id = booking_id;
        this.extra_id = extra_id;
    }

    public BookedExtras() {
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
    }
}
