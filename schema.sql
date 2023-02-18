CREATE TABLE film
(
    film_id     SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    title       VARCHAR(128)      NOT NULL,
    description TEXT             DEFAULT NULL,
    review_id   TINYINT UNSIGNED DEFAULT NULL,
    PRIMARY KEY (film_id)
);

INSERT INTO film
VALUES (1, 'ACADEMY DINOSA', 'A Epic Drama of a Feminist And', 3),
       (2, 'ACE GOLDFINGER', 'A Astounding Epistle of a Data', 2),
       (3, 'ADAPTATION HOL', 'A Astounding Reflection of a L', 1),
       (4, 'AFFAIR PREJUDI', 'A Fanciful Documentary of a Fr', 4),
       (5, 'AFRICAN EGGhgh', 'A Fast-Paced Documentary of a ', 6);