package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Classe;

public interface ClassDAO {

	public void saveOrUpdate (Classe classe);
	
	public void delete (int class_ID);
	
	public Classe getClass(int class_ID);
	
	public List<Classe> list();

	public List<Classe> groupClasses(Classe classe);

	public int getID(Classe classe);

	public List<Classe> listClassesStaff(int emp_id);

	public int getCurrentCapacity(int class_id);
	
}
