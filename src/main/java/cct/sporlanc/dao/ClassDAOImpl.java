package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Classe;

public class ClassDAOImpl implements ClassDAO {

	private JdbcTemplate jdbcTemplate;

	public ClassDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Classe classe) {
		
		if (classe.getClass_ID() > 0) {
			// update
			String sql = "UPDATE class SET period =?, days =?, capacity =?, price =?, type =?, sport_id =?, emp_id =?, ages_under =?, language = ? WHERE class_ID = ?";
			jdbcTemplate.update(sql, classe.getPeriod(), classe.getDays(), classe.getCapactity(),
					classe.getPrice(), classe.getType(), classe.getSport_id(), classe.getEmp_id(),classe.getAges_id(), classe.getLanguage(), classe.getClass_ID());

			
		} else {
			// insert
			String sql = "INSERT INTO class (period, days, capacity, price, type, sport_id, emp_id, ages_under, language) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, classe.getPeriod(), classe.getDays(), classe.getCapactity(),
					classe.getPrice(), classe.getType(), classe.getSport_id(), classe.getEmp_id(), classe.getAges_id(), classe.getLanguage());
		}
	}
	
	@Override
	public void delete(int class_id) {
		String sql = "DELETE FROM class WHERE class_ID = ?";
		jdbcTemplate.update(sql, class_id);
	}
	

	@Override
	public Classe getClass(int class_id) {
		String sql = "SELECT * FROM class WHERE class_ID = " + class_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Classe>() {

			@Override
			public Classe extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Classe cl = new Classe();
					
					cl.setClass_ID(rs.getInt("class_ID"));
					//Period session
					cl.setPeriod(rs.getString("period"));
					if(rs.getString("period").equalsIgnoreCase("M1")) {
						cl.setPeriod2("9h00 - 10h30 am");
					}
					if(rs.getString("period").equalsIgnoreCase("M2")) {
						cl.setPeriod2("10h30 - 12h00 pm");
					}
					if(rs.getString("period").equalsIgnoreCase("A1")) {
						cl.setPeriod2("1h00 - 2h30 pm");
					}
					if(rs.getString("period").equalsIgnoreCase("A2")) {
						cl.setPeriod2("2h30 - 4h00 pm");
					}
					
					cl.setDays(rs.getString("days"));
					cl.setCapactity(rs.getInt("capacity"));
					cl.setPrice(rs.getInt("price"));
					
					//type session
					cl.setType(rs.getString("type"));
					if(rs.getString("type").equalsIgnoreCase("P")) {
						cl.setType2("Private");
					}
					if(rs.getString("type").equalsIgnoreCase("G")) {
						cl.setType2("Group");
					}
					cl.setEmp_id(rs.getInt("emp_id"));
					cl.setAges_id(rs.getInt("ages_under"));
					//Languages session 
					cl.setLanguage(rs.getString("language"));
					if(rs.getString("language").equalsIgnoreCase("e")) {
						cl.setLanguage2("English");
					}
					if(rs.getString("language").equalsIgnoreCase("s")) {
						cl.setLanguage2("Spanish");
					}
					
					//Sport session
					cl.setSport_id(rs.getInt("sport_id"));
					if (rs.getInt("sport_id") == 1){
						cl.set_sport("Football");
					}
					else if(rs.getInt("sport_id") == 2) {
						cl.set_sport("Volleyball");
					} else if(rs.getInt("sport_id") == 3) {
						cl.set_sport("Basketball");
					} else if(rs.getInt("sport_id") == 4) {
						cl.set_sport("Handball");
					} else if(rs.getInt("sport_id") == 5) {
						cl.set_sport("Horse Riding");
					} else if(rs.getInt("sport_id") == 6) {
						cl.set_sport("Fencing");
					} else if(rs.getInt("sport_id") == 7) {
						cl.set_sport("Golf");
					}
					

					return cl;
				}

				return null;
			}

		});
	}

	@Override
	public List<Classe> list() {
		String sql = "SELECT * FROM class";
		List<Classe> listClass = jdbcTemplate.query(sql, new RowMapper<Classe>() {
			public Classe mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classe cl = new Classe();

				cl.setClass_ID(rs.getInt("class_ID"));
				//Period session
				cl.setPeriod(rs.getString("period"));
				if(rs.getString("period").equalsIgnoreCase("M1")) {
					cl.setPeriod2("9h00 - 10h30 am");
				}
				if(rs.getString("period").equalsIgnoreCase("M2")) {
					cl.setPeriod2("10h30 - 12h00 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A1")) {
					cl.setPeriod2("1h00 - 2h30 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A2")) {
					cl.setPeriod2("2h30 - 4h00 pm");
				}
				
				cl.setDays(rs.getString("days"));
				cl.setCapactity(rs.getInt("capacity"));
				cl.setPrice(rs.getInt("price"));
				
				//type session
				cl.setType(rs.getString("type"));
				if(rs.getString("type").equalsIgnoreCase("P")) {
					cl.setType2("Private");
				}
				if(rs.getString("type").equalsIgnoreCase("G")) {
					cl.setType2("Group");
				}
				cl.setEmp_id(rs.getInt("emp_id"));
				cl.setAges_id(rs.getInt("ages_under"));
				//Languages session 
				cl.setLanguage(rs.getString("language"));
				if(rs.getString("language").equalsIgnoreCase("e")) {
					cl.setLanguage2("English");
				}
				if(rs.getString("language").equalsIgnoreCase("s")) {
					cl.setLanguage2("Spanish");
				}
				
				//Sport session
				cl.setSport_id(rs.getInt("sport_id"));
				if (rs.getInt("sport_id") == 1){
					cl.set_sport("Football");
				}
				else if(rs.getInt("sport_id") == 2) {
					cl.set_sport("Volleyball");
				} else if(rs.getInt("sport_id") == 3) {
					cl.set_sport("Basketball");
				} else if(rs.getInt("sport_id") == 4) {
					cl.set_sport("Handball");
				} else if(rs.getInt("sport_id") == 5) {
					cl.set_sport("Horse Riding");
				} else if(rs.getInt("sport_id") == 6) {
					cl.set_sport("Fencing");
				} else if(rs.getInt("sport_id") == 7) {
					cl.set_sport("Golf");
				}
				
				/*
				 * cla.setClass_ID(rs.getInt("class_ID"));
				 * cla.setPeriod(rs.getString("period")); cla.setDays(rs.getString("days"));
				 * cla.setCapactity(rs.getInt("capacity")); cla.setPrice(rs.getInt("price"));
				 * cla.setType(rs.getString("type")); cla.setSport_id(rs.getInt("sport_id"));
				 * cla.setEmp_id(rs.getInt("emp_id")); cla.setAges_id(rs.getInt("ages_under"));
				 * cla.setLanguage(rs.getString("language"));
				 */

				return cl;

			}
		});
		return listClass;
	}
	
	@Override
	public List<Classe> listClassesStaff(int emp_id) {
		String sql = "SELECT * FROM class WHERE emp_id = " + emp_id;
		List<Classe> listClass = jdbcTemplate.query(sql, new RowMapper<Classe>() {
			public Classe mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classe cl = new Classe();

				cl.setClass_ID(rs.getInt("class_ID"));
				//Period session
				cl.setPeriod(rs.getString("period"));
				if(rs.getString("period").equalsIgnoreCase("M1")) {
					cl.setPeriod2("9h00 - 10h30 am");
				}
				if(rs.getString("period").equalsIgnoreCase("M2")) {
					cl.setPeriod2("10h30 - 12h00 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A1")) {
					cl.setPeriod2("1h00 - 2h30 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A2")) {
					cl.setPeriod2("2h30 - 4h00 pm");
				}
				
				cl.setDays(rs.getString("days"));
				cl.setCapactity(rs.getInt("capacity"));
				cl.setPrice(rs.getInt("price"));
				
				//type session
				cl.setType(rs.getString("type"));
				if(rs.getString("type").equalsIgnoreCase("P")) {
					cl.setType2("Private");
				}
				if(rs.getString("type").equalsIgnoreCase("G")) {
					cl.setType2("Group");
				}
				cl.setEmp_id(rs.getInt("emp_id"));
				cl.setAges_id(rs.getInt("ages_under"));
				//Languages session 
				cl.setLanguage(rs.getString("language"));
				if(rs.getString("language").equalsIgnoreCase("e")) {
					cl.setLanguage2("English");
				}
				if(rs.getString("language").equalsIgnoreCase("s")) {
					cl.setLanguage2("Spanish");
				}
				
				//Sport session
				cl.setSport_id(rs.getInt("sport_id"));
				if (rs.getInt("sport_id") == 1){
					cl.set_sport("Football");
				}
				else if(rs.getInt("sport_id") == 2) {
					cl.set_sport("Volleyball");
				} else if(rs.getInt("sport_id") == 3) {
					cl.set_sport("Basketball");
				} else if(rs.getInt("sport_id") == 4) {
					cl.set_sport("Handball");
				} else if(rs.getInt("sport_id") == 5) {
					cl.set_sport("Horse Riding");
				} else if(rs.getInt("sport_id") == 6) {
					cl.set_sport("Fencing");
				} else if(rs.getInt("sport_id") == 7) {
					cl.set_sport("Golf");
				}
				
				/*
				 * cla.setClass_ID(rs.getInt("class_ID"));
				 * cla.setPeriod(rs.getString("period")); cla.setDays(rs.getString("days"));
				 * cla.setCapactity(rs.getInt("capacity")); cla.setPrice(rs.getInt("price"));
				 * cla.setType(rs.getString("type")); cla.setSport_id(rs.getInt("sport_id"));
				 * cla.setEmp_id(rs.getInt("emp_id")); cla.setAges_id(rs.getInt("ages_under"));
				 * cla.setLanguage(rs.getString("language"));
				 */

				return cl;

			}
		});
		return listClass;
	}
	@Override
	public List<Classe> groupClasses(Classe classe) {
		//System.out.println(classe.getType());
		//System.out.println(classe.getStudent_id());
		final int student_id = classe.getStudent_id();
		
		String sql = "SELECT * FROM class WHERE type = '" + classe.getType() + "'";
		List<Classe> listClass = jdbcTemplate.query(sql, new RowMapper<Classe>() {
			public Classe mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				
				
				Classe cl = new Classe();
				cl.setStudent_id(student_id);
				cl.setClass_ID(rs.getInt("class_ID"));
				//Period session
				cl.setPeriod(rs.getString("period"));
				if(rs.getString("period").equalsIgnoreCase("M1")) {
					cl.setPeriod2("9h00 - 10h30 am");
				}
				if(rs.getString("period").equalsIgnoreCase("M2")) {
					cl.setPeriod2("10h30 - 12h00 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A1")) {
					cl.setPeriod2("1h00 - 2h30 pm");
				}
				if(rs.getString("period").equalsIgnoreCase("A2")) {
					cl.setPeriod2("2h30 - 4h00 pm");
				}
				
				cl.setDays(rs.getString("days"));
				cl.setCapactity(rs.getInt("capacity"));
				cl.setPrice(rs.getInt("price"));
				
				//type session
				cl.setType(rs.getString("type"));
				if(rs.getString("type").equalsIgnoreCase("P")) {
					cl.setType2("Private");
				}
				if(rs.getString("type").equalsIgnoreCase("G")) {
					cl.setType2("Group");
				}
				cl.setEmp_id(rs.getInt("emp_id"));
				cl.setAges_id(rs.getInt("ages_under"));
				//Languages session 
				cl.setLanguage(rs.getString("language"));
				if(rs.getString("language").equalsIgnoreCase("e")) {
					cl.setLanguage2("English");
				}
				if(rs.getString("language").equalsIgnoreCase("s")) {
					cl.setLanguage2("Spanish");
				}
				
				//Sport session
				cl.setSport_id(rs.getInt("sport_id"));
				if (rs.getInt("sport_id") == 1){
					cl.set_sport("Football");
				}
				else if(rs.getInt("sport_id") == 2) {
					cl.set_sport("Volleyball");
				} else if(rs.getInt("sport_id") == 3) {
					cl.set_sport("Basketball");
				} else if(rs.getInt("sport_id") == 4) {
					cl.set_sport("Handball");
				} else if(rs.getInt("sport_id") == 5) {
					cl.set_sport("Horse Riding");
				} else if(rs.getInt("sport_id") == 6) {
					cl.set_sport("Fencing");
				} else if(rs.getInt("sport_id") == 7) {
					cl.set_sport("Golf");
				}
				
				/*
				 * cla.setClass_ID(rs.getInt("class_ID"));
				 * cla.setPeriod(rs.getString("period")); cla.setDays(rs.getString("days"));
				 * cla.setCapactity(rs.getInt("capacity")); cla.setPrice(rs.getInt("price"));
				 * cla.setType(rs.getString("type")); cla.setSport_id(rs.getInt("sport_id"));
				 * cla.setEmp_id(rs.getInt("emp_id")); cla.setAges_id(rs.getInt("ages_under"));
				 * cla.setLanguage(rs.getString("language"));
				 */
				return cl;

			}
		});
		return listClass;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getID(Classe classe) {
		
		String sql = "SELECT class_ID FROM class WHERE period =? and days =? and capacity =? and price =? and type =? and sport_id =? and emp_id =? and ages_under =? and language = ?"; 
		int id = jdbcTemplate.queryForInt(sql, classe.getPeriod(), classe.getDays(), classe.getCapactity(),
				classe.getPrice(), classe.getType(), classe.getSport_id(), classe.getEmp_id(),classe.getAges_id(), classe.getLanguage());
		return id;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getCurrentCapacity(int class_id) {
		String sql = "SELECT COUNT(class_ID) FROM booking WHERE class_ID =?"; 
		int currentCapacity = jdbcTemplate.queryForInt(sql, class_id);
		return currentCapacity;
	}

}
