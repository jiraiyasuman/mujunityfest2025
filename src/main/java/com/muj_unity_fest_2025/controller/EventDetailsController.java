package com.muj_unity_fest_2025.controller;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.muj_unity_fest_2025.dto.EventDetailsDto;
import com.muj_unity_fest_2025.entity.EventDetails;
import com.muj_unity_fest_2025.mapper.EventDetailsAutoMapper;
import com.muj_unity_fest_2025.service.EventDetailsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("mujunityfest")
public class EventDetailsController {

	private Logger log = Logger.getLogger(getClass().getName());
	private EventDetailsService eventDetailsService;
	@Autowired
	public EventDetailsController(EventDetailsService eventDetailsService) {
		super();
		this.eventDetailsService = eventDetailsService;
	}
	
	@PostMapping("saveArtEvent")
	public String saveArtEventDetails(@ModelAttribute("Event")  EventDetailsDto eventDetailsDto) {
		EventDetails eventDetails = EventDetailsAutoMapper.MAPPER.mapToEventDetails(eventDetailsDto);
		eventDetails.setEventName("Art Competition");
		System.out.println(eventDetails.toString());
		EventDetailsDto savedDetails = eventDetailsService.saveEventDetails(eventDetailsDto);
		log.info("Passing the event details into the business layers");
		
		return "events";
	}
	@PostMapping("saveGameEvent")
	public String saveGameEventDetails(@ModelAttribute("Event")  EventDetailsDto eventDetailsDto) {
		EventDetails eventDetails = EventDetailsAutoMapper.MAPPER.mapToEventDetails(eventDetailsDto);
		eventDetails.setEventName("Game Competition");
		System.out.println(eventDetails.toString());
		EventDetailsDto savedDetails = eventDetailsService.saveEventDetails(eventDetailsDto);
		log.info("Passing the event details into the business layers");
		if(eventDetails.getEventName().equals("Treasure Hunt")) {
			return "redirect:/mujunityfest/event";
		}
		return "events";
	}
	@PostMapping("saveRangoliEvent")
	public String saveRangoliEventDetails(@ModelAttribute("Event")  EventDetailsDto eventDetailsDto) {
		EventDetails eventDetails = EventDetailsAutoMapper.MAPPER.mapToEventDetails(eventDetailsDto);
		eventDetails.setEventName("Rangoli Competition");
		System.out.println(eventDetails.toString());
		EventDetailsDto savedDetails = eventDetailsService.saveEventDetails(eventDetailsDto);
		log.info("Passing the event details into the business layers");
		if(eventDetails.getEventName().equals("Treasure Hunt")) {
			return "redirect:/mujunityfest/event";
			}
		return "events";
	}
	@PostMapping("savetreasure")
	public String saveEventDetails(@ModelAttribute("Event")  EventDetailsDto eventDetailsDto) {
		EventDetails eventDetails = EventDetailsAutoMapper.MAPPER.mapToEventDetails(eventDetailsDto);
		eventDetails.setEventName("Treasure Competition");
		System.out.println(eventDetails.toString());
		EventDetailsDto savedDetails = eventDetailsService.saveEventDetails(eventDetailsDto);
		log.info("Passing the event details into the business layers");
		return "events";
	}
	@GetMapping("fetchgamecompetition")
	public String getAllDetailsByGameCompetition(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size,Model model){
		String eventName = "Game Competition";
		Pageable pageable = PageRequest.of(page, size);
		Page<EventDetailsDto> getAllList = eventDetailsService.getEventDetailsAll( page, size);
		log.info("Fetching a list of game competition event details from the business layer");
		model.addAttribute("EventList", getAllList);
		return "display";
	}
}
