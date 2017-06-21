DROP TABLE Historia;
DROP TABLE Rejestracja;
DROP TABLE Samochod;

CREATE TABLE Samochod(
	IdSamochod NUMBER(8),
	Marka VARCHAR2(30),
	Model VARCHAR2(30),
	Pojemnosc Varchar2(5),
	Moc Varchar2(4),
	Rokprodukcji Varchar2(4),
	Paliwo VARCHAR2(7),
	CONSTRAINT paliwo_check CHECK (Paliwo IN ('benzyna', 'gaz', 'hybryda', 'diesel')),
	CONSTRAINT samochod_pk PRIMARY KEY (IdSamochod)
);

CREATE TABLE Rejestracja(
	IdRejestracja NUMBER(10),
	IdSamochod NUMBER(8),
	Numer_rejestrcji VARCHAR2(10)
	CONSTRAINT samochod_rejestracja_fk FOREIGN KEY (IdSamochod) REFERENCES Samochod(IdSamochod),
	CONSTRAINT rejestracja_pk PRIMARY KEY (IdRejestracja)
);

CREATE TABLE Historia(
	IdHistoria NUMBER(10),
	IdRejestracja NUMBER(8),
	Przebieg NUMBER(10),
	Spalanie NUMBER(4,2),
	Przeglad VARCHAR2(3),
	WymianaOleju VARCHAR2(3),
	WymianaRozrzadu VARCHAR2(3),
	CONSTRAINT rejestracja_historia_fk FOREIGN KEY (IdRejestracja) REFERENCES Rejestracja(IdRejestracja),
	CONSTRAINT historia_pk PRIMARY KEY (IdHistoria)
);
