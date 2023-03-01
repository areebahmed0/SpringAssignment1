package ca.sheridancollege.ahmed130.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ahmed130.beans.Customer;
import ca.sheridancollege.ahmed130.beans.Sell;
import ca.sheridancollege.ahmed130.database.CustomerDatabase;
import ca.sheridancollege.ahmed130.database.SellDatabase;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String homePage() {
		return "home.html";
	}
	
	@PostMapping("/add1")
	public String addPage1(@RequestParam String customerName,
							@RequestParam int customerAge,
							@RequestParam String phoneNumber,
							@RequestParam String customerAddress) {
		
		Customer c = new Customer();
		c.setName(customerName);
		c.setAge(customerAge);
		c.setNumber(phoneNumber);
		c.setAddress(customerAddress);
		
		CustomerDatabase.customers.add(c);

		System.out.println(customerName);
		System.out.println(customerAge);
		System.out.println(phoneNumber);
		System.out.println(customerAddress);
		
		System.out.println(c);
		
		return "add1.html";
	}
	@PostMapping("/add2")
	public String addPage2(@RequestParam String itemName,
							@RequestParam String itemDesc,
							@RequestParam double itemPrice,
							@RequestParam String itemColor) {

		Sell s = new Sell();
		s.setItemName(itemName);
		s.setItemDesc(itemDesc);
		s.setItemPrice(itemPrice);
		s.setItemColor(itemColor);
		
		SellDatabase.sell.add(s);
		
		System.out.println(itemName);
		System.out.println(itemDesc);
		System.out.println(itemPrice);
		System.out.println(itemColor);
		
		System.out.println(s);
		
		return "add2.html";
	}
	
	@GetMapping("/view1")
	public String viewPage1(Model model) {
		model.addAttribute("customer",CustomerDatabase.customers);
		return "view1.html";
	}
	
	@GetMapping("/view2")
	public String viewPage2(Model model) {
		model.addAttribute("item",SellDatabase.sell);
		return "view2.html";
	}
	
	@GetMapping("/add1")
	public String addPage11() {
		return "add1.html";
	}
	
	@GetMapping("/add2")
	public String addPage2() {
		return "add2.html";
	}

}
