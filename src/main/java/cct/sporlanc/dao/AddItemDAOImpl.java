package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.AddItem;

public class AddItemDAOImpl implements AddItemDAO {

	private JdbcTemplate jdbcTemplate;

	public AddItemDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(AddItem addItem) {

		if (addItem.getAddItem_ID() > 0) {
			// update
			String sql = "UPDATE additem SET quantity = ?, bookingID = ?, item_id = ? WHERE addItem_ID = ?";
			jdbcTemplate.update(sql, addItem.getQuantity(), addItem.getBookingID(), addItem.getItem_id(),
					addItem.getAddItem_ID());

		} else {
			// insert
			String sql = "INSERT INTO additem (quantity, bookingID, item_id) VALUES (?,?,?);";
			jdbcTemplate.update(sql, addItem.getQuantity(), addItem.getBookingID(), addItem.getItem_id());
		}

	}

	@Override
	public void delete(int addItem_id) {
		String sql = "DELETE FROM additem WHERE addItem_ID =?";
		jdbcTemplate.update(sql, addItem_id);

	}

	@Override
	public AddItem getAddItem(int addItem_id) {
		String sql = "SELECT * FROM additem WHERE addItem_id = " + addItem_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<AddItem>() {

			@Override
			public AddItem extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					AddItem additem = new AddItem();
					additem.setAddItem_ID(rs.getInt("addItem_ID"));
					additem.setQuantity(rs.getInt("quantity"));
					additem.setBookingID(rs.getInt("bookingID"));
					additem.setItem_id(rs.getInt("item_id"));

					return additem;
				}

				return null;
			}

		});
	}

	@Override
	public List<AddItem> list() {
		String sql = "SELECT * FROM additem";
		List<AddItem> listItem = jdbcTemplate.query(sql, new RowMapper<AddItem>() {

			public AddItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				AddItem additem = new AddItem();

				additem.setAddItem_ID(rs.getInt("addItem_ID"));
				additem.setQuantity(rs.getInt("quantity"));
				additem.setBookingID(rs.getInt("bookingID"));
				additem.setItem_id(rs.getInt("item_id"));

				return additem;
			}

		});
		return listItem;

	}

	@Override
	public List<AddItem> listBookingID(int booking_id) {
		
		String sql = "SELECT * FROM additem WHERE bookingID = " + booking_id;
		List<AddItem> listItem = jdbcTemplate.query(sql, new RowMapper<AddItem>() {

			public AddItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				AddItem additem = new AddItem();

				additem.setAddItem_ID(rs.getInt("addItem_ID"));
				additem.setQuantity(rs.getInt("quantity"));
				additem.setBookingID(rs.getInt("bookingID"));
				additem.setItem_id(rs.getInt("item_id"));

				return additem;
			}

		});
		return listItem;
	}

}
