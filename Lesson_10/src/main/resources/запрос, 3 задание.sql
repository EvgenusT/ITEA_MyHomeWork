
create table Student (student_id int primary key auto_increment, 
first_name varchar(50) not null, 
last_name  varchar(50) not null, 
data_of_birth date);

create table Module (module_id int primary key auto_increment, 
module_title varchar(50) not null, 
level  varchar(50) not null, 
credits int default 20 not null);

create table Registration (student_id int,
module_id int, 
 result decimal (10,1) not null,
 FOREIGN KEY (student_id) references Student (student_id),
 FOREIGN KEY (module_id) references Module (module_id));

insert student (student_id,  first_name,  last_name, data_of_birth) 
values 
(1, 'Daniel', 'Radcliffe', '1995-04-23'), 
(2, 'Emma', 'Watson', '1994-07-15'), 
(3, 'Rupert', 'Grint', '1995-10-24');

insert module (module_id,  module_title, level, credits) 
values 
(1, 'Math', 1, 30), 
(2, 'Physics', 1, 0), 
(3, 'Chemistry', 1, 15);

INSERT INTO registration (student_id, module_id, result) 
value
(1, 1, 12), 
(1, 2, 10), 
(1, 3, 5), 
(2, 3, 12), 
(2, 1, 12), 
(3, 2, 10), 
(3, 1, 2);
