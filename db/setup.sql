CREATE DATABASE forum;
USE forum;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  username VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(4096) NOT NULL,
  email VARCHAR(255) NOT NULL,
  created_on DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_on DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE threads (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  user_id INT,
  created_on DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_on DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE posts (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  content TEXT NOT NULL,
  user_id INT NOT NULL,
  thread_id INT NOT NULL,
  created_on DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_on DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (thread_id) REFERENCES threads(id)
);