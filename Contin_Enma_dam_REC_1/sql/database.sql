CREATE TABLE CentroForense(
id serial PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
pais VARCHAR(50) NOT NULL,
nivelSegurirad INTEGER(2),
AutorExamen VARCHAR(150) NOT NULL
);

CREATE TABLE MuestraForense(
id serial primary KEY,
codigoCaso INTEGER(5),
tipoMuestra VARCHAR(50) not NULL,
estadoCustodia VARCHAR(50) not null,
fk_centro_id INTEGER not null,
autorExamen VARCHAR(150) not null,
CONSTRAINT fk_centro_forense FOREIGN KEY (fk_centro_id) REFERENCES CentroForense(id)
);

create table InformeForense(
id serial primary key,
adnPositivo BOOLEAN,
nivelRiesgo INTEGER,
conclusion VARCHAR(200),
fk_muestra_id INTEGER not null unique,
autorExamen VARCHAR(150) not null,
constraint fk_muestra_forense foreign key (fk_muestra_id) references MuestraForense(id)
);