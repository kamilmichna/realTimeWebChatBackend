CREATE TABLE Users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    joined_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE Chats (
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE UserChats (
    user_id INT NOT NULL,
    chat_id INT NOT NULL,
    PRIMARY KEY (user_id, chat_id),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (chat_id) REFERENCES Chats(id)
);

CREATE TABLE Messages (
    id INT NOT NULL AUTO_INCREMENT,
    content TEXT NOT NULL,
    state VARCHAR(10) NOT NULL,
    sender_id INT NOT NULL,
    chat_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sender_id) REFERENCES Users(id),
    FOREIGN KEY (chat_id) REFERENCES Chats(id)
);


INSERT INTO Users (username, password)
VALUES ('johndoe', 'password1');

INSERT INTO Users (username, password)
VALUES ('janedoe', 'password2');

INSERT INTO Users (username, password)
VALUES ('bobsmith', 'password3');

INSERT INTO Users (username, password)
VALUES ('alicelee', 'password4');

INSERT INTO Users (username, password)
VALUES ('samjones', 'password5');

INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;
INSERT INTO Chats DEFAULT VALUES;

INSERT INTO UserChats (user_id, chat_id)
VALUES (1, 1);

INSERT INTO UserChats (user_id, chat_id)
VALUES (2, 1);

INSERT INTO UserChats (user_id, chat_id)
VALUES (1, 2);

INSERT INTO UserChats (user_id, chat_id)
VALUES (2, 2);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('Hello, how are you?', 'SENDING', 1, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('I am doing well, thanks for asking.', 'SENDING', 2, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('What did you do this weekend?', 'SENDING', 1, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('Not much, just hung out with friends.', 'SENDING', 2, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('Do you want to grab lunch today?', 'SENDING', 1, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('Sure, where do you want to go?', 'SENDING', 2, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('I was thinking of trying that new sushi place.', 'SENDING', 1, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('Sounds good to me!', 'SENDING', 2, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('What time should we meet?', 'SENDING', 1, 1);

INSERT INTO Messages (content, state, sender_id, chat_id)
VALUES ('How about 12:30?', 'SENDING', 2, 1);
