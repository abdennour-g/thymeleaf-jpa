package com.example.demo.servlet;

import java.time.LocalTime;


import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.UserRepository;
import com.example.demo.ent.User;

@Controller
public class control {
	@Transient
	@Autowired
	private UserRepository userdao;
	@GetMapping("/")
public String home(Model m) {
		m.addAttribute("users", userdao.findAll());
		m.addAttribute("sinc", LocalTime.now());
		m.addAttribute("test", "oujda");
	return "home";
}
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user, Model model) {
		userdao.save(user);
		return "redirect:/";
	}
	@PostMapping("/delete")
	public String delete(@ModelAttribute("id") Long id, Model model) {
		userdao.deleteById(id);
		return "redirect:/";
	}
}
