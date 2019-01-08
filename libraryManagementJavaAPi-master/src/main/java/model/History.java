package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;


@Entity
@NamedQuery(name="getAllHistorys", query="SELECT h FROM History h")
public class History extends BaseEntity{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static final String GET_ALL_HISTORYS_QUERY_NAME = "getAllHistorys";
	
	private Date reservationDate;
	private Date pickupDate;
	private Date deliveryDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Book historyBook;
	@ManyToOne(cascade = CascadeType.ALL)
	private User historyUser; 
	
	public History(){}

	public History(Date reservationDate, Date pickupDate, Date deliveryDate, Book historyBook, User historyUser) {
		super();
		this.reservationDate = reservationDate;
		this.pickupDate = pickupDate;
		this.deliveryDate = deliveryDate;
		this.historyBook = historyBook;
		this.historyUser = historyUser;
	}
	@PrePersist
	void onCreate() {
		this.reservationDate= new Date();
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Book getHistoryBook() {
		return historyBook;
	}

	public void setHistoryBook(Book historyBook) {
		this.historyBook = historyBook;
	}

	public User getHistoryUser() {
		return historyUser;
	}

	public void setHistoryUser(User historyUser) {
		this.historyUser = historyUser;
	}

	@Override
	public String toString() {
		return "History [reservationDate=" + reservationDate + ", pickupDate=" + pickupDate + ", deliveryDate="
				+ deliveryDate + ", historyBook=" + historyBook + ", historyUser=" + historyUser + "]";
	}

	

	
	


}
