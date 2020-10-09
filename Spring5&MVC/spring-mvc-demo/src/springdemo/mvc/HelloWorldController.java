package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormV2")
	public String letsShout(HttpServletRequest request, Model model) {
		// read request parameter from html form
		String theName = request.getParameter("studentname");
		// convert the data to all caps
		theName = theName.toUpperCase();
		// create the message
		String result = "Hey! " + theName;
		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processFormV3")
	public String letsShoutV3(@RequestParam("studentname") String theName, Model model) {
		// convert the data to all caps
		theName = theName.toUpperCase();
		// create the message
		String result = "'sup! " + theName;
		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
