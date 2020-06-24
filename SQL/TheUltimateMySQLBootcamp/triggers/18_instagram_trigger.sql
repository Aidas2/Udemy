DELIMITER $$

CREATE TRIGGER example_cannot_follow_self
     BEFORE INSERT ON follows FOR EACH ROW
     BEGIN
          IF NEW.follower_id = NEW.followee_id
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Cannot follow yourself, silly';
          END IF;
     END;
$$

DELIMITER ;


# source 18_instagram_trigger.sql;
# after trigger launched try this:
# INSERT INTO follows(follower_id, followee_id) VALUES(5,5);