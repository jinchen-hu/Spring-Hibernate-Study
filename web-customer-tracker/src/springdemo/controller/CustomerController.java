package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Customer;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customers from DAO
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model) {

		// create model attribute to bind from data
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		// save the customer
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}
}
