/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mrkjse
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByCheckInDate", query = "SELECT b FROM Booking b WHERE b.checkInDate = :checkInDate")
    , @NamedQuery(name = "Booking.findByCheckOutDate", query = "SELECT b FROM Booking b WHERE b.checkOutDate = :checkOutDate")
    , @NamedQuery(name = "Booking.findByContactPerson", query = "SELECT b FROM Booking b WHERE b.contactPerson = :contactPerson")
    , @NamedQuery(name = "Booking.findByContactEmail", query = "SELECT b FROM Booking b WHERE b.contactEmail = :contactEmail")
    , @NamedQuery(name = "Booking.findByTotalAmount", query = "SELECT b FROM Booking b WHERE b.totalAmount = :totalAmount")
    , @NamedQuery(name = "Booking.findByPaymentStatusCode", query = "SELECT b FROM Booking b WHERE b.paymentStatusCode = :paymentStatusCode")})
public class Booking implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private Collection<BookingRoomGuest> bookingRoomGuestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private Collection<Guest> guestCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BOOKING_ID")
    private BigDecimal bookingId;
    @Basic(optional = false)
    @Column(name = "CHECK_IN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Basic(optional = false)
    @Column(name = "CHECK_OUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    @Basic(optional = false)
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Basic(optional = false)
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Basic(optional = false)
    @Column(name = "TOTAL_AMOUNT")
    private BigInteger totalAmount;
    @Basic(optional = false)
    @Column(name = "PAYMENT_STATUS_CODE")
    private String paymentStatusCode;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer roomId;

    public Booking() {
    }

    public Booking(BigDecimal bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(BigDecimal bookingId, Date checkInDate, Date checkOutDate, String contactPerson, String contactEmail, BigInteger totalAmount, String paymentStatusCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
        this.totalAmount = totalAmount;
        this.paymentStatusCode = paymentStatusCode;
    }

    public BigDecimal getBookingId() {
        return bookingId;
    }

    public void setBookingId(BigDecimal bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public BigInteger getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigInteger totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(String paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public Customer getCustomerId() {
        return roomId;
    }

    public void setCustomerId(Customer roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Booking[ bookingId=" + bookingId + " ]";
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<BookingRoomGuest> getBookingRoomGuestCollection() {
        return bookingRoomGuestCollection;
    }

    public void setBookingRoomGuestCollection(Collection<BookingRoomGuest> bookingRoomGuestCollection) {
        this.bookingRoomGuestCollection = bookingRoomGuestCollection;
    }

    @XmlTransient
    public Collection<Guest> getGuestCollection() {
        return guestCollection;
    }

    public void setGuestCollection(Collection<Guest> guestCollection) {
        this.guestCollection = guestCollection;
    }
    
}
