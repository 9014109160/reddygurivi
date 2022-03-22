package com.kohliservice;



import java.util.List;

import com.kohlientity.TimelineDetails;

//import javax.swing.JList;

import com.kohlientity.kohliUser;

public interface kohliServiceInterface {

	int createProfileService(kohliUser ku);

	int deleteProfileService(kohliUser ku);

	kohliUser viewProfileService(kohliUser ku);

	List<kohliUser> viewAllProfilesService();

	List<kohliUser> searchProfileService(kohliUser vu);

	int editProfileService(kohliUser vu);

	kohliUser signINService(kohliUser ku);

	int createTimelineService(TimelineDetails tld);

	

}
