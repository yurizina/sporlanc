package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Parent;

public class ParentDAOImpl implements ParentDAO {

	private JdbcTemplate jdbcTemplate;

	public ParentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Parent parent) {
		if (parent.getUser_ID() > 0) {
			String sql = "UPDATE parent SET first_name = ?, surname = ?, address = ?, phone = ?, eircodeID = ?, username = ?, "
					+ "email = ?, password = ? WHERE user_ID = ?";
			jdbcTemplate.update(sql, parent.getFirst_name(), parent.getSurname(), parent.getAddress(),
					parent.getPhone(), parent.getEircodeID(), parent.getUsername(), parent.getEmail(), parent.getPassword(), parent.getUser_ID());

		} else {
			String sql = "INSERT INTO parent (first_name, surname, address, phone, eircodeID, username, email, password) VALUES (?,?,?,?,?,?,?,?)"; 
			jdbcTemplate.update(sql, parent.getFirst_name(), parent.getSurname(), parent.getAddress(),
					parent.getPhone(), parent.getEircodeID(), parent.getUsername(), parent.getEmail(), parent.getPassword());
		}

	}

	@Override
	public void delete(int user_id) {
		String sql = "DELETE FROM parent WHERE user_ID=?";
		jdbcTemplate.update(sql, user_id);
		
	}

	@Override
	public Parent getParent(int user_id) {
		String sql = "SELECT * FROM parent WHERE user_ID = " + user_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Parent>() {

			@Override
			public Parent extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Parent pt = new Parent();
					pt.setUser_ID(rs.getInt("user_ID"));
					pt.setFirst_name(rs.getString("first_name"));
					pt.setSurname(rs.getString("surname"));
					pt.setAddress(rs.getString("address"));
					pt.setPhone(rs.getInt("phone"));
					pt.setEircodeID(rs.getInt("eircodeID"));
					pt.setUsername(rs.getString("username"));
					pt.setEmail(rs.getString("email"));
					pt.setPassword(rs.getString("password"));
				
					return pt;
				}

				return null;
			}

		});
	}

	@Override
	public List<Parent> list() {
		String sql = "SELECT * FROM parent";
		List<Parent> listParent = jdbcTemplate.query(sql, new RowMapper<Parent>() {

			public Parent mapRow(ResultSet rs, int rowNum) throws SQLException {
				Parent pat = new Parent();
				pat.setUser_ID(rs.getInt("user_ID"));
				pat.setFirst_name(rs.getString("first_name"));
				pat.setSurname(rs.getString("surname"));
				pat.setAddress(rs.getString("address"));
				pat.setPhone(rs.getInt("phone"));
				pat.setEircodeID(rs.getInt("eircodeID"));
				pat.setUsername(rs.getString("username"));
				pat.setEmail(rs.getString("email"));
				pat.setPassword(rs.getString("password"));
			
			
				return pat;
			}

		});
		return listParent;
	}
}
