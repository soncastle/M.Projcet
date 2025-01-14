package com.acon.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceService {
	
	public static String key(String key) {
		if(key.equals("weather")) {
			return "fT2vGIbykMvAcCsiXiq2e82IeJrI2Uh6cni7eyh9jHn2cYVup9%2BWdnE8vb%2FYoChOXBGIdWSfD%2Fax1ZNrRYhy8Q%3D%3D";
		}
		else if(key.equals("map")) {
			return "75bdd1f3923ca7511f9238d28b1c4b36&libraries";
		}
		return "잘못된 접근";
	}

}
