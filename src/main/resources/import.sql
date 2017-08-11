-- -- drop table if EXISTS user CASCADE ;
-- -- drop table if EXISTS userInfo CASCADE ;
-- -- drop table if EXISTS userWeight CASCADE ;
-- -- drop table if EXISTS userNotes CASCADE ;
-- -- drop table if EXISTS userExerciseId CASCADE ;
-- -- drop table if EXISTS user_exercise CASCADE ;
-- --
-- -- create table user(userId SERIAL NOT NULL PRIMARY KEY, login VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255), birthDay DATE , email VARCHAR(255), hashedPassword VARCHAR(255));
-- --
-- -- CREATE TABLE userWeight(uweight_id SERIAL not null PRIMARY KEY,userId int REFERENCES user(userId), weightKg int, date DATE);
-- --
-- -- CREATE TABLE userExerciseId(exercise_id SERIAL not null PRIMARY KEY, name VARCHAR(255), description text, exerciseType VARCHAR(255));
-- --
-- -- CREATE TABLE workout(workoutId SERIAL NOT NULL PRIMARY KEY ,userId int REFERENCES user(userId), date DATE);
-- --
-- -- CREATE TABLE userExercise(usexercise_id SERIAL NOT NULL PRIMARY key, exercise_id int REFERENCES userExerciseId(exercise_id), workoutId int REFERENCES workout(workoutId), repeat int, series int);
-- --
-- -- create table userInfo(uinfo_id SERIAL NOT NULL PRIMARY KEY, userId int REFERENCES user(userId), actualWeight int REFERENCES userWeight(uweight_id), efavourite_id int REFERENCES userExerciseId(exercise_id));
-- --
-- -- CREATE TABLE userNotes(unotes_id SERIAL NOT NULL PRIMARY key, userId int REFERENCES user(userId), note text, date DATE );
--
-- -- drop TABLE if EXISTS oauth_access_token;
-- -- drop TABLE if EXISTS oauth_refresh_token;
--
CREATE TABLE oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);
CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);
--
--INSERT INTO user_details (enabled, login, hashedPassword, birth_day, email, first_name, last_name) VALUES (TRUE, 'nowy', '123', '1990-01-22', 'kowal@email.pl', 'kowalczyk', 'kowal');
-- INSERT INTO user_details (enabled, login, hashedPassword, birth_day, email, first_name, last_name) VALUES (TRUE, 'nowy2', '1234', '1996-01-22', 'email@email.pl', 'nowy2', 'nowy');

-- INSERT INTO role (name) VALUES ('USER');
-- INSERT INTO user_role (user_details_id, role_id) VALUES (1, 1);
--
-- INSERT INTO workout(user_details_id, date) VALUES (1, '2015-02-02');
-- INSERT INTO workout(user_details_id, date) VALUES (1, '2015-03-03');
-- INSERT INTO exercise (name, exercise_type) VALUES ('Przysiady', 'LEGS');
-- INSERT INTO exercise (name, exercise_type) VALUES ('Przysiady przednie', 'LEGS');
-- INSERT INTO exercise (name, exercise_type) VALUES ('Wykroki', 'LEGS');
-- INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 1, 10, 3);
-- INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 1, 10, 3);
-- INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 1, 10, 3);
-- INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 2, 7, 2);
-- INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 2, 12, 4);
-- INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1,'2016-10-11', 64);
-- INSERT INTO user_info (user_details_id, weight_id) VALUES (1, 1);
-- INSERT INTO user_notes (user_details_id, date, note)VALUES (1, '2016-10-23', 'notatka pierwsza jakas tam blalblablalbablabl');
-- INSERT INTO user_notes (user_details_id, date, note)VALUES (1, '2016-09-26', 'njklsadhaslkdjlaksdjlaskdjlaksjdlakdjlskajd');
--
--
