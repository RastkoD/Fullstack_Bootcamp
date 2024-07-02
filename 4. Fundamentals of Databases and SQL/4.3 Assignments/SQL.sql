/* 1 */
select p.nazp 'Naziv Predmeta', sum(pr.fond) 'Fond'
from predmet p, predaje pr
where p.spr = pr.spr
group by pr.spr;

/* 2 */
select concat(n.imen, ' ', n.prezn) 'Puno Ime', count(pr.spr) 'Br. Predmeta'
from nastavnik n, predaje pr
where n.idn = pr.idn
group by n.idn, n.imen, n.prezn;

/* 3 */
select p.nazp 'Naziv Predmeta'
from predmet p, predaje pr
where p.spr = pr.spr
group by pr.spr
having count(pr.idn) = 3; 

/* 4 */
select p.nazp 'Naziv Predmeta'
from predmet p, predaje pr
where p.spr = pr.spr
group by p.spr, p.nazp
having sum(fond) >= all(select sum(fond) from predaje group by spr);

/* 5 */
select k.idk, k.nazk 'Naziv Katedre', count(idn) 'Broj Natsavnika'
from katedra k, nastavnik n
where k.idk = n.idk
group by k.idk, k.nazk;

/* 6 */
select p.nazp 'Naziv Predmeta'
from predmet p, predaje pr
where p.spr = pr.spr
group by p.spr, p.nazp
having count(idn) > 2;