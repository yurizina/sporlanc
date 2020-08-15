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
public class PeopleController {

	@Autowired
	private EircodeDAO eircodeDAO;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ParentDAO parentDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private BookingDAO bookingDAO;

	// -----------------------------------------------------------------------
	// Employees

	// Private Page for Admin
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public ModelAndView homeAdmin(HttpServletRequest request) throws IOException {
		int empid = Integer.parseInt(request.getParameter("id"));
		Employee emp = employeeDAO.getEmployee(empid);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;
	}

	// Private page for Employees
	@RequestMapping(value = "/homeEmp", method = RequestMethod.GET)
	public ModelAndView homeEmp(HttpServletRequest request) throws IOException {
		int empid = Integer.parseInt(request.getParameter("id"));
		Employee emp = employeeDAO.getEmployee(empid);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeEmployee");
		return model;
	}

	// Specific List of employees, user in the initial testing phase
	/*
	 * @RequestMapping(value = "/listemployee", method = RequestMethod.GET) public
	 * ModelAndView listEmployee(ModelAndView model) throws IOException {
	 * List<Employee> listEmp = employeeDAO.list(); model.addObject("listEmp",
	 * listEmp); model.setViewName("home2"); return model; }
	 */

	@RequestMapping(value = "/newEmp", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmp = new Employee();
		model.addObject("employee", newEmp);
		model.setViewName("empForm");
		return model;
	}

	// Admin - can create Employees!
	@RequestMapping(value = "/newEmpAdmin", method = RequestMethod.GET)
	public ModelAndView newEmployeeAdmin(ModelAndView model) {
		Employee newEmp = new Employee();
		model.addObject("employee", newEmp);
		model.setViewName("empFormAdmin");
		return model;
	}

	@RequestMapping(value = "/saveEmpAdmin", method = RequestMethod.POST)
	public ModelAndView saveEmployeeAdmin(@ModelAttribute Employee employee) {
		employeeDAO.saveOrUpdate(employee);
		Employee emp = employeeDAO.getEmployee(1);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;
	}

	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeDAO.saveOrUpdate(employee);
		Employee emp = employeeDAO.getEmployee(employee.getEmp_id());

		// it is adding, but there is error message HTTP 500, why?

		if (emp.getStaff_role().equalsIgnoreCase("admin")) {
			// This conditional was created for all further creation of admin
			ModelAndView model = new ModelAndView();
			model.addObject("emp", emp);
			model.setViewName("homeAdmin");
			return model;

		} else {

			// general staff
			ModelAndView model = new ModelAndView();
			model.addObject("emp", emp);
			model.setViewName("homeEmployee");
			return model;
		}
	}

	@RequestMapping(value = "/editEmpAdmin", method = RequestMethod.GET)
	public ModelAndView editEmployeeAdmin(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.getEmployee(empid);
		ModelAndView model = new ModelAndView("/empFormAdmin");
		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.getEmployee(empid);
		ModelAndView model = new ModelAndView("/empForm");
		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("id"));
		employeeDAO.delete(empid);

		Employee emp = employeeDAO.getEmployee(1);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;

	}

	// -----------------------------------------------------------------------
	// Check model Student

	// Specific List of students, used in the initial testing phase
	/*
	 * @RequestMapping(value = "/liststudent", method = RequestMethod.GET) public
	 * ModelAndView listStudent(ModelAndView model) throws IOException {
	 * List<Student> listStu = studentDAO.list(); model.addObject("listStudent",
	 * listStu); model.setViewName("home2"); return model; }
	 */

	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Student newStu = new Student();
		model.addObject("student", newStu);
		model.setViewName("studentForm");
		return model;
	}

	@RequestMapping(value = "/newStudentAdmin", method = RequestMethod.GET)
	public ModelAndView newStudentAdmin(ModelAndView model) {
		Student newStu = new Student();
		model.addObject("student", newStu);
		model.setViewName("studentFormAdmin");
		return model;
	}

	// Once the student has been saved, we need to enter the main page of the user
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		// Save the information about the children
		// First, have to check if this Student exist or not
		boolean duplicate = false;
		List<Student> allStudents = studentDAO.list();
		for (int i = 0; i < allStudents.size(); i++) {
			if (allStudents.get(i).getFirst_name().toLowerCase().equalsIgnoreCase(student.getFirst_name())
					&& allStudents.get(i).getSurname().toLowerCase().equalsIgnoreCase(student.getSurname())
					&& (allStudents.get(i).getUserID() == student.getUserID())) {
				duplicate = true;
			}
		}

		if (duplicate == false) {
			studentDAO.saveOrUpdate(student);
		}

		// Create a new object with the id from the user!
		List<Student> listStu = studentDAO.listEachParent(student.getUserID());

		LocalDate now = LocalDate.now();
		for (int i = 0; i < listStu.size(); i++) {
			LocalDate birthDate = LocalDate.parse(listStu.get(i).getBirth_date());
			int currentAge = Period.between(birthDate, now).getYears();
			listStu.get(i).setCurrentAge(currentAge);
		}

		ModelAndView model = new ModelAndView();
		model.addObject("userID", student.getUserID());
		model.addObject("listStudent", listStu);
		model.setViewName("homeParent");
		return model;
	}

	@RequestMapping(value = "/saveStudentAdmin", method = RequestMethod.POST)
	public ModelAndView saveStudentAdmin(@ModelAttribute Student student) {
		studentDAO.saveOrUpdate(student);

		Employee emp = employeeDAO.getEmployee(1);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;
	}

	// This method is different form StudentForm (new Student)!
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		int studentid = Integer.parseInt(request.getParameter("id"));
		Student student = studentDAO.getStudent(studentid);
		ModelAndView model = new ModelAndView("/studentForm");
		model.addObject("student", student);
		return model;
	}

	@RequestMapping(value = "/editStudentAdmin", method = RequestMethod.GET)
	public ModelAndView editStudentAdmin(HttpServletRequest request) {
		int studentid = Integer.parseInt(request.getParameter("id"));
		Student student = studentDAO.getStudent(studentid);
		ModelAndView model = new ModelAndView("/studentFormAdmin");
		model.addObject("student", student);
		return model;
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int studentid = Integer.parseInt(request.getParameter("id"));
		int userid = Integer.parseInt(request.getParameter("parentid"));
		boolean count = false;

		List<Booking> listB = bookingDAO.list();
		for (int ii = 0; ii < listB.size(); ii++) {
			if (listB.get(ii).getStudentID() == studentid) {
				count = true;
				break;
			}
		}

		if (count == false) {
			studentDAO.delete(studentid);
		}

		// Once the student is delete, it redirects to same page!
		List<Student> listStu = studentDAO.listEachParent(userid);

		LocalDate now = LocalDate.now();
		for (int i = 0; i < listStu.size(); i++) {
			LocalDate birthDate = LocalDate.parse(listStu.get(i).getBirth_date());
			int currentAge = Period.between(birthDate, now).getYears();
			listStu.get(i).setCurrentAge(currentAge);
		}
		ModelAndView model = new ModelAndView();
		model.addObject("userID", userid);
		model.addObject("listStudent", listStu);
		model.setViewName("homeParent");
		return model;
	}

	// -----------------------------------------------------------------------
	// Check model Parent

	// Specific List of parents, used in the initial testing phase
	/*
	 * @RequestMapping(value = "/listparent", method = RequestMethod.GET) public
	 * ModelAndView listParent(ModelAndView model) throws IOException { List<Parent>
	 * listParent = parentDAO.list(); model.addObject("listParent", listParent);
	 * model.setViewName("home2"); return model; }
	 */

	@RequestMapping(value = "/newParent", method = RequestMethod.GET)
	public ModelAndView newParent(ModelAndView model) {
		Parent newParent = new Parent();
		model.addObject("parent", newParent);
		model.setViewName("parentForm");
		return model;
	}

	@RequestMapping(value = "/newParentAdmin", method = RequestMethod.GET)
	public ModelAndView newParentAdmin(ModelAndView model) {
		Parent newParent = new Parent();
		model.addObject("parent", newParent);
		model.setViewName("parentFormAdmin");
		return model;
	}

	// Originally it was /saveParent
	// When the parent needs to edit his information, this is the method that saves
	// after information has been edited!
	@RequestMapping(value = "/saveParent2", method = RequestMethod.POST)
	public ModelAndView saveParent2(@ModelAttribute Parent parent) {
		parentDAO.saveOrUpdate(parent);
		ModelAndView model = new ModelAndView();
		model.setViewName("loginParent");
		return model;
	}

	@RequestMapping(value = "/saveParentAdmin", method = RequestMethod.POST)
	public ModelAndView saveParentAdmin(@ModelAttribute Parent parent) {
		parentDAO.saveOrUpdate(parent);

		Employee emp = employeeDAO.getEmployee(1);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;
	}

	// Only Parent can do it
	@RequestMapping(value = "/deleteParent", method = RequestMethod.GET)
	public ModelAndView deleteParent(HttpServletRequest request) {
		int parentId = Integer.parseInt(request.getParameter("id"));
		parentDAO.delete(parentId);

		Employee emp = employeeDAO.getEmployee(1);
		ModelAndView model = new ModelAndView();
		model.addObject("emp", emp);
		model.setViewName("homeAdmin");
		return model;

	}

	@RequestMapping(value = "/editParent", method = RequestMethod.GET)
	public ModelAndView editParent(HttpServletRequest request) {
		int parentId = Integer.parseInt(request.getParameter("id"));
		Parent parent = parentDAO.getParent(parentId);
		ModelAndView model = new ModelAndView("/editParent");
		model.addObject("parent", parent);
		return model;
	}

	@RequestMapping(value = "/editParentAdmin", method = RequestMethod.GET)
	public ModelAndView editParentAdmin(HttpServletRequest request) {
		int parentId = Integer.parseInt(request.getParameter("id"));
		Parent parent = parentDAO.getParent(parentId);
		ModelAndView model = new ModelAndView("/parentFormAdmin");
		model.addObject("parent", parent);
		return model;
	}

	// Controller for Eircode - only used for staff and parent/user

	// Specific List of Eircode, user in the initial testing phase
	/*
	 * @RequestMapping(value = "/listeir", method = RequestMethod.GET) public
	 * ModelAndView listEircode(ModelAndView model) throws IOException {
	 * List<Eircode> listEir = eircodeDAO.list(); model.addObject("listEircode",
	 * listEir); model.setViewName("home2"); return model; }
	 */

	@RequestMapping(value = "/newEir", method = RequestMethod.GET)
	public ModelAndView newEircode(ModelAndView model) {
		Eircode newItem = new Eircode();
		model.addObject("eircode", newItem);
		model.setViewName("eircodeForm");
		return model;
	}

	@RequestMapping(value = "/saveEir", method = RequestMethod.POST)
	public ModelAndView saveEircode(@ModelAttribute Eircode eircode) {
		eircodeDAO.saveOrUpdate(eircode);
		// If I want to return to list, I have to pass parameter!
		ModelAndView model = new ModelAndView();
		Employee newEmp = employeeDAO.getEmployee(1);
		model.addObject("emp", newEmp);
		model.setViewName("homeAdmin");
		return model;

	}

	@RequestMapping(value = "/deleteEir", method = RequestMethod.GET)
	public ModelAndView deleteEircode(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		eircodeDAO.delete(itemId);

		ModelAndView model = new ModelAndView();
		Employee newEmp = employeeDAO.getEmployee(1);
		model.addObject("emp", newEmp);
		model.setViewName("homeAdmin");
		return model;

	}

	@RequestMapping(value = "/editEir", method = RequestMethod.GET)
	public ModelAndView editEircode(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		Eircode eircode = eircodeDAO.getEircode(itemId);
		ModelAndView model = new ModelAndView("/eircodeForm");
		model.addObject("eircode", eircode);
		return model;
	}
}
