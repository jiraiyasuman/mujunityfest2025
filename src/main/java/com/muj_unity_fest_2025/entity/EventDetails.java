package com.muj_unity_fest_2025.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="event_details")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private Integer eventId;
	@Column(name="event_name")
	private String eventName;
	@Column(name="team_name")
	private String teamName;
	@Column(name="first_name")
	private String firstName;
	@Column(name="second_name")
	private String secondName;
	@Column(name="third_name")
	private String thirdName;
	@Column(name="fourth_name")
	private String fourthName;
	
}
