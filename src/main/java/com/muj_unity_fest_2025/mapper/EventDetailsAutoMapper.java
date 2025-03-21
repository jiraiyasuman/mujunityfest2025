package com.muj_unity_fest_2025.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.muj_unity_fest_2025.dto.EventDetailsDto;
import com.muj_unity_fest_2025.entity.EventDetails;

@Mapper
public interface EventDetailsAutoMapper {

	EventDetailsAutoMapper MAPPER = Mappers.getMapper(EventDetailsAutoMapper.class);
	
	EventDetails mapToEventDetails(EventDetailsDto eventDetailsDto);
	EventDetailsDto mapToEventDetailsDto(EventDetails eventDetails);
}
