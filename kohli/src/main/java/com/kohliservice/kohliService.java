package com.kohliservice;

import java.util.List;

import com.kohlidao.kohliDAOInterface;
import com.kohlientity.kohliUser;
import com.kohliutility.DAOFactory;

public class kohliService implements kohliServiceInterface {
	kohliDAOInterface kd = null;
	
	public kohliService() {
		kd = DAOFactory.createObject();
	}

	public int createProfileService(kohliUser ku) {
		//kohliDAOInterface kd = DAOFactory.createObject();
		int i = kd.createProfileDAO(ku);
		return i;
		
	}

	public int deleteProfileService(kohliUser ku) {
		
		int i = kd.deleteProfileDAO(ku);
		return i;
	}

	public kohliUser viewProfileService(kohliUser ku) {
		kohliUser i = kd.viewProfileDAO(ku);
		return i;
		
	}

	@Override
	public List<kohliUser> viewAllProfilesService() {
		List<kohliUser> i = kd.viewAllProfilesDAO();
		return i;
	}

	@Override
	public List<kohliUser> searchProfileService(kohliUser vu) {
		List<kohliUser> i = kd.searchProfileDAO(vu);
		return i;
		
	}

	@Override
	public int editProfileService(kohliUser vu) {
		int i = kd.editProfileDAO(vu);
		return i;
	}

	@Override
	public kohliUser signINService(kohliUser ku) {
		kohliUser i = kd.signINDAO(ku);
		return i;
	}

}
