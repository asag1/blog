insert into post (id, title, text, data)
values (10, 'Trip to Japan',
        'In Japan the food can be described as clean and minimalist, but never simple, which probably sums up Japan as a whole.  It’s a place that both lives up to, and out does, any expectation you have upon arrival.',
        '2019-06-30');

insert into comment (id, comment, answer, data, post)
values (1, 'perfect view', 'thanks', '2018-12-31', 10);

insert into comment (id, comment, answer, data, post)
values (2, 'not very interesting', 'why?', '2019-01-01', 10);

insert into comment (id, comment, answer, data, post)
values (3, 'good', null, '2019-01-31', 10);


insert into post (id, title, text, data)
values (11, 'Trip to Japan',
        'Turkey is a country full of contrasts: imposing mountain ranges and fertile plains, lively bathing houses and deserted picturesque beaches, rapidly growing cities and sleepy villages.',
        '2018-12-31');
