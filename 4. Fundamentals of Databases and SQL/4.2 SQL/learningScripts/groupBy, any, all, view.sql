/*select
from
where
group by
having
order by*/

select spr, count(mbr), sum(brc)
from radproj
group by spr;

select rp.spr, count(rp.mbr) 'Broj Radnika', sum(rp.brc) 'Ukupno Angazovanje', p.nap 'Naziv Projekta'
from radproj rp join projekat p /* from radproj rp, projekat p */
on rp.spr = p.spr /* where rp.spr = p.spr */
group by p.spr, p.nap; /* p.nap ne mora u mysql workbenchu nego u oracle */

select mbr
from radproj
group by mbr
having count(spr) > 2;
select mbr, count(spr)
from radproj
group by mbr
having count(spr) > 2;

select nap
from radproj rp, projekat p
where p.spr = rp.spr
group by p.spr, nap
having sum(brc) > 15;

select p.spr, p.nap
from radproj rp, projekat p
where p.spr = rp.spr
group by rp.spr
having count(rp.mbr) > 2;

select concat(r.ime, ' ', r.prz) 'Puno Ime', count(spr) 'Rukovodi brojem projekata' 
from radnik r, projekat p
where r.mbr = p.ruk
group by r.mbr, r.prz, r.ime;

select r.mbr, concat(r.ime, ' ', r.prz) 'Puno Ime', count(spr) 'Br. Proj.', sum(rp.brc) 'Ukupno Angaz.'
from radnik r, radproj rp
where r.mbr = rp.mbr
group by r.mbr, r.prz, r.ime;

select concat(r.ime, ' ', r.prz) 'Puno Ime', count(distinct rp.spr) 'Br. Proj.'
from radnik r, radproj rp, projekat p
where r.mbr = rp.mbr and p.ruk = r.mbr
group by r.mbr, r.ime, r.prz;
/* ili */ /* test! */
select r.prz, r.ime, count(rp.spr)
from radnik r, radproj rp
where r.mbr = rp.mbr and r.mbr in (select ruk from projekat)
group by r.mbr, r.prz, r.ime;

select p.nap, p.spr
from radproj rp, projekat p
where p.spr = rp.spr
group by p.spr, p.nap
having avg(brc) > (select avg(brc) from radproj);

/* any, all */
select mbr, ime, prz plt
from radnik
where plt < any (select plt from radnik where sef = 30);

select mbr, ime, prz, plt
from radnik
where plt > all (select plt from radnik where sef = 70);
/*
select p.nap, p.spr
from radproj rp, projekat p
*/
/* view */ /* test! */
create or replace view plate_radnika (puno_ime, plata) as
select concat(ime, ' ', prz), plt
from radnik;

select * from plate_radnika where plata > 35000;

create or replace view radniciView (maticni_broj, ukupan_broj_sati) as
select r.mbr, ifnull(sum(rp.brc), 0)
from radnik r left join radproj rp
on r.mbr = rp.mbr
group by r.mbr; 

create or replace view sefovi(maticni_broj, puno_ime, rukovodi, ukupno_angazovanje) as
select r.sef, concat(r1.ime, ' ', r1.prz), count(*), rw.ukupan_broj_sati
from radnik r, radnik r1, radniciview rw
where r.sef = r1.mbr and r.sef = rw.maticni_broj
group by r.sef, r1.prz, r1.ime, rw.ukupan_broj_sati; 

select sum(ukupno_angazovanje) as 'ukupno angazovanje'
from sefovi;