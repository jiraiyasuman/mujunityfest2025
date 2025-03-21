package com.muj_unity_fest_2025.service;

import org.springframework.data.domain.Page;

import com.muj_unity_fest_2025.dto.EventDetailsDto;

public interface EventDetailsService {

	public EventDetailsDto saveEventDetails(EventDetailsDto eventDetailsDto);
	
	public Page<EventDetailsDto> getEventDetailsAll(int page, int size);
}
