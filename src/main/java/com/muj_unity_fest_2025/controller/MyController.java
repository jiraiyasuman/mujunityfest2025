package com.muj_unity_fest_2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muj_unity_fest_2025.entity.EventDetails;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("mujunityfest")
public class MyController {

	@GetMapping("home")
	public String home() {
		log.info("redirecting to the home page");
		return "index";
	}
	@GetMapping("contact")
	public String contact() {
		log.info("redirecting to the contact page");
		return "contact";
	}
	@GetMapping("about")
	public String about() {
		log.info("redirecting to the about page");
		return "about";
	}
	@GetMapping("event")
	public String event() {
		log.info("redirecting to the event page");
		return "events"; 
	}
	@GetMapping("art")
	public String art(Model model) {
		model.addAttribute("Event", new EventDetails());
		log.info("redirecting to the art event page");
		return "art";
	}
	@GetMapping("game")
	public String game(Model model) {
		model.addAttribute("Event", new EventDetails());
		log.info("redirecting to the game event page");
		return "game";
	}
	@GetMapping("rangoli")
	public String rangoli(Model model) {
		model.addAttribute("Event", new EventDetails());
		log.info("redirecting to the rangoli event page");
		return "rangoli";
	}
	@GetMapping("treasure")
	public String treasure(Model model) {
		model.addAttribute("Event", new EventDetails());
		log.info("redirecting to the treasure event page");
		return "treasure";
	}

}
