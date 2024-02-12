select p.nazp
from projekti p
order by nazp asc;

select concat(d.nazdeo," ", d.cena) 'Naziv i Cena dela'
from deo d
where d.cena is not null
order by d.nazdeo asc;

select n.iddeo, count(*)
from nabavka n
group by n.iddeo;

select d.iddeo, d.nazdeo
from deo d
where d.nazdeo like "%c%";

insert into projekti
values ("P5", "Proširenje gasovoda", "Novi Sad");

select n.idp, sum(d.cena)
from nabavka n join deo d
on n.iddeo = d.iddeo
where n.idp = 'P1'
group by n.idp;

select avg(d.cena) 'Prosecna cena delova'
from deo d;

select distinct dob.idd, dob.nazd 'Dobavljac'
from dobavljac dob
where dob.mesd like 'beograd';

select p.nazp
from projekti p left join nabavka n on p.idp = n.idp
left join deo d on n.iddeo = d.iddeo
where d.iddeo is null;

update dobavljac set mesd = "Kragujevac"
where nazd like "a%";

select d.nazdeo 'Naziv dela', ifnull(d.cena, 'nema na stanju') 'Cena'
from deo d;

select n.idd, dob.nazd, count(n.iddeo) 'Br. Delova kojim snabdeva'
from nabavka n inner join dobavljac dob
on n.idd = dob.idd
group by n.idd;

SELECT d.NAZD AS Dobavljac, COUNT(n.IDDEO) AS BrojDelova
FROM Dobavljac d
LEFT JOIN Nabavka n ON d.IDD = n.IDD
GROUP BY d.NAZD;

select nazdeo, cena
from deo
order by cena desc
limit 1;

select d.nazdeo
from deo d join nabavka n on d.iddeo = n.iddeo
group by d.iddeo, d.nazdeo
having COUNT(distinct n.idd) >= 2;

create or replace view prikaz_delova_projekta(Naziv_dela, Cena_dela, Naziv_projekta) as
select distinct d.nazdeo, d.cena, p.nazp
from deo d join nabavka n
on d.iddeo = n.iddeo join projekti p
on n.idp = p.idp;

create or replace view prikaz_dobavljaca_delova(Naziv_dobavljaca, Broj_delova) as
select dob.nazd, count(distinct n.iddeo)
from dobavljac dob join nabavka n
on dob.idd = n.idd
group by dob.idd, dob.nazd;

create or replace view prikaz_projekata_dobavljaca(Naziv_projekta, Grad_dobavljaca) as
select distinct p.nazp, dob.mesd
from projekti p join nabavka n
on p.idp = n.idp join dobavljac dob
on n.idd = dob.idd;