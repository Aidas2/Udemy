SELECT * FROM hb_student_tracker.student;

ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=3000;
truncate hb_student_tracker.student;

-- ALTER TABLE `hb_student_tracker`.`student` 
-- 	ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`;