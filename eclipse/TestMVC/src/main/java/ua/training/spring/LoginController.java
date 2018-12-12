package ua.training.spring;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import ua.training.objects.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("login", "user", new User());
	}
	
	
	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes rattr) {
		if(bindingResult.hasErrors()) {
			System.out.println("checkUser bindingResult.hasErrors()");
			return "login";
		}
		rattr.addFlashAttribute("key", "someValue");
		System.out.println("checkUser");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("main");
//		modelAndView.addObject("user", user);	
		
		//model.addAttribute("user", user);
		//return new ModelAndView("main", "user", user); 
		return "redirect:/main";
	}
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String goMainPage(HttpServletRequest request) {
		System.out.println("goMainPage");
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		
		return "main";
	}
	
	
	@RequestMapping(value = "/failed", method = RequestMethod.GET)
	public ModelAndView failed() {
		System.out.println("failed");
		return new ModelAndView("login-failed", "message", "Login failed!");
	}
	
	@RequestMapping(value = "/get-json-user", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getJsonUser(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		return user;
	}
	
	@RequestMapping(value = "/put-json-user", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> setJsonUser(@RequestBody User user){
		logger.info(user.getName());
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
