package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Parent;

public interface ParentDAO {
	public void saveOrUpdate(Parent parent);

	public void delete(int user_id);

	public Parent getParent(int user_id);

	public List<Parent> list();

}