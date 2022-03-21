package com.kohliutility;

import com.kohlidao.kohliDAO;
import com.kohlidao.kohliDAOInterface;

public class DAOFactory {

	public static kohliDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new kohliDAO();
	}

}
