package com.kohlidao;

import java.util.List;

import com.kohlientity.kohliUser;

public interface kohliDAOInterface {

	int createProfileDAO(kohliUser ku);

	int deleteProfileDAO(kohliUser ku);

	kohliUser viewProfileDAO(kohliUser ku);

	List<kohliUser> viewAllProfilesDAO();

	List<kohliUser> searchProfileDAO(kohliUser vu);

	int editProfileDAO(kohliUser vu);

	kohliUser signINDAO(kohliUser ku);

}
