select radnik.mbr, prz, ime, plt, brc 
from radnik, radproj 
where radnik.mbr = radproj.mbr 
order by mbr asc;

select r.mbr, r.prz, r.ime, r.plt, rp.spr, rp.brc 
from radnik r, radproj rp 
where r.mbr = rp.mbr 
order by mbr asc;

select r.mbr, r.prz, r.ime, r.plt, rp.brc 
from radnik r, radproj rp 
where rp.spr = 10 and r.mbr = rp.mbr 
order by mbr asc;

select r.mbr, concat(r.ime, ' ', r.prz) 'Ime I Prezime', p.nap 'Naziv Projekta', rp.brc 'Radnih Sati', rp.spr 'Sifra Projekta' 
from radnik r, radproj rp, projekat p
where r.mbr = rp.mbr and rp.spr = p.spr and rp.spr = 10 /* uslov spoja */
order by mbr;

select p.spr, r.mbr, concat(r.ime, ' ', r.prz) 'Rukovodilac', r.plt 'Plata', p.nap 'Naziv Projekta'
from radnik r, projekat p
where r.mbr = p.ruk
order by spr;

select concat(ime, ' ', prz) 'Ime I Prezime'
from radnik 
natural join radproj
where spr = 30;

select concat(ime, ' ', prz) 'Ime I Prezime'
from radnik r inner join radproj rp
on r.mbr = rp.mbr
where spr = 30;

select r.mbr, ime, prz, spr
from radnik r 
left outer join radproj rp /* ako stavimo right bice isto kao inner join */
on r.mbr = rp.mbr;

select p.spr, nap, mbr
from projekat p left outer join radproj rp
on p.spr = rp.spr;

select r.mbr, r.ime, r.prz, ifnull(nap, 'ne rukovodi projektom') 'Naziv Projekta' /* zamena null tekstom */
from radnik r left outer join projekat p
on p.ruk = r.mbr;

select p.spr, nap, ifnull(mbr, '0') mbr
from radproj rp right outer join projekat p /* ispisi imena i prezimena */
on p.spr = rp.spr; /*ovde moze right/left out join - radproj i radnik preko mbr, vezbaj spajanje tabela */

/* 
select ifnull(rp.mbr, 0) 'mbr', nap
from radproj rp full outer join projekat p
on rp.spr = p.spr;
*/

select r.mbr, r.ime, r.prz, ifnull(rp.spr, 'ne radi na proj.') spr
from radnik r left outer join radproj rp
on r.mbr = rp.mbr;

select r.mbr, concat(r.ime, ' ', r.prz) 'Puno Ime',  ifnull(p.nap, 'ne radi na proj.') 'Naziv Projekta'
from radnik r left outer join radproj rp
on r.mbr = rp.mbr left outer join projekat p
on rp.spr = p.spr
order by r.prz;

select r.mbr, r.ime, r.prz, r.plt, s.mbr, concat(s.ime, ' ', s.prz) 'Sef'
from radnik r, radnik s
where r.sef = s.mbr;

select r.mbr, concat(r.ime, ' ', r.prz) 'Puno Ime', r.plt, ifnull(s.prz, 'nema sefa') 'Sef'
from radnik r left outer join radnik s
on r.sef = s.mbr; /* test! */