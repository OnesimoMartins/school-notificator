create or replace function INSERT_ON_STUDENT_LESSON()
 returns trigger as
$body$
begin
       insert into student_professor(student_id,professor_id) 
	      values(NEW.student_id,(select id from professor where lesson_id=NEW.lesson_id));
	   return NEW;
end

$body$
language PLPGSQL;

create or replace trigger INSERT_ON_STUDENT_LESSON_TROGGER after insert on 
selected_lesson
for each row  execute procedure INSERT_ON_STUDENT_LESSON();