/* 1 */
select k.nazk
from katedra k
order by k.nazk desc;

/* 2 */
select concat(n.imen, ' ', n.prezn) 'Puno Ime'
from nastavnik n
where zvanje like 'asistent'
order by n.prezn;

/* 3 */
select count(*) 
from predmet
where sem = 1;

/* 4 */
select p.spr, p.nazp
from predmet p
where p.nazp like '%e%';

/* 5 */
insert into katedra values ('K5', 'Automatika');

/* 6 */
select n.idn, concat(n.imen, ' ', n.prezn) 'Puno Ime', sum(p.fond) 'Fond Casova', round(sum(p.fond) / count(fond)) 'Prosecan br. casova'
from predaje p inner join nastavnik n
on p.idn = n.idn
where p.idn = 'n1';

/* 7 */
select concat(n.imen, ' ', n.prezn) 'Puno Ime', k.idk
from nastavnik n right outer join katedra k
on n.idk = k.idk
where k.nazk like 'algebra';

select p.idn
from predaje p inner join predmet pr
on p.spr = pr.spr
where pr.sem = '1';

/*, n.zvanje 'Zvanje', k.nazk 'Katedra', p.fond 'Fond Casova', pr.nazp 'Naziv predmeta', pr.sem 'Semestar'*/
select concat(n.imen, ' ', n.prezn) 'Puno Ime'
from nastavnik n inner join katedra k
on n.idk = k.idk inner join predaje p
on n.idn = p.idn inner join predmet pr
on p.spr = pr.spr
where k.nazk like 'algebra' and pr.sem = '1';

/* 8 */
select k.nazk 'Naziv Katedre'
from katedra k left join nastavnik n
on k.idk = n.idk
where n.idk is null;

/* 9 */
select pr.sem
from predmet pr
order by sem desc;

/* 10 */
update nastavnik n
set idk = 'K2'
where n.imen like 'm%';

/* revert */
update nastavnik n
set idk = 'K1'
where n.prezn like 'maric';
update nastavnik n
set idk = 'K4'
where n.prezn like 'ilic';