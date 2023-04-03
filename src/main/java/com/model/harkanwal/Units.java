package com.model.harkanwal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Units {
	KG,TONS,METER,LITRE;
	
	public static Units getUnit(String value) {
	 return  Arrays
			 .stream(Units.values())
			 .filter(unit -> unit.name().equalsIgnoreCase(value))
			 .findFirst()
			 .orElse(null);
	}
	
	public static List<String> getAllUnits(){
		return  Arrays
				.stream(Units.values())
				.map(unit -> unit.name())
				.collect(Collectors.toList());
	}
}
