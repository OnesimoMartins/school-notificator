set session_replication_role='replica';
delete from student;
delete from lesson;
delete from professor;
delete from selected_lesson;
delete from student_professor cascade;

alter sequence student_id_seq restart  with 1;
alter sequence professor_id_seq restart  with 1;
alter sequence lesson_id_seq restart  with 1;
alter sequence selected_lesson_id_seq restart with 1;

set session_replication_role='origin';

insert into lesson(name) values('Física'),('Química'),('Programação'),
('Arquitectura'),('Matemática'),('Estatística');

insert into professor(name,lesson_id) values('João Silva',1),('Miguel Agostinho',2)
,('António Ferreira',3),('Edson António',4),('Marcela Caetano',5),('Bunga Teka',6);

insert into student(name,email) values('Lúcia Ribas','tesete'),
('Tersa dos santos','teste'),('Antonio Luciano','tesete'),
('Migue da silva','tesete'),('João Torres','tesete');

insert into selected_lesson(student_id,lesson_id) values
(1,1),(1,2),(1,3),(2,3),(2,4),(2,5),(3,1),(3,3),
(4,3),(4,2),(4,5),(5,1),(5,6),(5,5);