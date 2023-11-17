package com.example.guestservice.api.db;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.guestservice.api.model.Event;
import com.example.guestservice.api.model.Participation;
import com.example.guestservice.api.model.User;

@Repository
public class QueryRepository {
	
    @Autowired
    JdbcTemplate jdbcTemplate;

    //GET Queries:
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM t_user;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
	
    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM t_event;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Event>(Event.class));
    }
    
    public List<Participation> getAllParticipations() {
        String sql = "SELECT * FROM bt_participation;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Participation>(Participation.class));
    }
    
    public List<User> getUserById(String userEmail) {
        String sql = "SELECT * FROM t_user WHERE email = '" + userEmail + "';";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
	
    public List<Event> getEventById(String name) {
        String sql = "SELECT * FROM t_event WHERE name = '" + name + "';";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Event>(Event.class));
    }
    
    public List<Participation> getParticipationById(String userEmail, String eventName) {
        String sql = "SELECT * FROM bt_participation WHERE (user_email = '" + userEmail + "') AND (event_name = '" + eventName + "');";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Participation>(Participation.class));
    }
    
    public List<Participation> getParticipationByUserId(String userEmail) {
        String sql = "SELECT * FROM bt_participation WHERE user_email = '" + userEmail + "';";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Participation>(Participation.class));
    }
    
    public List<Participation> getParticipationByEventId(String eventName) {
        String sql = "SELECT * FROM bt_participation WHERE event_name = " + eventName + "';";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Participation>(Participation.class));
    }
    
    //CREATE/UPDATE Queries:
	public void createUser(User user) {
		String sql = "INSERT INTO t_user(email, name, pw) VALUES('" + user.getEmail() + "', '" + user.getFirstname() + "', '" + user.getPassword() + "');";
		jdbcTemplate.execute(sql);
	};
	
	public void createEvent(Event event) {
		Date d = (Date) event.getDate();
		String dateString = d.getDate() + "-" + (d.getMonth()+1) + "-" + d.getYear() + " " + d.getHours() + ":" + d.getMinutes();
		String sql = "INSERT INTO t_event(name, date_) VALUES('" + event.getName() + "', TO_DATE('" + dateString + "', 'DD-MM-YYYY HH24:MI'));";
		jdbcTemplate.execute(sql);
	};
	
	public void createParticipation(Participation participation) {
		String sql = "INSERT INTO bt_participation(user_name, event_name) VALUES('" + participation.getUserEmail() + "', '" + participation.getEventName() + "');";
		jdbcTemplate.execute(sql);
	};
	
	public void updateUser(User newUser, User oldUser) {
		deleteUser(oldUser);
		createUser(newUser);
	};
	
	public void updateEvent(Event newEvent, Event oldEvent) {
		deleteEvent(oldEvent);
		createEvent(newEvent);
	};
	
	public void updateParticipation(Participation newParticipation, Participation oldParticipation) {
		deleteParticipation(oldParticipation);
		createParticipation(newParticipation);
	};
	
	//DELETE Queries
	public void deleteUser(User user) {
		deleteParticipationByUserId(user.getEmail());
		String sql = "DELETE FROM t_user WHERE email = '" + user.getEmail() + "';";
		jdbcTemplate.execute(sql);	
	};
	
	public void deleteEvent(Event event) {
		deleteParticipationByEventId(event.getName());
		String sql = "DELETE FROM t_event WHERE name = '" + event.getName() + "';";
		jdbcTemplate.execute(sql);
	};
	
	public void deleteParticipation(Participation participation) {
		String sql = "DELETE FROM bt_participation WHERE (user_email = '" + participation.getUserEmail() + "') AND (event_name = '" + participation.getEventName() + "');";
		jdbcTemplate.execute(sql);
	};
	
	public void deleteParticipationByUserId(String userEmail) {
		String sql = "DELETE FROM bt_participation WHERE user_email = '" + userEmail + "';";
		jdbcTemplate.execute(sql);
	};
	
	public void deleteParticipationByEventId(String eventName) {
		String sql = "DELETE FROM bt_participation WHERE event_name = '" + eventName + "';";
		jdbcTemplate.execute(sql);
	};
	
	
	//Method to reset tables:
	
	public void dropTables() {
		String sql = "DROP TABLE bt_participation;\r\n"
				+ "DROP TABLE t_user;\r\n"
				+ "DROP TABLE t_event;";
		jdbcTemplate.execute(sql);
	}
	
	//Method to initialise Schema:
	public void initSchema() {
		String sql = "CREATE TABLE t_user (\r\n"
				+ "	email VARCHAR(255) PRIMARY KEY,\r\n"
				+ "	name VARCHAR(255),\r\n"
				+ "	pw VARCHAR(255)\r\n"
				+ ");\r\n"
				+ "\r\n"
				+ "CREATE TABLE t_event (\r\n"
				+ "	name VARCHAR(255) PRIMARY KEY,\r\n"
				+ "	date_ DATE	--format: 'DD-MM-YYYY HH24:MI'\r\n"
				+ ");\r\n"
				+ "\r\n"
				+ "CREATE TABLE bt_participation (\r\n"
				+ "	user_email VARCHAR(255) REFERENCES t_user(email),\r\n"
				+ "	event_name VARCHAR(255) REFERENCES t_event(name),\r\n"
				+ "	PRIMARY KEY(user_name, event_name)\r\n"
				+ ");";
		jdbcTemplate.execute(sql);
	}
}
