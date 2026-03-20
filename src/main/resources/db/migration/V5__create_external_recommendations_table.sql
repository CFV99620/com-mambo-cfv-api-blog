CREATE TABLE external_recommendations (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    url VARCHAR(500) NOT NULL,
    is_featured BOOLEAN NOT NULL DEFAULT FALSE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recommendation_categories (
    recommendation_id BIGINT NOT NULL,
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY (recommendation_id, category),
    FOREIGN KEY (recommendation_id) REFERENCES external_recommendations(id) ON DELETE CASCADE
);
