CREATE TABLE post_categories (
    post_id BIGINT NOT NULL,
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY (post_id, category),
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);
