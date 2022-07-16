create table student(
id serial,
name varchar(100) not null, email varchar(200) not null,
primary key(id)
);

create table lesson(
id serial primary key,
name varchar(100) not null	
);

create table professor(
id serial primary key,
name varchar(100) not null,
lesson_id BIGINT not null REFERENCES lesson(id)
);


create table selected_lesson(
id serial primary key,
lesson_id BIGINT not null REFERENCES lesson(id)  ,
student_id BIGINT not null REFERENCES student(id) ,
first_Test SMALLINT NULL,
second_Test SMALLINT NULL,
status varchar(15) null
);

create table student_professor(
student_id BIGINT not null references student(id),
professor_id BIGINT not null REFERENCES professor(id)
);