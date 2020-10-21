CREATE TABLE user_system (
	id serial PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(200) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE role (
	id serial PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_system_role (
    id_user BIGINT NOT NULL,
    id_role BIGINT NOT NULL,
    PRIMARY KEY (id_user, id_role),
    FOREIGN KEY (id_user) REFERENCES user_system(id),
    FOREIGN KEY (id_role) REFERENCES role(id)
);

--SENHA 123 BCryptPasswordEncoder
INSERT INTO user_system(id, username, email, password, enabled) VALUES ('Ronnie', 'ronniemikihiro@gmail.com', '$2a$10$wjnI.MH/fPadrXIxGx1sr.W/JhMph7.y/xqJ/AX1MTY/xlgWEOIW6', true);
INSERT INTO role(name) VALUES ('ROLE_ADMIN');
INSERT INTO user_system_role(id_user, id_role) VALUES (1 , 1);