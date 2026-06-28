package com.aravind.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable{
	private Integer slno;
	private String countryName;
	private String countryCode;
}
