-- Insert seed data for users
INSERT INTO users (username, email, password_hash, role, is_active) VALUES
('mambo_admin', 'admin@mambo.com', '$2a$10$x.b9V7zH2L.m8V8U7f9Iqe1V3Z3Y.X.X.X.X.X.X.X.X.X.X.X.X.', 'ADMIN', true),
('mambo_editor', 'editor@mambo.com', '$2a$10$x.b9V7zH2L.m8V8U7f9Iqe1V3Z3Y.X.X.X.X.X.X.X.X.X.X.X.X.', 'EDITOR', true);

-- Insert seed data for posts
INSERT INTO posts (id, title, slug, content, excerpt, status, author_id, is_active, cover_image) VALUES
(1, 'Bienvenido al Blog de F1', 'bienvenido-al-blog-f1', 'Este es nuestro primer post sobre la Formula 1.', 'Primer post del blog.', 'PUBLISHED', 1, true, 'https://drive.google.com/file/d/1aVOIOQNX34QVFEDF-fZaj0DhbNS-SW60/view'),
(2, 'Nuevas Tecnologías en los Monoplazas', 'tecnologias-monoplazas-2026', 'Exploramos los cambios en el reglamento técnico para 2026.', 'Cambios técnicos 2026.', 'PUBLISHED', 1, true, 'https://drive.google.com/file/d/1aVOIOQNX34QVFEDF-fZaj0DhbNS-SW60/view'),
(3, 'El Gran Premio de Mónaco', 'gp-monaco-historia', 'Un repaso por la historia del GP más icónico.', 'Historia del GP de Mónaco.', 'PUBLISHED', 2, true, 'https://drive.google.com/file/d/1aVOIOQNX34QVFEDF-fZaj0DhbNS-SW60/view'),
(4, 'Análisis de la Temporada Actual', 'analisis-temporada-actual', 'Cómo van los equipos a mitad de temporada.', 'Análisis de mitad de temporada.', 'DRAFT', 2, true, 'https://drive.google.com/file/d/1aVOIOQNX34QVFEDF-fZaj0DhbNS-SW60/view');

-- Insert seed data for post categories
INSERT INTO post_categories (post_id, category) VALUES
(1, 'OPINION'),
(2, 'TECH'),
(3, 'SPORT'),
(4, 'OPINION'),
(4, 'TECH');
