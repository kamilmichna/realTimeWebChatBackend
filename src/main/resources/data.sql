CREATE TABLE IF NOT EXISTS Chats (
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);



INSERT INTO Users (username, password, joined_at)
VALUES ('johndoe', 'password1', CURRENT_TIMESTAMP);

INSERT INTO Users (username, password, joined_at)
VALUES ('johndoe1', 'password1', CURRENT_TIMESTAMP);

INSERT INTO Users (username, password, joined_at)
VALUES ('johndoe2', 'password1', CURRENT_TIMESTAMP);

INSERT INTO Users (username, password, joined_at)
VALUES ('johndoe3', 'password1', CURRENT_TIMESTAMP);

INSERT INTO Users (username, password, joined_at)
VALUES ('johndoe4', 'password1', CURRENT_TIMESTAMP);


INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
