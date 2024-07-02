package com.iktpreobuka.dataaccess.repositories;

import com.iktpreobuka.dataaccess.entities.UserEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/* omogucava metode koje ima CrudRepository(sloj koje ce koristiti pisanju upita ka bazi)
   kroz CrudRepo se obracamo, putem odgovarajuce metode za dobavljanje Entiteta odnosno reda(torke)
   za uspisivanje torke, modifikaciju, brisanje, dobavljanje svih torki(findAll - *)
   a ti pises dodatne custom metode - endpointe
   !Sve sto se tice obracanja bazi podataka se pise ovde!
   Repositorijum sluzi da app moze da uradi konkretnu akciju s nekim podatkom u bazi - logika*/
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	/* imas ugradjene default upite */

	List<UserEntity> findByEmail(String email);

	List<UserEntity> findByNameOrderByEmailAsc(String name);

	List<UserEntity> findByDateOfBirthOrderByNameAsc(Date dateOfBirth);

	List<UserEntity> findDistinctByNameStartingWithIgnoreCase(char firstLetter);
}