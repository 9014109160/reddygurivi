package com.kohliutility;

import com.kohliservice.kohliService;
import com.kohliservice.kohliServiceInterface;

public class ServiceFactory {

	public static kohliServiceInterface createObject() {
		
		return new kohliService();
	}

}
