package cct.sporlanc.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cct.sporlanc.dao.*;
import cct.sporlanc.model.*;


@Controller
public class ProductsController {

	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private AddItemDAO additemDAO;
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	private ClassDAO classeDAO;
	@Autowired
	private EircodeDAO eircodeDAO;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ParentDAO parentDAO;
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value = "/listitems", method = RequestMethod.GET)
	public ModelAndView listItem(HttpServletRequest request, ModelAndView model){
		int userID = Integer.parseInt(request.getParameter("id"));
		model.addObject("id", userID); 
		
		List<Item> listItem = itemDAO.list();
		List<AddItem> listAddItem = additemDAO.list();
		List<Booking> listBookings = bookingDAO.list();
		List<Classe> listClass = classeDAO.list();
		List<Eircode> listEir = eircodeDAO.list();
		List<Employee> listEmp = employeeDAO.list();
		List<Parent> listParent = parentDAO.list();
		List<Student> listStu = studentDAO.list();
		
		model.addObject("listStudent", listStu);
		model.addObject("listParent", listParent);
		model.addObject("listEmp", listEmp);
		model.addObject("listEircode", listEir);
		model.addObject("listClasse", listClass);
		model.addObject("listBooking", listBookings);
		model.addObject("listAddItem", listAddItem);
		model.addObject("listItem", listItem);
		model.setViewName("home2");

		return model;
	}

	@RequestMapping(value = "/newItem", method = RequestMethod.GET)
	public ModelAndView newItem(ModelAndView model) {
		Item newItem = new Item();
		model.addObject("item", newItem);
		model.setViewName("itemForm");
		return model;
	}

	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute Item item) {
		itemDAO.saveOrUpdate(item);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		itemDAO.delete(itemId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editItem", method = RequestMethod.GET)
	public ModelAndView editItem(HttpServletRequest request) {
		int empID = Integer.parseInt(request.getParameter("empId"));
		int itemId = Integer.parseInt(request.getParameter("id"));
		Item item = itemDAO.getItem(itemId);
		ModelAndView model = new ModelAndView("/itemForm");
		model.addObject("item", item);
		model.addObject("id", empID);

		return model;
	}
	
	// ------------------------------------------------------------
	// Check model AddItem
	
	//Specific list of baskets, user in the initial testing phase
	/*
	 * @RequestMapping(value = "/listadditem", method = RequestMethod.GET) public
	 * ModelAndView listAddItem(ModelAndView model) throws IOException {
	 * List<AddItem> listItem = additemDAO.list(); model.addObject("listAddItem",
	 * listItem); model.setViewName("home2"); return model; }
	 */
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public ModelAndView basket(HttpServletRequest request, ModelAndView model) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int studentID = Integer.parseInt(request.getParameter("idStu"));
		
		List<Item> listItem = itemDAO.list();
		List<AddItem> basket = additemDAO.listBookingID(id);
		
		model.addObject("student_id", studentID);
		model.addObject("listAddItem", basket);
		model.addObject("listItem", listItem);
		model.setViewName("basket");//change this one! 
		return model;
	}

	@RequestMapping(value = "/newAddItem", method = RequestMethod.GET)
	public ModelAndView newAddItem(ModelAndView model) {
		AddItem newAddItem = new AddItem();
		model.addObject("additem", newAddItem);
		model.setViewName("additemform");
		return model;
	}
	//This one requires the Booking ID automatically 
	@RequestMapping(value = "/newAddItem2", method = RequestMethod.GET)
	public ModelAndView newAddItem2(HttpServletRequest request) {
		
		int bookingId = Integer.parseInt(request.getParameter("id"));
		int studentId = Integer.parseInt(request.getParameter("idStu"));
		
		//Items available 
		List<Item> listItem = itemDAO.list();
		for (int i = 0; i < listItem.size(); i++) {
			if (listItem.get(i).getAvailability().equalsIgnoreCase("False")) {
				listItem.remove(i);
			}
		}
		
		AddItem newAddItem = new AddItem();
		newAddItem.setStudent_id(studentId);
		newAddItem.setBookingID(bookingId);
		//System.out.println(newAddItem.getStudent_id());
		
		ModelAndView model = new ModelAndView();
		model.addObject("id", studentId);
		model.addObject("listItem", listItem);
		model.addObject("additem", newAddItem);
		model.setViewName("additemform");
		
		return model;
	}

	@RequestMapping(value = "/saveAddItem", method = RequestMethod.POST)
	public ModelAndView saveAddItem(@ModelAttribute AddItem addItem) {
		int id = addItem.getStudent_id();
		int item_id = addItem.getItem_id();
		List<Item> listItem = itemDAO.list();
		for (int i = 0; i < listItem.size(); i++) {
			int item = listItem.get(i).getItem_id();
			if(item == item_id) {
				additemDAO.saveOrUpdate(addItem);
				break;
			}
		}
		if (id > 0) {
			List<Booking> listBookings = bookingDAO.listEachStudent(id);
			List<Classe> listClass = classeDAO.list();

			ModelAndView model = new ModelAndView();
			model.addObject("listClasse", listClass);
			model.addObject("listBooking", listBookings);
			model.setViewName("bookings");
			return model;
		}
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editAddItem", method = RequestMethod.GET)
	public ModelAndView editAddItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("itemID"));
		int studentId = Integer.parseInt(request.getParameter("stuID"));
		int additemId = Integer.parseInt(request.getParameter("id"));
		
		//Items available 
		List<Item> listItem = itemDAO.list();
		AddItem additem = additemDAO.getAddItem(additemId);
		ModelAndView model = new ModelAndView("/additemform");
		
		model.addObject("listItem", listItem);
		model.addObject("id", studentId);
		model.addObject("additem", additem);
		return model;
	}

	@RequestMapping(value = "/deleteAddItem", method = RequestMethod.GET)
	public ModelAndView deleteAddItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		additemDAO.delete(itemId);
		
		int bookingid = Integer.parseInt(request.getParameter("bookingId"));
		int studentID = Integer.parseInt(request.getParameter("stuID"));
		
		List<Item> listItem = itemDAO.list();
		List<AddItem> basket = additemDAO.listBookingID(bookingid);
		
		ModelAndView model = new ModelAndView();
		model.addObject("student_id", studentID);
		model.addObject("listAddItem", basket);
		model.addObject("listItem", listItem);
		model.setViewName("basket");//change this one! 
		return model;
	}

}
