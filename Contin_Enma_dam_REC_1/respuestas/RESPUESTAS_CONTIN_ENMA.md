
PREGUNTA 1

Explica cómo funciona la relación 1:N entre CentroForense y MuestraForense tanto en SQL como en Java.

La relacion 1:N significa que en un centro forense puede haber muchisimas muestras, pero 1 muestra solo puede estar en un centro forense al mismo tiempo

PREGUNTA 2

Explica por qué en Java utilizamos:

private CentroForense centro;

y no:

private int centroId;

porque en java trabajamos con objetosy no con claves relacionales como en SQL que nos sirve para relacionar las tablas, asi que hacemos referencia en java al objeto directamente.

PREGUNTA 3

Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.
 Mayor seguridad, principal ventaja ya que si concatenamos manualmente el codigo un usuario podría introducir texto que altere la consulta original. Mantenibilidad y legilibilidad: concatenar consultas largas llenas de variables, con caracteres raros y neutralizando los ataques.
