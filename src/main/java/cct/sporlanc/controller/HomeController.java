package cct.sporlanc.controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
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
public class HomeController {

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private BookingDAO bookingDAO;

	@Autowired
	private AddItemDAO additemDAO;

	@Autowired
	private EircodeDAO eircodeDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private ParentDAO parentDAO;

	@Autowired
	private StudentDAO studentDAO;

	/*
	 * Notice we use the @Autowired annotation to let Spring inject an instance of
	 * the ItemDAO implementation into this controller automatically. Each handler
	 * method uses this ItemDAO object to perform necessary CRUD operations. Let’s
	 * see implementation details of each method.
	 */

	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) throws IOException {
		model.setViewName("home");
		return model;
	}

	
	// SECURITY - After the user try to enter any private URL, which means that sent
	// by POST data
	// User is redirected to the main page!
	@RequestMapping(value = "/{[path:[^\\.]*}")
	public ModelAndView redirect() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;

	}

	// -----------------------------------------------------------------------
	// Booking part

	// Specific list of bookings, used in the initial testing phase
	/*
	 * @RequestMapping(value = "/listbooking", method = RequestMethod.GET) public
	 * ModelAndView listBooking(ModelAndView model) throws IOException {
	 * List<Booking> listItem = bookingDAO.list(); model.addObject("listBooking",
	 * listItem); model.setViewName("home2"); return model;
	 * 
	 * }
	 */

	@RequestMapping(value = "/newBooking", method = RequestMethod.GET)
	public ModelAndView newBooking(ModelAndView model) {
		Booking newBooking = new Booking();
		model.addObject("booking", newBooking);
		model.setViewName("bookingForm");
		return model;
	}
	
	@RequestMapping(value = "/newBookingAdmin", method = RequestMethod.GET)
	public ModelAndView newBookingAdmin(ModelAndView model) {
		Booking newBooking = new Booking();
		model.addObject("booking", newBooking);
		model.setViewName("bookingFormAdmin");
		return model;
	}
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public ModelAndView home2(ModelAndView model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee newEmp = employeeDAO.getEmployee(id);
		model.addObject("emp", newEmp);
		model.setViewName("home2");
		return model;
	}

	@RequestMapping(value = "/editBooking", method = RequestMethod.GET)
	public ModelAndView editBooking(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		Booking addbooking = bookingDAO.getBooking(itemId);
		ModelAndView model = new ModelAndView("/bookingFormAdmin");
		model.addObject("booking", addbooking);
		return model;
	}
	
	@RequestMapping(value = "/saveBookingAdmin", method = RequestMethod.POST)
	public ModelAndView saveBookingAdmin(@ModelAttribute Booking booking) {
		
		bookingDAO.saveOrUpdate(booking);
		
		ModelAndView model = new ModelAndView();
		Employee newEmp = employeeDAO.getEmployee(1);
		//The emp_id is hardcode!Can be implemented a list of employees and return the id of the employe with 
		//exactly admin username
		model.addObject("emp", newEmp);
		model.setViewName("homeAdmin");
		return model;
	}

	@RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
	public ModelAndView saveBooking(@ModelAttribute Booking booking) {

		// ----------First check DATES - return always to Monday

		// Convert the String to Local Date
		// https://www.baeldung.com/java-string-to-date
		LocalDate date2 = LocalDate.parse(booking.getFrom_date());
		// Get the Day of week
		// https://www.tutorialspoint.com/how-to-check-whether-the-given-date-represents-weekend-in-java
		DayOfWeek day = DayOfWeek.of(date2.get(ChronoField.DAY_OF_WEEK));
		int value = day.getValue();

		if (value == 1) {
			// Do nothing, this is Monday
		} else if (value == 2) {
			// Returns to Monday!!
			// Methods to returns day, specific within six days
			// 1 means return 1 day (equiv. -1)
			// https://www.geeksforgeeks.org/localdate-minusdays-method-in-java-with-examples/
			day = day.minus(1);
			date2 = date2.minusDays(1);
			// Convert back to String
			// https://howtodoinjava.com/java/date-time/localdate-format-example/
			String strDate = date2.toString();
			booking.setFrom_date(strDate);

		} else if (value == 3) {
			// Returns to Monday!!
			day = day.minus(2);
			// Convert to MONDAY
			date2 = date2.minusDays(2);
			// Convert yyyy-MM-dd to yyyy-MM-dd(-2days)
			// Convert Date to String
			String strDate = date2.toString();
			// Set to booking confirmation
			booking.setFrom_date(strDate);
		} else if (value == 4) {
			// Returns to Monday!!
			day = day.minus(3);
			date2 = date2.minusDays(3);
			String strDate = date2.toString();
			booking.setFrom_date(strDate);
		} else if (value == 5) {
			// Returns to Monday!!
			day = day.minus(4);
			date2 = date2.minusDays(4);
			String strDate = date2.toString();
			booking.setFrom_date(strDate);
		} else if (value == 6) {
			// Returns to Monday!!
			day = day.minus(5);
			date2 = date2.minusDays(5);
			String strDate = date2.toString();
			booking.setFrom_date(strDate);
		} else if (value == 7) {
			// Returns to Monday!!
			day = day.minus(6);
			date2 = date2.minusDays(6);
			String strDate = date2.toString();
			booking.setFrom_date(strDate);
		}

		// ------ END of DATE session

		int studentID = booking.getStudentID();
		// ----- Check if the Student has chosen the class already
		boolean flag = false;
		List<Booking> listBooking = bookingDAO.listEachStudent(studentID);

		for (int i = 0; i < listBooking.size(); i++) {
			if ((listBooking.get(i).getClass_ID() == booking.getClass_ID())) {
				// "This class is already booked for this student!";
				// There is no check for the dates!
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		// ----- END of duplicate booking with same class ID

		// Book the class
		if (flag == false) {
			bookingDAO.saveOrUpdate(booking);
		}

		// Once the method save this new booking, we are redirected to the page with
		// all bookings for that particular student!
		List<Booking> listBookings = bookingDAO.listEachStudent(studentID);
		List<Classe> listClass = classeDAO.list();
		// We list only the classes for that particular student
		List<Classe> matchedlist = new ArrayList<Classe>();
		for (int i = 0; i < listBookings.size(); i++) {
			for (int ii = 0; ii < listClass.size(); ii++) {
				if (listBookings.get(i).getClass_ID() == listClass.get(ii).getClass_ID()) {
					matchedlist.add(listClass.get(ii));
				}
			}
		}
		Student newStudent = studentDAO.getStudent(studentID);

		ModelAndView model = new ModelAndView();
		model.addObject("listClasse", matchedlist);
		model.addObject("student", newStudent);
		model.addObject("listBooking", listBookings);
		model.setViewName("bookings");
		return model;
	}

	@RequestMapping(value = "/deleteBooking", method = RequestMethod.GET)
	public ModelAndView deleteBooking(HttpServletRequest request) {
		int bookingId = Integer.parseInt(request.getParameter("id"));
		int userID = Integer.parseInt(request.getParameter("userid"));
		// Check if the Student has bookings
		List<AddItem> count = additemDAO.listBookingID(bookingId);
		boolean flag = false;
		if (count.size() > 0) {
			flag = true;
		}
		if (flag == false) {
			bookingDAO.delete(bookingId);
		}

		List<Student> listStu = studentDAO.listEachParent(userID);
		ModelAndView model = new ModelAndView();
		model.addObject("listStudent", listStu);
		model.setViewName("homeParent");
		return model;
	}
	
	@RequestMapping(value = "/deleteBookingAdmin", method = RequestMethod.GET)
	public ModelAndView deleteBookingAdmin(HttpServletRequest request) {
		int bookingId = Integer.parseInt(request.getParameter("id"));
		// Check if the Student has bookings
		List<AddItem> count = additemDAO.listBookingID(bookingId);
		boolean flag = false;
		if (count.size() > 0) {
			flag = true;
		}
		if (flag == false) {
			bookingDAO.delete(bookingId);
		}
		
		ModelAndView model = new ModelAndView();
		Employee newEmp = employeeDAO.getEmployee(1);
		//The emp_id is hardcode!Can be implemented a list of employees and return the id of the employe with 
		//exactly admin username
		model.addObject("emp", newEmp);
		model.setViewName("homeAdmin");
		return model;

		
	}

	// -----------------------------------------------------------------------
	// Class
	@Autowired
	private ClassDAO classeDAO;

	@RequestMapping(value = "/listclass", method = RequestMethod.GET)
	public ModelAndView listClass(ModelAndView model) throws IOException {
		List<Classe> listClass = classeDAO.list();
		model.addObject("listClasse", listClass);
		model.setViewName("home2");
		return model;

	}

	// Original method with GET requests! It does work as well, but the data
	// sensitive is shown in URL

	@RequestMapping(value = "/listclassperstaff", method = RequestMethod.GET)
	public ModelAndView listClassPerStaff(HttpServletRequest request, ModelAndView model) throws IOException {
		int emp_id = Integer.parseInt(request.getParameter("id"));
		List<Classe> listClass = classeDAO.listClassesStaff(emp_id);
		
		for (int i = 0; i < listClass.size(); i++) {
			// method to check number of students enrolled to this class
			int class_id = listClass.get(i).getClass_ID();
			int capacity = listClass.get(i).getCapactity();
			int currentCapacity = classeDAO.getCurrentCapacity(class_id);
			int availability = capacity - currentCapacity;
			listClass.get(i).setAvailability(availability);
		}
		model.addObject("listClasse", listClass);
		model.addObject("emp_id", emp_id);
		model.setViewName("classesperStaff");

		return model;
	}

	// POST method blocks user to input the URL
	/*
	 * @RequestMapping(value = "/listclassperstaff", method = RequestMethod.POST)
	 * public ModelAndView listClassPerStaff(HttpServletRequest request,
	 * ModelAndView model) throws IOException { int emp_id =
	 * Integer.parseInt(request.getParameter("id")); List<Classe> listClass =
	 * classeDAO.listClassesStaff(emp_id); model.addObject("listClasse", listClass);
	 * model.addObject("emp_id", emp_id); model.setViewName("classesperStaff");
	 * 
	 * return model; }
	 */

	@RequestMapping(value = "/classdetails", method = RequestMethod.GET)
	public ModelAndView classDetails(HttpServletRequest request, ModelAndView model) throws IOException {
		int studentid = Integer.parseInt(request.getParameter("idStu"));
		int classId = Integer.parseInt(request.getParameter("id"));

		Classe classe = classeDAO.getClass(classId);
		classe.setStudent_id(studentid);
		model.addObject("classe", classe);
		model.setViewName("classdetails");
		return model;
	}

	@RequestMapping(value = "/newClass", method = RequestMethod.GET)
	public ModelAndView newClass(ModelAndView modela) {
		Classe newClass = new Classe();
		modela.addObject("classe", newClass);
		modela.setViewName("classForm");
		return modela;
	}

	@RequestMapping(value = "/newClassforEmp", method = RequestMethod.GET)
	public ModelAndView newClassStaff(HttpServletRequest request, ModelAndView modela) {
		int emp_id = Integer.parseInt(request.getParameter("id"));

		Classe newClass = new Classe();
		newClass.setEmp_id(emp_id);
		modela.addObject("classe", newClass);
		modela.setViewName("classForm");
		return modela;
	}

	@RequestMapping(value = "/saveClass", method = RequestMethod.POST)
	public ModelAndView saveClass(@ModelAttribute Classe classe) {
		classeDAO.saveOrUpdate(classe);
		Employee emp = employeeDAO.getEmployee(classe.getEmp_id());
		
		if(emp.getEmp_id() == 1) {
			ModelAndView model = new ModelAndView();
			//The emp_id is hardcode!Can be implemented a list of employees and return the id of the employe with 
			//exactly admin username
			model.addObject("emp", emp);
			model.setViewName("homeAdmin");
			return model;
		}
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeEmployee");
		return model;

	}

	@RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
	public ModelAndView deleteClass(HttpServletRequest request) {
		int classId = Integer.parseInt(request.getParameter("id"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		List<Booking> list = bookingDAO.list();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			
			if (classId == list.get(i).getClass_ID()) {
				count++;
			}
		}
		if (count == 0) {
			classeDAO.delete(classId);
		}
		
		
		
		Employee emp = employeeDAO.getEmployee(empId);
		ModelAndView model = new ModelAndView();
		
		if(empId == 1) {
			//The emp_id is hardcode!Can be implemented a list of employees and return the id of the employe with 
			//exactly admin username
			model.addObject("emp", emp);
			model.setViewName("homeAdmin");
			return model;
		}
		
		model.addObject("emp", emp);
		model.setViewName("homeEmployee");
		return model;
	}

	
	@RequestMapping(value = "/editClass", method = RequestMethod.GET)
	public ModelAndView editClass(HttpServletRequest request, ModelAndView modelb) {
		int classId = Integer.parseInt(request.getParameter("id"));
		Classe classe = classeDAO.getClass(classId);
		// ModelAndView model = new ModelAndView("/classForm");
		modelb.addObject("classe", classe);
		modelb.setViewName("classForm");
		return modelb;
	}

	// --------- Sign UP - Part 1 - for parents!!!----
	@RequestMapping(value = "/registerParent", method = RequestMethod.GET)
	public ModelAndView registrationParent(ModelAndView model) {
		Eircode newItem = new Eircode();
		model.addObject("eircode", newItem);
		model.setViewName("signupeircode");
		return model;
	}

	// ---------- Sign UP - Part 2 - for parents
	@RequestMapping(value = "/saveregistereir", method = RequestMethod.POST)
	public ModelAndView saveEircodeParent(@ModelAttribute Eircode eircode) {
		System.out.println();
		boolean flag = false;
		int index = 0;
		List<Eircode> listEir = eircodeDAO.list();
		for (int i = 0; i < listEir.size(); i++) {
			// This loop will check if the eircode has been added to the system or not
			// if yes, it will return a counter different than zero
			if (listEir.get(i).getEircode().equals(eircode.getEircode())) {
				index = i;
				flag = true;
			}

		}
		// Add the Eircode first of all
		Parent parent = new Parent();
		parent.getEircodeID();
		if (flag == true) {
			parent.setEircodeID(listEir.get(index).getEircode_ID());
		}
		if (flag == false) {
			// If there is no eircode register yet, the system will add to the database
			eircodeDAO.saveOrUpdate(eircode);
			parent.setEircodeID(eircodeDAO.index(eircode));

		}

		ModelAndView model = new ModelAndView("/parentForm");
		model.addObject("parent", parent);

		return model;
	}

	//
	@RequestMapping(value = "/saveParent", method = RequestMethod.POST)
	public ModelAndView saveParent(@ModelAttribute Parent parent) {
		List<Parent> listParent = parentDAO.list();
		boolean flag = false;
		
		for (int i = 0; i < listParent.size(); i++) {
			if (listParent.get(i).getEmail().equalsIgnoreCase(parent.getEmail())) {
				// This email is already being used, try another one
				System.out.println("Email used!");
				parent.setEmail(null);
				flag = true;
			}
			if (listParent.get(i).getUsername().equalsIgnoreCase(parent.getUsername())) {
				// Same username from another person
				System.out.println("Username used");
				parent.setUsername(null);
				flag = true;
			}

		}
		if (flag == false) {
			parentDAO.saveOrUpdate(parent);
			return new ModelAndView("redirect:/");
		}

		if (flag = true) {

			System.out.println("Try again, change email or username!");
			ModelAndView modelAgain = new ModelAndView("/parentForm");
			modelAgain.addObject("parent", parent);
			return modelAgain;
		}
		return null;

	}

	// ------------------Log-in page to Parent/User and authentication/
	@RequestMapping(value = "/loginParent", method = RequestMethod.GET)
	public ModelAndView loginParent(ModelAndView model) {
		Parent loginParent = new Parent();
		model.addObject("parent", loginParent);
		model.setViewName("loginParent");
		return model;
	}

	@RequestMapping(value = "/authenticationParent", method = RequestMethod.POST)
	public ModelAndView authenticationParent(@ModelAttribute Parent parent) {
		boolean flag = false;
		List<Parent> listParent = parentDAO.list();

		for (int i = 0; i < listParent.size(); i++) {

			if (listParent.get(i).getUsername().equals(parent.getUsername())
					&& listParent.get(i).getPassword().equals(parent.getPassword())) {
				System.out.println("Username and password correct!! Well done");
				parent.setUser_ID(listParent.get(i).getUser_ID());
				flag = true;
				break;

			} else if (listParent.get(i).getUsername().equals(parent.getUsername())) {
				// System.out.println(listEir.get(i).getEircode_ID());
				System.out.println("Password wrong!");
				parent.setPassword("Type Password Again");
				flag = false;
				break;

			} else if (listParent.get(i).getPassword().equals(parent.getPassword())) {
				// System.out.println(listEir.get(i).getEircode_ID());
				System.out.println("Username wrong!");
				parent.setUsername("Wrong Username! Try again!");
				parent.setPassword("");
				flag = false;
				break;
			}

		}

		// Logged page
		if (flag == true) {

			ModelAndView model = new ModelAndView();
			model.addObject("parent", parent);
			model.setViewName("loggedParent");
			return model;
		}
		if (flag == false) {

			System.out.println("Try again, change email or username!");
			ModelAndView loginAgain = new ModelAndView("/loginParent");
			loginAgain.addObject("parent", parent);
			return loginAgain;
		}

		return null;

	}

	// ------------------Log-in page to Staff and Admin and authentication

	@RequestMapping(value = "/loginStaff", method = RequestMethod.GET)
	public ModelAndView loginStaff(ModelAndView model) {
		Employee loginEmployee = new Employee();
		model.addObject("employee", loginEmployee);
		model.setViewName("loginStaff");
		return model;
	}

	@RequestMapping(value = "/authenticationStaff", method = RequestMethod.POST)
	public ModelAndView authenticationStaff(@ModelAttribute Employee employee) {
		boolean flag = false;
		int index = 0;
		List<Employee> listStaff = employeeDAO.list();
		for (int i = 0; i < listStaff.size(); i++) {

			if (listStaff.get(i).getUsername().equals(employee.getUsername())
					&& listStaff.get(i).getPassword().equals(employee.getPassword())) {

				if (employee.getUsername().equals("admin")) {
					// Can create staff!
					ModelAndView model = new ModelAndView();
					Employee newEmp = employeeDAO.getEmployee(listStaff.get(i).getEmp_id());
					model.addObject("emp", newEmp);
					model.setViewName("homeAdmin");
					return model;
				} else {
					//System.out.println("Username and password correct!! Well done");
					index = listStaff.get(i).getEmp_id();
					// employee.setEmp_id(listStaff.get(index).getEmp_id());
					flag = true;
				}
				break;

			} else if (listStaff.get(i).getUsername().equals(employee.getUsername())) {
				//System.out.println("Username wrong!");
				employee.setUsername("Type Username Again");
				flag = false;
				break;

			} else if (listStaff.get(i).getPassword().equals(employee.getPassword())) {
				//System.out.println("Password wrong!");
				employee.setPassword("Type Password Again");
				flag = false;
				break;

			} else {
				// flag = false;
				// employee.setUsername("Username wrong - Type Again");
				// employee.setPassword("Password wrong - Type Again");
			}
		}
		if (flag == true) {
			// This method returns the page where employee can edit and delete every
			// employee info
			//System.out.println("Enter system :)");
			Employee loggedEmployee = employeeDAO.getEmployee(index);
			ModelAndView model = new ModelAndView();
			model.addObject("emp", loggedEmployee);
			model.setViewName("homeEmployee");
			return model;
		}
		if (flag == false) {

			System.out.println("Try again, change email or username!");
			ModelAndView loginAgain = new ModelAndView("/loginStaff");
			loginAgain.addObject("employee", employee);
			return loginAgain;
		}
		return null;
	}

	// Once the parents have register themselves, they can register their children
	// and have as many children or tutored kids as they want!
	// New Student with USER ID
	@RequestMapping(value = "/studentForm", method = RequestMethod.GET)
	public ModelAndView loggedParent(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Student newStudent = new Student();
		newStudent.setUserID(id);
		ModelAndView model = new ModelAndView();
		model.addObject("student", newStudent);
		model.setViewName("studentForm");
		return model;
	}

	// Return button in Students session
	@RequestMapping(value = "/loggedParent", method = RequestMethod.GET)
	public ModelAndView loggedParent2(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Parent newParent = new Parent();
		newParent.setUser_ID(id);
		ModelAndView model = new ModelAndView();
		model.addObject("parent", newParent);
		model.setViewName("loggedParent");
		return model;
	}

	// List of kids each parent has
	@RequestMapping(value = "/liststudentperparent", method = RequestMethod.GET)
	public ModelAndView listStudentEachParent(HttpServletRequest request) {
		int userID = Integer.parseInt(request.getParameter("id"));
		List<Student> listStu = studentDAO.listEachParent(userID);
		// Calculate the age of each Student
		// https://stackoverflow.com/questions/1116123/how-do-i-calculate-someones-age-in-java
		LocalDate now = LocalDate.now();
		for (int i = 0; i < listStu.size(); i++) {
			LocalDate birthDate = LocalDate.parse(listStu.get(i).getBirth_date());
			int currentAge = Period.between(birthDate, now).getYears();
			listStu.get(i).setCurrentAge(currentAge);
		}

		ModelAndView model = new ModelAndView();
		model.addObject("userID", userID);
		model.addObject("listStudent", listStu);
		model.setViewName("homeParent");
		return model;
	}

	// Bookings per student
	@RequestMapping(value = "/bookingsStudent", method = RequestMethod.GET)
	public ModelAndView listBookingsEachStudent(HttpServletRequest request) {
		int studentID = Integer.parseInt(request.getParameter("id"));
		List<Booking> listBookings = bookingDAO.listEachStudent(studentID);
		List<Classe> listClass = classeDAO.list();
		// We list only the classes for that particular student
		List<Classe> matchedlist = new ArrayList<Classe>();
		for (int i = 0; i < listBookings.size(); i++) {
			for (int ii = 0; ii < listClass.size(); ii++) {
				if (listBookings.get(i).getClass_ID() == listClass.get(ii).getClass_ID()) {
					matchedlist.add(listClass.get(ii));
				}
			}
		}

		Student newStudent = studentDAO.getStudent(studentID);
		ModelAndView model = new ModelAndView();
		model.addObject("student", newStudent);
		model.addObject("listClasse", matchedlist);
		model.addObject("listBooking", listBookings);
		model.setViewName("bookings");
		return model;
	}
	// --------- New Booking for each student
	// Now we are going to book a class;
	// We have to check few informations:

	// Private or Group sessions?
	@RequestMapping(value = "/newBooking2", method = RequestMethod.GET)
	public ModelAndView newBookingEachStudent(HttpServletRequest request) {
		int age = Integer.parseInt(request.getParameter("age"));
		int studentID = Integer.parseInt(request.getParameter("id"));
		// System.out.println("This is the student ID for newBooking " + studentID);
		ModelAndView model = new ModelAndView();
		Classe checkClass = new Classe();
		checkClass.setStudent_id(studentID);
		checkClass.setAge(age);
		model.addObject("checkType", checkClass);
		model.setViewName("preClassForm");
		return model;
	}

	// Second Step - Check type of class Private or Group and proceed with step 2
	// Adding a new class if private or show list of group classes
	@RequestMapping(value = "/checkClass", method = RequestMethod.POST)
	public ModelAndView checkClass(@ModelAttribute Classe classe) {

		if (classe.getType().equals("G")) {

			ModelAndView model = new ModelAndView();
			List<Classe> listClasses = classeDAO.groupClasses(classe);

			for (int i = 0; i < listClasses.size(); i++) {

				// method to check number of students enrolled to this class
				int class_id = listClasses.get(i).getClass_ID();
				int currentCapacity = classeDAO.getCurrentCapacity(class_id);
				int capacity = listClasses.get(i).getCapactity();

				if (currentCapacity >= capacity) {
					// System.out.println("Students booked this class: " + currentCapacity);
					// This method will remove the class from its list if it has reached the
					// capacity
					listClasses.remove(i);
				} else {
					int availability = capacity - currentCapacity;
					listClasses.get(i).setAvailability(availability);
					// System.out.println("Spots available: " + availability);
				}
			}
			// method to check only the right category for this student
			int age = classe.getAge();

			for (int z = 0; z < listClasses.size(); z++) {

				int category = listClasses.get(z).getAges_id();
				if (category == 17) {
					if (age < 14) {
						System.out.println("Index " + z + " category: " + category);
						listClasses.remove(z);
					}
				}
			}

			for (int x = 0; x < listClasses.size(); x++) {

				int category = listClasses.get(x).getAges_id();
				if (category == 14) {
					if (age < 10 || age >= 14) {
						System.out.println("Index " + x + " category: " + category);
						listClasses.remove(x);
					}
				}
			}

			for (int y = 0; y < listClasses.size(); y++) {

				int category = listClasses.get(y).getAges_id();
				if (category == 10) {
					if (age >= 10) {
						System.out.println("Index " + y + " category: " + category);
						listClasses.remove(y);
					}
				}
			}
			model.addObject("listClasses", listClasses);
			model.setViewName("bookingPri");
			return model;

		} else {

			ModelAndView model = new ModelAndView();
			Classe newClass = new Classe();
			newClass.setStudent_id(classe.getStudent_id());
			newClass.setCapactity(1);
			newClass.setPrice(30);
			newClass.setEmp_id(1);
			newClass.setType("P");
			// Category based upon student's age
			System.out.println(classe.getAge());
			if (classe.getAge() < 10) {
				newClass.setAges_id(10);
			} else if (classe.getAge() >= 10 && classe.getAge() < 14) {
				newClass.setAges_id(14);
			} else if (classe.getAge() >= 14 && classe.getAge() < 18) {
				newClass.setAges_id(17);
			}
			newClass.setAge(classe.getAge());
			model.addObject("classe", newClass);
			model.setViewName("privateClassForm");
			return model;
		}
	}

	// With the class ID - create a booking
	@RequestMapping(value = "/bookClass", method = RequestMethod.GET)
	public ModelAndView confirmBooking(HttpServletRequest request) {
		int classeId = Integer.parseInt(request.getParameter("id"));
		int studentID = Integer.parseInt(request.getParameter("student_id"));

		Booking addbooking = new Booking();
		addbooking.setClass_ID(classeId);
		addbooking.setStudentID(studentID);
		ModelAndView model = new ModelAndView("/userBookingForm");
		model.addObject("booking", addbooking);
		return model;

	}

	// Confirm the booking
	@RequestMapping(value = "/confirmClass", method = RequestMethod.POST)
	public ModelAndView confirmClass(@ModelAttribute Classe classe) {

		int class_id = 0;
		boolean classBooked = false;
		if (classe.getType().equals("P")) {
			List<Classe> listClasses = classeDAO.groupClasses(classe);
			for (int i = 0; i < listClasses.size(); i++) {
				// If this class has been booked, we return the ID of this class
				String period = listClasses.get(i).getPeriod();
				// System.out.println(period);
				String days = listClasses.get(i).getDays();
				int sport = listClasses.get(i).getSport_id();
				int category = listClasses.get(i).getAges_id();

				if (period.equals(classe.getPeriod()) && days.equals(classe.getDays()) && sport == classe.getSport_id()
						&& category == classe.getAges_id()) {
					class_id = classeDAO.getID(classe);
					classBooked = true;
					break;
				}
			}
			// System.out.println(classe.getDays());
		}

		if (classBooked == false) {
			// If did not book, we save the new class and return its ID.
			classeDAO.saveOrUpdate(classe);
			class_id = classeDAO.getID(classe);
		}

		int student_id = classe.getStudent_id();
		// System.out.println(class_id);
		// System.out.println(classe.getStudent_id());

		Booking addbooking = new Booking();
		addbooking.setClass_ID(class_id);
		addbooking.setStudentID(student_id);
		ModelAndView model = new ModelAndView("/userBookingForm");
		model.addObject("booking", addbooking);
		return model;
	}

	// The invoice for each booking
	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public ModelAndView invoice(HttpServletRequest request) {
		int bookingID = Integer.parseInt(request.getParameter("id"));
		int class_ID = Integer.parseInt(request.getParameter("classID"));

		Classe classe = classeDAO.getClass(class_ID);
		int price = classe.getPrice();
		// Check how many days per week
		String days = classe.getDays();

		int x = 0;

		if (days.contains("TH")) {
			if (days.length() == 2) {
				x = 1;
			} else if (days.length() == 4) {
				x = 2;
			} else if (days.length() == 6) {
				x = 3;
			} else if (days.length() == 8) {
				x = 4;
			} else if (days.length() == 10) {
				x = 5;
			} else if (days.length() == 12) {
				x = 6;
			}

		} else {
			if (days.length() == 1) {
				x = 1;
			} else if (days.length() == 3) {
				x = 2;
			} else if (days.length() == 5) {
				x = 3;
			} else if (days.length() == 7) {
				x = 4;
			} else if (days.length() == 9) {
				x = 5;
			}
		}
		// We have the two variables, now just need to multiply, final value for that
		// week is:
		x = price * x;

		// Now we have to check the subscription
		Booking booking = bookingDAO.getBooking(bookingID);
		String checkSubscription = booking.getSubscription();
		int x2 = 0;
		if (checkSubscription.equalsIgnoreCase("week")) {
			// week or one time the class value
			x2 = 1;
		}

		if (checkSubscription.equalsIgnoreCase("month")) {
			// month or four times the class value
			x2 = 4;
		}

		if (checkSubscription.equalsIgnoreCase("semester")) {
			// month or four times the class value
			x2 = 24;
		}
		// I have to show the items for this booking

		List<AddItem> basket = additemDAO.listBookingID(bookingID);
		List<Item> listItem = itemDAO.list();

		int finalPrice = 0;
		int priceItem = 0;
		for (int i = 0; i < basket.size(); i++) {

			for (int ii = 0; ii < listItem.size(); ii++) {

				if (basket.get(i).getItem_id() == listItem.get(ii).getItem_id()) {
					// Now that I have found
					priceItem = basket.get(i).getQuantity();
					priceItem = priceItem * listItem.get(ii).getPrice();
					finalPrice = finalPrice + priceItem;
				}

			}

		}

		int finalTotal = finalPrice + (x * x2);
		ModelAndView model = new ModelAndView();
		model.addObject("valueClass", x);
		model.addObject("valueSubscription", x2);
		model.addObject("listClasse", classe);
		model.addObject("listBooking", booking);
		model.addObject("listAddItem", basket);
		model.addObject("finalPrice", finalPrice);
		model.addObject("total", finalTotal);
		model.setViewName("invoice");
		return model;
	}

}
