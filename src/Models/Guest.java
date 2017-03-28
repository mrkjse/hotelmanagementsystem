/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "GUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g")
    , @NamedQuery(name = "Guest.findByGuestId", query = "SELECT g FROM Guest g WHERE g.guestId = :guestId")
    , @NamedQuery(name = "Guest.findByTitle", query = "SELECT g FROM Guest g WHERE g.title = :title")
    , @NamedQuery(name = "Guest.findByFirstName", query = "SELECT g FROM Guest g WHERE g.firstName = :firstName")
    , @NamedQuery(name = "Guest.findByLastName", query = "SELECT g FROM Guest g WHERE g.lastName = :lastName")
    , @NamedQuery(name = "Guest.findByDob", query = "SELECT g FROM Guest g WHERE g.dob = :dob")
    , @NamedQuery(name = "Guest.findByCountry", query = "SELECT g FROM Guest g WHERE g.country = :country")
    , @NamedQuery(name = "Guest.findByCity", query = "SELECT g FROM Guest g WHERE g.city = :city")
    , @NamedQuery(name = "Guest.findByStreet", query = "SELECT g FROM Guest g WHERE g.street = :street")
    , @NamedQuery(name = "Guest.findByPostalCode", query = "SELECT g FROM Guest g WHERE g.postalCode = :postalCode")
    , @NamedQuery(name = "Guest.findByPhoneNumber", query = "SELECT g FROM Guest g WHERE g.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Guest.findByEmailAddress", query = "SELECT g FROM Guest g WHERE g.emailAddress = :emailAddress")})
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GUEST_ID")
    private BigDecimal guestId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "STREET")
    private String street;
    @Basic(optional = false)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guest")
    private Collection<BookingRoomGuest> bookingRoomGuestCollection;
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID")
    @ManyToOne(optional = false)
    private Booking bookingId;

    public Guest() {
    }

    public Guest(BigDecimal guestId) {
        this.guestId = guestId;
    }

    public Guest(BigDecimal guestId, String title, String firstName, String lastName, Date dob, String country, String city, String street, String postalCode, String phoneNumber, String emailAddress) {
        this.guestId = guestId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public BigDecimal getGuestId() {
        return guestId;
    }

    public void setGuestId(BigDecimal guestId) {
        this.guestId = guestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlTransient
    public Collection<BookingRoomGuest> getBookingRoomGuestCollection() {
        return bookingRoomGuestCollection;
    }

    public void setBookingRoomGuestCollection(Collection<BookingRoomGuest> bookingRoomGuestCollection) {
        this.bookingRoomGuestCollection = bookingRoomGuestCollection;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Guest[ guestId=" + guestId + " ]";
    }
    
}
