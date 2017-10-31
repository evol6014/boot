package com.example.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="tbl_country")
@Data
@ToString(exclude={"city"})
public class CountryVO {
	
	@Id
	private String code;
	private String name;
	private String continent;
	private String region;
	private Float surfacearea;
	private Integer indepyear;
	private Integer population;
	private Float lifeexpectancy;
	private Float gnp;
	private Float gnpold;
	private String localname;
	private String governmentform;
	private String headofstate;
	private Integer capital;
	private String code2;
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	List<CityVO> city;
	
	
}
