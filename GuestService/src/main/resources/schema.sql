--create schema

CREATE TABLE t_user (
	email VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255),
	pw VARCHAR(255)
);

CREATE TABLE t_event (
	name VARCHAR(255) PRIMARY KEY,
	date_ DATE	--format: 'DD-MM-YYYY HH24:MI'
);

CREATE TABLE bt_participation (
	user_email VARCHAR(255) REFERENCES t_user(email),
	event_name VARCHAR(255) REFERENCES t_event(name),
	PRIMARY KEY(user_name, event_name)
);