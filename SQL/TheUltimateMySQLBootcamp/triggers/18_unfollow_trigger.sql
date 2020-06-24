DELIMITER $$

CREATE TRIGGER create_unfollow
    AFTER DELETE ON follows FOR EACH ROW 
BEGIN
    INSERT INTO unfollows
    SET follower_id = OLD.follower_id,
        followee_id = OLD.followee_id;
END$$

DELIMITER ;

# source 18_unfollow_trigger.sql;
# after trigger launched try this:
# SELECT * FROM follows LIMIT 5;
# SELECT * FROM unfollows;
# DELETE FROM follows WHERE follower_id=2 AND followee_id=1;
# SELECT * FROM unfollows;
# DELETE FROM follows WHERE follower_id=3;
# SELECT * FROM unfollows;