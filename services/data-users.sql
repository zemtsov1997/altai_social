CREATE USER 'auth_service'@'%' IDENTIFIED BY 'auth_service';
GRANT ALL PRIVILEGES ON * . * TO 'auth_service'@'%';
FLUSH PRIVILEGES;

CREATE USER 'social_service'@'%' IDENTIFIED BY 'social_service';
GRANT ALL PRIVILEGES ON * . * TO 'social_service'@'%';
FLUSH PRIVILEGES;