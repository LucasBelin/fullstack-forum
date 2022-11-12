CREATE DATABASE fullstack_forum;
USE fullstack_forum;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(4096) NOT NULL,
  email VARCHAR(255) NOT NULL,
  created_on DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_on DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO users (username, password, email) VALUES ('admin', 'admin', 'admin@domain.com');