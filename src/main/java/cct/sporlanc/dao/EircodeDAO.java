package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Eircode;

public interface EircodeDAO {
	
	public void saveOrUpdate (Eircode eircode);
	
	public void delete (int eircode_id);
	
	public Eircode getEircode(int eircode_id);
	
	public List<Eircode> list();

	int index(Eircode eircode);

}
