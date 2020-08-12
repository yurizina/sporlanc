package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Item;

public class ItemDAOImpl implements ItemDAO {

	private JdbcTemplate jdbcTemplate;

	public ItemDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Item item) {
		
		if (item.getItem_id() > 0) {
			// update
			String sql = "UPDATE item SET name =?, price =?, availability =?, type =? WHERE item_id =?";
			jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getAvailability(), item.getType(),
					item.getItem_id());
		} else {
			// insert
			String sql = "INSERT INTO item (name, price, availability, type) VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getAvailability(), item.getType());
		}

	}

	@Override
	public void delete(int item_id) {
		String sql = "DELETE FROM item WHERE item_id=?";
		jdbcTemplate.update(sql, item_id);
	}

	@Override
	public Item getItem(int item_id) {
		String sql = "SELECT * FROM item WHERE item_id = " + item_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Item>() {

			@Override
			public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Item item = new Item();
					item.setItem_id(rs.getInt("item_id"));
					item.setName(rs.getString("name"));
					item.setPrice(rs.getInt("price"));
					item.setAvailability(rs.getString("availability"));
					item.setType(rs.getString("type"));
					return item;
				}

				return null;
			}

		});
	}

	@Override
	public List<Item> list() {
		String sql = "SELECT * FROM item";
		List<Item> listItem = jdbcTemplate.query(sql, new RowMapper<Item>() {

			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item aItem = new Item();

				aItem.setItem_id(rs.getInt("item_id"));
				aItem.setName(rs.getString("name"));
				aItem.setPrice(rs.getInt("price"));
				aItem.setAvailability(rs.getString("availability"));
				aItem.setType(rs.getString("type"));

				return aItem;
			}

		});
		return listItem;
	}

}
