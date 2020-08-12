package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Eircode;


public class EircodeDAOImpl implements EircodeDAO {

	private JdbcTemplate jdbcTemplate;

	public EircodeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(Eircode eircode) {
		if (eircode.getEircode_ID() > 0) {
			//update 
			String sql = "UPDATE eircode SET eircode =? WHERE eircode_ID = ?";
			jdbcTemplate.update(sql, eircode.getEircode(), eircode.getEircode_ID());
		} else {
			//insert 
			String sql = "INSERT INTO eircode (eircode) VALUES (?)";
			jdbcTemplate.update(sql, eircode.getEircode());
			
		}

	}
	@SuppressWarnings("deprecation")
	@Override
	public int index(Eircode eircode) {
		String sqlindex = "SELECT eircode_ID FROM eircode WHERE eircode = ?";
		return jdbcTemplate.queryForInt(sqlindex, eircode.getEircode());
	}

	@Override
	public void delete(int eircode_id) {
		String sql = "DELETE FROM eircode WHERE eircode_ID=?";
		jdbcTemplate.update(sql, eircode_id);

	}

	@Override
	public Eircode getEircode(int eircode_id) {
		String sql = "SELECT * FROM eircode WHERE eircode_ID = " + eircode_id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Eircode>() {
			
			@Override
			public Eircode extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
				Eircode eircode = new Eircode();
				eircode.setEircode_ID(rs.getInt("eircode_ID"));
				eircode.setEircode(rs.getString("eircode"));
				return eircode;
			}

			return null;
		}

	});
}

	@Override
	public List<Eircode> list() {
		String sql = "SELECT * FROM eircode";
		List<Eircode> listEircode = jdbcTemplate.query(sql, new RowMapper<Eircode>() {
			
			public Eircode mapRow(ResultSet rs, int rowNum) throws SQLException{
				Eircode eircode = new Eircode();
				eircode.setEircode_ID(rs.getInt("eircode_ID"));
				eircode.setEircode(rs.getString("eircode"));
				return eircode;
			}
		});
		return listEircode;
	}

}
