package com.kohlidao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

import com.kohlientity.TimelineDetails;
import com.kohlientity.kohliUser;

public class kohliDAO implements kohliDAOInterface {
	Connection con = null;
	
	public kohliDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","gurivi777");
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int createProfileDAO(kohliUser ku) {
		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into kohliUser values(?,?,?,?)");
			ps.setString(1, ku.getName());
			ps.setString(2, ku.getPassword());
			ps.setString(3, ku.getEmail());
			ps.setString(4, ku.getAddress());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return i;
		
		
	}
	public int deleteProfileDAO(kohliUser ku) {

		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("delete from kohliUser where email=?");
			ps.setString(1, ku.getEmail());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public kohliUser viewProfileDAO(kohliUser ku) {
		kohliUser v = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from kohliUser where email=?");
			ps.setString(1, ku.getEmail());
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);	
						
				v = new kohliUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
				
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
			
		
	}

	@Override
	public List<kohliUser> viewAllProfilesDAO() 
	{
		kohliUser v = null;
		List<kohliUser> ll = new ArrayList<kohliUser>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from kohliUser");
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);		
						
				v = new kohliUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
			
				ll.add(v);
				
			}
				
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}

	public List<kohliUser> searchProfileDAO(kohliUser ku) {

		kohliUser v = null;
		List<kohliUser> ll = new ArrayList<kohliUser>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from kohliUser where name=?");
			ps.setString(1, ku.getName());
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);	
						
				v = new kohliUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
				
				ll.add(v);
				
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}

	@Override
	public int editProfileDAO(kohliUser ku) {
		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("update kohliUser set name=?, password=?, address=? where email=?");
			ps.setString(1, ku.getName());
			ps.setString(2, ku.getPassword());
			ps.setString(4, ku.getEmail());
			ps.setString(3, ku.getAddress());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return i;
		
	}

	@Override
	public kohliUser signINDAO(kohliUser ku) {
		kohliUser v = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from kohliUser where email=? and password=?");
			ps.setString(1, ku.getEmail());
			ps.setString(2, ku.getPassword());
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);	
						
				v = new kohliUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
				
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public int createTimelineDAO(TimelineDetails tld) {
int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into TimelineDetails values(?,?,?,?,?)");
			ps.setString(1, tld.getMessageid());
			ps.setString(2, tld.getSender());
			ps.setString(3, tld.getMessage());
			ps.setString(4, tld.getDate());
			ps.setString(5, tld.getReciever());
			
			i = ps.executeUpdate();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}

	}



