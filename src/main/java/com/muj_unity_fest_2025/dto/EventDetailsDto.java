package com.muj_unity_fest_2025.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record EventDetailsDto(
		Integer eventId,
		@Schema(description="Please enter the event name")
		@NotEmpty(message ="Event Name should be not be blank/null/white-space")
		String eventName,
		@Schema(description = "Please enter the team name")
		@NotEmpty(message = "Team name should be blank/white-space/null")
		String teamName,
		@Schema(description = "Please enter the name of the first member")
		@NotEmpty(message ="Name of the first member should not be null/white-space/blank")
		String firstName,
		@Schema(description = "Please enter the name of the second member")
		@NotEmpty(message ="Name of the second member should not be null/white-space/blank")
		String secondName,
		@Schema(description="Please enter the name of the third member")
		@NotEmpty(message = "Name of the third member should not be blank/null/white-space")
		String thirdName,
		@Schema(description = "Please enter the name of the fourth member")
		@NotEmpty(message ="Name of the fourth member should not be null/white-space/blank")
		String fourthName
		)
{

}
