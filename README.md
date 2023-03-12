# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Juan José Lobo Cabeza   uvus:jualobcab

En este proyecto voy a trabajar con un dataset de canciones de Spotify publicadas entre 1999 y el 2010.

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.CAnciones**: Paquete que contiene los tipos del proyecto.
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
* **year, month, day**: las 3 columnas son de tipo entero, que indican el año, mes y dia que se subió esa cancion.
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

- Popularity, enumerado. Puede tomar los valores POCO_POPULAR,POPULAR,MUY_POPULAR o TOP_HITS.



