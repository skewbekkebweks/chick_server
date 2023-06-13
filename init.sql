INSERT INTO categories (name) VALUES (N'Набор массы');
INSERT INTO categories (name) VALUES (N'Похудение');
INSERT INTO categories (name) VALUES (N'Прокачка рук');

SELECT * FROM categories;

INSERT INTO products (name) VALUES (N'Огурцы');
INSERT INTO products (name) VALUES (N'Помидоры');
INSERT INTO products (name) VALUES (N'Морковь');
INSERT INTO products (name) VALUES (N'Свинина');
INSERT INTO products (name) VALUES (N'Курица');
INSERT INTO products (name) VALUES (N'Говядина');
INSERT INTO products (name) VALUES (N'Рис');
INSERT INTO products (name) VALUES (N'Макароны');
INSERT INTO products (name) VALUES (N'Гречка');
INSERT INTO products (name) VALUES (N'Овсянка');

SELECT * FROM products;

INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;
INSERT INTO foodsets DEFAULT VALUES;

SELECT * FROM foodsets;

INSERT INTO foodset_products (foodset, product, count, weight) VALUES (1, 7, null, 200);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (1, 5, null, 200);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (1, 1, 1, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (1, 2, 1, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (2, 3, 3, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (2, 10, null, 350);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (3, 9, null, 300);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (3, 6, null, 300);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (4, 4, null, 400);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (4, 8, null, 250);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (5, 1, 3, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (5, 2, 3, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (6, 8, null, 250);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (6, 1, 2, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (7, 8, null, 250);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (7, 2, 3, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (8, 8, null, 250);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (8, 3, 4, null);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (9, 7, null, 100);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (9, 4, null, 350);
INSERT INTO foodset_products (foodset, product, count, weight) VALUES (10, 4, null, 500);

SELECT * FROM foodset_products;

INSERT INTO exercises (name, video) VALUES (N'Приседания', N'https://media.tenor.com/dIGvgPX9k-sAAAAi/anchie-anchie_fit.gif');
INSERT INTO exercises (name, video) VALUES (N'Отжимания', N'https://media.tenor.com/gI-8qCUEko8AAAAC/pushup.gif');
INSERT INTO exercises (name, video) VALUES (N'Подтягивания', null);
INSERT INTO exercises (name, video) VALUES (N'Прыжки', null);
INSERT INTO exercises (name, video) VALUES (N'Бег', N'https://media.tenor.com/XLlMHmfAnR8AAAAi/dm4uz3-foekoe.gif');

SELECT * FROM exercises;

INSERT INTO exercise_categories (category, exercise) VALUES (2, 1);
INSERT INTO exercise_categories (category, exercise) VALUES (2, 2);
INSERT INTO exercise_categories (category, exercise) VALUES (2, 4);
INSERT INTO exercise_categories (category, exercise) VALUES (2, 5);
INSERT INTO exercise_categories (category, exercise) VALUES (3, 2);
INSERT INTO exercise_categories (category, exercise) VALUES (3, 3);

SELECT * FROM exercise_categories;

INSERT INTO courses (name, description, duration) VALUES (N'Похудей за неделю!', N'Интенсив по похудению', 7);
INSERT INTO courses (name, description, duration) VALUES (N'Набери массу за неделю', N'Интенсив по набору массы', 7);
INSERT INTO courses (name, description, duration) VALUES (N'Прокачиваем руки', N'Курс направленный на отжимания и подтягивания', 3);

SELECT * FROM courses;

INSERT INTO course_categories (category, course) VALUES (2, 1);
INSERT INTO course_categories (category, course) VALUES (1, 2);
INSERT INTO course_categories (category, course) VALUES (3, 3);
INSERT INTO course_categories (category, course) VALUES (2, 3);

SELECT * FROM course_categories;

INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (1, 5, N'Лёгкий бег 20 минут', 0, 10, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (1, 1, N'5 подходов по 15 повторений', 0, 10, 30);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (1, 4, N'3 подхода по 7 минут', 0, 10, 45);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (1, 5, N'5 км', 3, 10, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (1, 5, N'5 км', 6, 10, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (2, 3, N'10 подходов по 3 повторения', 3, 12, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (3, 2, N'10 подходов на максимум', 0, 18, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (3, 3, N'15 подходов на максимум', 1, 18, 0);
INSERT INTO course_exercises (course, exercise, description, days, hours, minutes) VALUES (3, 2, N'10 подходов на максимум', 2, 18, 0);

SELECT * FROM course_exercises;

INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (1, 5, N'Завтрак', 3, 8, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (2, 4, N'Завтрак', 0, 10, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (2, 9, N'Обед', 0, 14, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (2, 4, N'Ужин', 0, 20, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (2, 3, N'Завтрак', 3, 10, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (2, 10, N'Завтрак', 6, 10, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (3, 1, N'Завтрак', 0, 8, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (3, 9, N'Завтрак', 1, 8, 0);
INSERT INTO course_foodsets (course, foodset, description, days, hours, minutes) VALUES (3, 4, N'Завтрак', 2, 8, 0);

SELECT * FROM course_foodsets;

INSERT INTO users (name, sex, weight, height, email, password, is_admin) VALUES (N'Михаил', true, 70, 177, 'mihail.glazov2015@yandex.ru', 'Skewbek1', true);
INSERT INTO users (name, sex, weight, height, email, password, is_admin) VALUES (N'Михаил', true, 70, 177, 'mihail.glazov2015@gmail.com', 'Skewbek2', false);

SELECT * FROM users;

INSERT INTO user_categories (category, "user") VALUES (2, 1);
INSERT INTO user_categories (category, "user") VALUES (3, 1);
INSERT INTO user_categories (category, "user") VALUES (2, 2);
INSERT INTO user_categories (category, "user") VALUES (3, 2);

SELECT * FROM user_categories;

INSERT INTO user_courses (course, "user", start_date, is_completed) VALUES (1, 1, '2023-05-12', false);
INSERT INTO user_courses (course, "user", start_date, is_completed) VALUES (3, 1, '2023-05-09', true);
INSERT INTO user_courses (course, "user", start_date, is_completed) VALUES (1, 2, '2023-05-12', false);
INSERT INTO user_courses (course, "user", start_date, is_completed) VALUES (3, 2, '2023-05-09', true);

SELECT * FROM user_courses;

INSERT INTO user_exercises (exercise, "user") VALUES (2, 1);
INSERT INTO user_exercises (exercise, "user") VALUES (3, 1);
INSERT INTO user_exercises (exercise, "user") VALUES (4, 1);
INSERT INTO user_exercises (exercise, "user") VALUES (2, 2);
INSERT INTO user_exercises (exercise, "user") VALUES (3, 2);
INSERT INTO user_exercises (exercise, "user") VALUES (4, 2);

SELECT * FROM user_exercises;