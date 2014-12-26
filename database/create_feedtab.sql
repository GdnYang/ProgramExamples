
CREATE database feeds_db;

CREATE TABLE feedtab ( 
 	id INT AUTO_INCREMENT, 
 	title varchar(156), 
 	link  varchar(128),
 	pubdate varchar(30),
 	description varchar(500),
 	primary key (id)
);