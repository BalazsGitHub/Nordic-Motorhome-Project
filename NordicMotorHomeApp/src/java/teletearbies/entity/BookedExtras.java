package teletearbies.entity;

import javax.persistence.*;

@Entity
@Table(name = "booked_extras")
public class BookedExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Booking booking_id;

    private int extra_id;

    @ManyToOne
    @JoinColumn(name = "booking")
    private Booking booking;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BookedExtras(Booking booking_id, int extra_id) {
        this.booking_id = booking_id;
        this.extra_id = extra_id;
    }

    public BookedExtras() {
    }

}