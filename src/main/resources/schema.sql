DROP TABLE IF EXISTS currency;

CREATE TABLE currency
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    code          VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    created_user  VARCHAR(255) NOT NULL,
    created_date  timestamp    NOT NULL,
    modified_user VARCHAR(255) NOT NULL,
    modified_date timestamp    NOT NULL,
);

