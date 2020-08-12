package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Booking;

public interface BookingDAO {

	public void saveOrUpdate(Booking booking);

	public void delete(int booking_id);

	public Booking getBooking(int booking_id);

	public List<Booking> list();

	public List<Booking> listEachStudent(int studentID);
}