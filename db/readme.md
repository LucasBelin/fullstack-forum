## Users table :

| Field      | Type          | Null | Key | Default           | Extra          |
| :--------- | :------------ | :--- | :-- | :---------------- | :------------- |
| id         | int(11)       | NO   | PRI | NULL              | auto_increment |
| username   | varchar(255)  | NO   |     | NULL              |                |
| password   | varchar(4096) | NO   |     | NULL              |                |
| email      | varchar(255)  | NO   |     | NULL              |                |
| created_on | datetime      | NO   |     | CURRENT_TIMESTAMP |                |
| updated_on | datetime      | NO   |     | CURRENT_TIMESTAMP |                |
