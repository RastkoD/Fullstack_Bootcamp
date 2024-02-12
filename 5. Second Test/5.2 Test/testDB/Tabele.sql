CREATE TABLE Dobavljac(
	 IDD integer NOT NULL,
	 NAZD varchar(30) NOT NULL,
	 MESD varchar(30) NOT NULL,     	 
	 CONSTRAINT Dobavljac_PK PRIMARY KEY (IDD)	      	 
);

CREATE TABLE Projekti(
	 IDP varchar(20) NOT NULL,
	 NAZP varchar(30) NOT NULL,
	 MESP varchar(30) NOT NULL,     	 
	 CONSTRAINT Projekti_PK PRIMARY KEY (IDP)	      	 
);

CREATE TABLE Deo(
	 IDDEO varchar(10) NOT NULL,
	 NAZDEO varchar(25) NOT NULL,	
         CENA integer,
	 CONSTRAINT Deo_PK PRIMARY KEY (IDDEO)	      	 
);

CREATE TABLE Nabavka
	(
	 IDD integer NOT NULL,	 
	 IDP varchar(20) NOT NULL,
         IDDEO varchar(10) NOT NULL,
         KOL integer NOT NULL,
	 CONSTRAINT Nabavka_PK PRIMARY KEY (IDD, IDDEO, IDP),
	 CONSTRAINT Nabavka_Deo_FK FOREIGN KEY (IDDEO) REFERENCES Deo(IDDEO),
	 CONSTRAINT Nabavka_Dob_FK FOREIGN KEY (IDD) REFERENCES Dobavljac(IDD),
         CONSTRAINT Nabavka_Prj_FK FOREIGN KEY (IDP) REFERENCES Projekti(IDP)
);
