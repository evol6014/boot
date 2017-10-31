package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="tbl_city")
@Data
@ToString(exclude={"country"})
public class CityVO {

	@Id
	private Integer id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="countrycode")
	private CountryVO country;
	
	private String district;
	private Integer population;
	
}
