--create schema    
    
CREATE TABLE t_user (
	username VARCHAR(255) PRIMARY KEY,
	email VARCHAR(255),
	password VARCHAR(255),
	first_name VARCHAR(255),
	last_name VARCHAR(255),
);

CREATE TABLE t_event (
	name VARCHAR(255) PRIMARY KEY,
	date_ DATE	--format: 'DD-MM-YYYY HH24:MI'
);

CREATE TABLE bt_participation (
	user_username VARCHAR(255) REFERENCES t_user(username),
	event_name VARCHAR(255) REFERENCES t_event(name),
	PRIMARY KEY(user_username, event_name)
);