INSERT INTO CentroForense (id, nombre, pais, nivelSeguridad,AutorExamen) VALUES(
(1,"Centro Grasa", "España", 3, "Enma Contin"),
(2,"Centro Ausit", "Austria", 4, "Enma Contin"),
(1,"Centro Houfter", "Alemania", 5, "Enma Contin"),
(1,"Centro Unity", "UK", 2, "Enma Contin"),
(1,"Centro LikeU", "Irlanda", 3, "Enma Contin");


INSERT INTO MuestraForense(id,codigoCaso, tipoMuestra, estadoCustodia, fk_centro_id,autorExamen) VALUES
(1, 1, "orina", "en laboratorios", 1, "Enma Contin"),
(1, 2, "heces", "en laboratorios", 2, "Enma Contin"),
(1, 3, "sangre", "entregado", 3, "Enma Contin"),
(1, 4, "heces", "en laboratorios", 4, "Enma Contin"),
(1, 5, "orina", "analizando muestra", 5, "Enma Contin");


INSERT INTO InformeForense(id, adnPositivo, nivelRiesgo, conclusion,, fk_muestra_id, autorExamen) VALUES
(1,"true", 5, "covid19", 1, "Enma Contin"),
(1,"false", 3, "Crohn", 2, "Enma Contin"),
(1,"false", 2, "sin diagnostico", 3, "Enma Contin"),
(1,"false", 2, "sin diagnostico", 4, "Enma Contin"),
(1,"true", 3, "infeccion orina", 5, "Enma Contin"),



