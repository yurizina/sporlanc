package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.AddItem;

public interface AddItemDAO {

	public void saveOrUpdate(AddItem addItem);

	public void delete(int addItem_id);

	public AddItem getAddItem(int addItem_id);

	public List<AddItem> list();

	public List<AddItem> listBookingID(int booking_id);
}

