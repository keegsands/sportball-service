package org.keegsands.sportball.model;

import org.hibernate.annotations.Type;

import jakarta.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "game_time")
public class GameTime {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("h:mm a");

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}


	@Column(columnDefinition = "time")
	private Date timeSlot;

	public Date getTimeSlot() {
		return timeSlot;
	}

	public String getFormattedTime() {
		if (null != getTimeSlot()) {
			return DATE_FORMAT.format(getTimeSlot());
		}
		return "";
	}

	public void setTimeSlot(final Date timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public String toString() {
		return "id=" + getId() + ", timeslot=" + getTimeSlot();
	}
}