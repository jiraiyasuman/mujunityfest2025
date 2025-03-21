package com.muj_unity_fest_2025.serviceimpl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muj_unity_fest_2025.dto.EventDetailsDto;
import com.muj_unity_fest_2025.entity.EventDetails;
import com.muj_unity_fest_2025.mapper.EventDetailsAutoMapper;
import com.muj_unity_fest_2025.repository.EventDetailRepository;
import com.muj_unity_fest_2025.service.EventDetailsService;
@Service
public class EventDetailsServiceImpl implements EventDetailsService{

	private EventDetailRepository eventDetailRepository;
	public Logger LOGGER = Logger.getLogger(getClass().getName());
	@Autowired
	public EventDetailsServiceImpl(EventDetailRepository eventDetailRepository) {
		super();
		this.eventDetailRepository = eventDetailRepository;
	}

	@Transactional
	@Override
	public EventDetailsDto saveEventDetails(EventDetailsDto eventDetailsDto) {
		EventDetails eventDetails = EventDetailsAutoMapper.MAPPER.mapToEventDetails(eventDetailsDto);
		EventDetails savedDetails = eventDetailRepository.save(eventDetails);
		System.out.println(savedDetails.toString());
		EventDetailsDto savedEventDetailsDto = EventDetailsAutoMapper.MAPPER.mapToEventDetailsDto(savedDetails);
		return savedEventDetailsDto;
	}

	@Override
	public Page<EventDetailsDto> getEventDetailsAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<EventDetails> getEventDetailsByName = eventDetailRepository.findAll(pageable);
		LOGGER.info("Fetching of event details by name in the database is happening here");
		// Convert Page<EventDetails> to List<EventDetailsDto>
	    List<EventDetailsDto> dtoList = getEventDetailsByName
	            .getContent()
	            .stream()
	            .map(EventDetailsAutoMapper.MAPPER::mapToEventDetailsDto)
	            .collect(Collectors.toList());
	    return new PageImpl<>(dtoList, pageable, getEventDetailsByName.getTotalElements());
	}

}
