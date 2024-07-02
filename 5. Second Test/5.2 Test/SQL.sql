/*
1. Prikazati sve projekte ( NAZP) koji u svom nazivu imaju slovo d na bilo kom mestu sortirane u 
opadajućem redosledu identifikacionog broja projekta.
*/
select p.nazp 'Naziv projekta'
from projekti p
where p.nazp like '%d%'
order by p.idp desc;

/*
2.  Prikazati projekat (IDP) za koji se dobavlja deo sa najnižom cenom.
*/
select distinct n.idp
from nabavka n join deo d
on n.iddeo = d.iddeo
where d.cena = (select min(cena) from deo);

/*
3.  Prikazati podatke o delovima (IDDEO, NAZDEO) koje dobavlja dobavljač sa nazivom Kurir. 
*/
select d.iddeo, d.nazdeo 'Naziv dela'
from deo d join nabavka n
on d.iddeo = n.iddeo join dobavljac dob
on n.idd = dob.idd
where dob.nazd = 'Kurir';

/*
4.  Za delove koji su nabavljani prikazati IDDEO, NAZDEO i koliko su puta ukupno nabavljeni. 
Prikazati samo one čiji je ukupni broj puta veći od 2. 
*/
select d.iddeo, d.nazdeo 'Naziv dela', count(n.idd) 'Broj Nabavki'
from deo d
left join nabavka n
on d.iddeo = n.iddeo
group by d.iddeo, d.nazdeo
having count(n.idd) > 2;

/*
5. Kreirati pogled PogledDeo koji će za svaki postojeći projekat prikazati (idp, nazp) 
kao i ukupnu količinu svih delova koji su nabavljeni za taj projekat, bez obzira na vrstu delova.  
*/
create or replace view Pogled_Deo(id_projekta, Naziv_projekta, ukupno_delova) as
select p.idp, p.nazp, sum(n.kol) -- ili sa ifnull: ifnull(sum(n.kol), 0)
from projekti p left join nabavka n
on p.idp = n.idp
group by p.idp, p.nazp;

/*
6.  Povećati cenu svih delova za 200 din. Za delove koji nisu imali cenu staviti da je početna cena = 0.   
*/
update deo
set cena = ifnull(cena, 0) + 200;