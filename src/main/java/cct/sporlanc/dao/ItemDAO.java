package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Item;

public interface ItemDAO {

	public void saveOrUpdate(Item item);

	public void delete(int item_id);

	public Item getItem(int item_id);

	public List<Item> list();
}
