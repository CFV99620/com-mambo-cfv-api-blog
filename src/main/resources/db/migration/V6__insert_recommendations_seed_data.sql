-- Insert seed data for external recommendations
INSERT INTO external_recommendations (id, title, url, is_featured, is_active) VALUES
(1, 'FIA: Regulaciones Técnicas 2026', 'https://www.fia.com/f1', true, true),
(2, 'Motorsport: Noticias del Paddock', 'https://lat.motorsport.com/f1/', false, true),
(3, 'Podcast Fanáticos de F1 (Spotify)', 'https://open.spotify.com/', false, true),
(4, 'The Race: Análisis en profundidad', 'https://the-race.com/formula-1/', true, true);

-- Insert categories for these recommendations
INSERT INTO recommendation_categories (recommendation_id, category) VALUES
(1, 'TECH'),
(1, 'SPORT'),
(2, 'OPINION'),
(3, 'CULTURE'),
(4, 'TECH'),
(4, 'OPINION');

-- (Opcional en PostgreSQL) Actualizar la secuencia del ID autoincrementable 
-- para que los próximos inserts desde tu app arranquen a partir del ID 5
SELECT setval('external_recommendations_id_seq', (SELECT MAX(id) FROM external_recommendations));
