package com.kohliutility;

import com.kohlicontroller.kohliControllerInterface;
import com.kohlicontroller.kohlicontroller;

public class ControllerFactorty {

	public static kohliControllerInterface createObject() {
		// TODO Auto-generated method stub
		return new kohlicontroller();
	}

}
