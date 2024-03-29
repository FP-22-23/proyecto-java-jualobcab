# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Juan José Lobo Cabeza   uvus:jualobcab

En este proyecto voy a trabajar con un dataset de canciones de Spotify publicadas entre 1999 y el 2010.

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.Canciones**: Paquete que contiene los tipos del proyecto.
  * **fp.TestCanciones**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **TopCanciones2000.csv**: Archivo csv que contiene datos de diferentes canciones.
    
## Estructura del *dataset*

El dataset original "Spotify Past Decades Songs Attributes" se puede obtener de la URL [https://www.kaggle.com/datasets/cnic92/spotify-past-decades-songs-50s10s?select=2000.csv](https://www.kaggle.com/datasets/cnic92/spotify-past-decades-songs-50s10s?select=2000.csv). Originalmente tiene 15 columnas y cada fila contiene datos sobre una cancion publicada entre 1999 y 2010 en Spotify. El dataset usado en este proyecto tiene 15 columna, 6 se han tomado del dataset original, y 9, el mes, dia, los 3 posibles generos musicales, el pais, la valoracion, si tiene o no premio y las reproducciones, se han generado de forma aleatoria. A continuación se describen las 15 columnas del dataset:

* **title**: de tipo cadena,  indica el titulo de la cancion.
* **artist**: de tipo cadena, indica el nombre del autor o grupo de la cancion.
* **country**: de tipo cadena, indica el pais de procedencia del artista o grupo.
* **genre1, genre2, genre3**:las tres columnas son de tipo cadena, contiene el genero musical de la cancion o nada en caso de que no corresponda.
* **date**: de tipo LocalDate, que indica el año, mes y dia que se subió esa cancion.
* **time**: de tipo LocalTime, que indica la hora a la que se subió la canción.
* **bpm**: de tipo entero, contiene el numero de beats por minuto de la cancion.
* **dur**: de tipo entero, indica la duracion en segundos de la cancion. 
* **score**: de tipo double, indica la valoracion que obtuvo la cancion.
* **award**: de tipo entero, contiene un 0 si la cancion no obtuvo un premio y 1 si la cancion obtuvo premio, se parseara para que sea tipo boolean.
* **reproduction**: de tipo entero, indica el numero de reproducciones de la cancion.
* **pop**: de tipo entero, indica la popularidad, se parseara para ser tipo enum.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Canciones
Representa una cancion y sus datos.
**Propiedades**:

- _data_, de tipo _Data_, consultable. Es una propiedad de tipo auxiliar creada, que indica el titulo, autor y pais. 
- _genres_, de tipo _List<String>_, consultable. Indica los generos musicales de la cancion.
- _date_, de tipo _LocalDate_, consultable. Indica la fecha en la que salio la cancion.
- _time_, de tipo _LocalTime_, consultable. Indica la hora a la que salió la cancion.
- _bpm_, de tipo _Integer_, consultable. Contiene el numero de beats por minuto.
- _duration_, de tipo _Integer_, consultable. Indica la duracion en segundos de la cancion.
- _score_, de tipo _Double_, consultable. Indica la valoracion de la cancion.
- _award_, de tipo _Boolean_, consultable. Indica si la cancin tiene o no premio.
- _reproductions_, de tipo _Integer_, consultable. Indica el numero de veces que se ha reproducido la cancion.
- _popularity_, de tipo _Popularity_, consultable. Indica el nivel de popularidad, puede tomar los valores POCO_POPULAR,POPULAR,MUY_POPULAR o TOP_HITS.



**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Partida``` a partir de los siguientes parámetros: ```Data data, LocalDate date, Integer duration, Double score, Boolean award, Integer reproductions```.

**Restricciones**:
 
- R1: La fecha de publicacion debe estar comprendida entre 1999 y 2010.
- R2: La duracion de la cancion debe ser positiva.
- R3: Las reproducciones debe ser positiva.

***Criterio de igualdad**: Dos canciones son iguales si sus "data" y duraciones son iguales.

**Criterio de ordenación**: Por fecha, duración y valoracion.

**Otras operaciones**:

- _Integer beatsTotales()_: Devuelve el numero de beats totales de la cancion.

#### Tipos auxiliares

- Data, (String, String, String). El que contiene titulo, autor y pais de la canción.

#### Factoria
Clase de factoría para construir objetos de tipo Cancion.

* **leeCanciones**(String rutaFichero): Crea un objeto de tipo List a partir de la informacionrecogida del archivo csv, cuya ruta se da como parámetro.
* **parseaCanciones**(String lineaCSV): Parsea cada linea del fichero para recopilarla como tipo Cancion.

#### Tipo Contenedor (Canciones)
Clase contenedora de objetos de tipo Cancion.

**Propiedades**
* listaCanciones: de tipo List, consultable. Lista de las canciones.

**Constructores**
* C1: Crea un objeto de tipo Canciones sin ninguna cancion almacenada.
* C2: Crea un objeto de tipo Canciones(List listaCanciones).
* C3: Crea un objeto de tipo Canciones(Stream listaCanciones).

**Criterio de igualdad**
* Dos canciones son iguales si lo son sus propiedades.

**Otras operaciones**
* _existeCancion(String title)_: Devuelve una respuesta de tipo Boolean dependiendo si el titulo de la cancion pasado como parametro existe en la lista de todos las canciones.
* _mediaBPM()_: Devuelve un valor Double que es la media de beats por minuto de las canciones del dataset.
* _cancionesDeUnGenero(String genero):_ Devuelve una List en la que estan las canciones que tienen el genero introducido como parámetro.
* _cancionesPorAño():_ Devuelve un Map en el que la clave es el año en el que se publicó una cancion y el valor asociado son las canciones que se publicaron en ese año.
* _mapCancionesPorPaises():_ Devuelve un Map que tiene como claves cada pais del dataset, los cuales tienen asociados como valor el numero de canciones que se publicaron de ese pais.

 --> Metodos con Stream <--
* _existeCancion2(String title)_: Devuelve una respuesta de tipo Boolean dependiendo si el titulo de la cancion pasado como parametro existe en la lista de todos las canciones.
* _mediaBPM2()_: Devuelve un valor Double que es la media de beats por minuto de las canciones del dataset.
* _cancionesDeUnGenero2(String genero):_ Devuelve una List en la que estan las canciones que tienen el genero introducido como parámetro.
* _cancionPremiadaMasReproducciones(Boolean award)_: Devuelve la cancion premiada con mas reproducciones.
* _cancionesTopHitsOrdenadas(Popularity pop)_: Devuelve una lista de canciones con la popularidad "pop" ordenada de menor a mayor valoracion.
* _mapCancionesPorAño2()_: Devuelve un map con años como clave, los cuales tienen asociadas las canciones publicadas ese año.
* _mapArtistasPorPais()_: Devuelve un map con los paises como clave, los cuales tienen asociadas los artistas de ese pais.
* _mapCancionMaxValoracionPorPais()_: Devuelve un map con el pais como clave y como valor la cancion con mas valoracion.
* _mejoresCancionesPorAutor()_: Devuelve un map con el nombre del artista como clave y como valor sus 2 canciones mejor valoradas
* _getArtistaMejorValorado()_: Devuelve el nombre del artista con la mejor valoracion media.
