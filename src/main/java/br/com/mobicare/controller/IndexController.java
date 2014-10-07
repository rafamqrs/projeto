package br.com.mobicare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value= "error", required = false) String error,
							  @RequestParam(value= "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView("/public/login");
		if(error != null){
			modelAndView.addObject("error", "Usuario ou senha invalidos");
		}
		
		if(logout != null){
			modelAndView.addObject("message", "Obrigado por utilizar nosso sistema");
		}
		return modelAndView;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/public/login");
		HttpSession session = request.getSession();
		if(session != null)
			session.invalidate();
		return modelAndView;
	}
}
