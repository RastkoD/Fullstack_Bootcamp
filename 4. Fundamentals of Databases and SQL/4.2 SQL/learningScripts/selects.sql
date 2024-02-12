select ime, Prz from radnik;
select distinct ime, prz from radnik;
select mbr, ime, prz from radnik where plt > 25000; /* komentari */
select mbr, ime, prz, plt, plt*12 from radnik;
select mbr, ime, prz from radnik where Sef is null;
select mbr, ime, prz from radnik where plt between 20000 and 24000;
select mbr, ime, prz from radnik where god between '1973-01-01' and '1980-12-31';
select mbr, ime, prz from radnik where god not between '1973-01-01' and '1980-12-31';
select mbr, ime, prz from radnik where prz like 'M%';
select mbr, ime, prz from radnik where prz like '%s';
select mbr, ime, prz from radnik where ime not like 'a%';
select mbr, ime, prz from radnik where ime like '_a%';
select mbr, ime, prz from radnik where prz like '%e%';
select distinct mbr from radproj where spr in (10, 20, 30);
select distinct mbr from radproj where spr = 10 or brc in (2, 4, 6);
select mbr, ime, prz from radnik where ime in ('Ana', 'Sanja');
select mbr, ime, prz from radnik where ime not in ('Ana', 'Sanja');
select * from radnik where sef is not null order by prz; /* desc, asc */
select * from radnik where sef is not null order by prz, ime;
select * from radnik where sef is not null order by prz asc, ime asc;
select * from radnik where sef is not null order by prz asc, ime desc;
select mbr, ime Ime, prz Prezime, plt 'Mesecna Plata' from radnik order by 'Mesecna Plata' desc;/* ne po aliasu order */
select mbr, concat(ime, ' ', prz) 'Ime i Prezime', plt*1.17 Plata from radnik;
select mbr, plt+null from radnik;
select mbr, plt+pre from radnik;
select mbr, plt+ ifnull(pre, 0) from radnik;
select count(*) from radnik;
select count(distinct sef) broj_sefova from radnik;
select min(plt) 'Minimalna Plata', max(plt) 'Maximalna Plata' from radnik;
select count(mbr) 'Broj Radnika', sum(distinct plt) 'Mesecna Plata Svih Radnika' from radnik;
select count(mbr) 'Broj Radnika',  round(avg(plt), 2) 'Prosecna Plata', sum(distinct plt)*12 'Godisnja Plata Svih Radnika' from radnik;
select round(avg(plt), 2) 'Prosecna Plata' from radnik;
select * from radnik where plt > (select round(avg(plt), 2) from radnik)order by plt asc;
select concat(ime, ' ', prz) 'Ime i Prezime' from radnik where mbr in (select mbr from radproj where spr = 30);
select concat(ime, ' ', prz) 'Ime i Prezime' from radnik where mbr in (select mbr from radproj where spr = 10) and mbr not in (select mbr from radproj where spr = 30);
select concat(ime, ' ', prz) 'Ime i Prezime', god 'Godina Rodjenja' from radnik where god = (select min(god) from radnik);
select concat(ime, ' ', prz) 'Puno Ime' from radnik where mbr not in (select ruk from projekat where spr = '10');
select spr, nap 'Naziv Projekta' from projekat where spr in(select spr from radproj where mbr in (select mbr from radproj where spr = 10)) order by spr asc;