package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Booking;

public class BookingDAOImpl implements BookingDAO {

	private JdbcTemplate jdbcTemplate;

	public BookingDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Booking booking) {
		
		if (booking.getBooking_ID() > 0) {
			// update
			String seql = "UPDATE booking SET studentID =?, subscription = ?, "
					+ "from_date =?, class_ID = ? WHERE booking_ID = ?";

			jdbcTemplate.update(seql, booking.getStudentID(), booking.getSubscription(),
					booking.getFrom_date(), booking.getClass_ID(), booking.getBooking_ID());
		} else {
			// insert
			String sql = "INSERT INTO booking (studentID, subscription, from_date, class_ID) VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, booking.getStudentID(), booking.getSubscription(),
					booking.getFrom_date(), booking.getClass_ID());
		}

	}

	@Override
	public void delete(int booking_id) {
		String sql = "DELETE FROM booking WHERE booking_ID=?";
		jdbcTemplate.update(sql, booking_id);
	}

	@Override
	public Booking getBooking(int booking_id) {
		String sql = "SELECT * FROM booking WHERE booking_ID = " + booking_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Booking>() {

			@Override
			public Booking extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Booking booking = new Booking();
					
					booking.setBooking_ID(rs.getInt("booking_ID"));
					booking.setStudentID(rs.getInt("studentID"));
					booking.setSubscription(rs.getString("subscription"));
					booking.setFrom_date(rs.getString("from_date"));
					booking.setClass_ID(rs.getInt("class_ID"));
					
					return booking;
				}

				return null;
			}
		});
	}

	@Override
	public List<Booking> list() {
		String sql = "SELECT * FROM booking";
		List<Booking> listBooking = jdbcTemplate.query(sql, new RowMapper<Booking>() {

			public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
				Booking aBooking = new Booking();
				
				aBooking.setBooking_ID(rs.getInt("booking_ID"));
				aBooking.setStudentID(rs.getInt("studentID"));
				aBooking.setSubscription(rs.getString("subscription"));
				aBooking.setFrom_date(rs.getString("from_date"));
				aBooking.setClass_ID(rs.getInt("class_ID"));
				
				return aBooking;

			}

		});
		return listBooking;
	}

	@Override
	public List<Booking> listEachStudent(int studentID) {
		String sql = "SELECT * FROM booking WHERE studentID = " + studentID;
		List<Booking> listBooking = jdbcTemplate.query(sql, new RowMapper<Booking>() {

			public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
				Booking aBooking = new Booking();
				
				aBooking.setBooking_ID(rs.getInt("booking_ID"));
				aBooking.setStudentID(rs.getInt("studentID"));
				aBooking.setSubscription(rs.getString("subscription"));
				aBooking.setFrom_date(rs.getString("from_date"));
				aBooking.setClass_ID(rs.getInt("class_ID"));
				
				return aBooking;

			}

		});
		return listBooking;
	}

}
