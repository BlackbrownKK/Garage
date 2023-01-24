CREATE TABLE "user"
(
    user_Id integer NOT NULL AUTO_INCREMENT,
    name    text,
    PRIMARY KEY (user_Id)
);

CREATE TABLE "car"
(
    car_Id        integer NOT NULL AUTO_INCREMENT,
    user_Id_Ovner integer,
    model         text,
    FOREIGN KEY (user_Id_Ovner)
        REFERENCES "user" (user_Id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


--
-- CREATE TABLE car
-- (
--     car_Id integer NOT NULL AUTO_INCREMENT,
--     user_Id_Ovner integer,
--     model text,
-- FOREIGN KEY (user_Id_Ovner)
--         REFERENCES user (user_Id)
--         ON UPDATE NO ACTION
--         ON DELETE CASCADE
-- );
--
-- CREATE TABLE user
-- (
--     user_Id integer NOT NULL AUTO_INCREMENT,
--     name text,
--     PRIMARY KEY (user_Id)
-- );