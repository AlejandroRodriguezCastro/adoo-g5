
#Trabajo Práctico: **Arnold Fitness Center**

##Condiciones generales

- Se conformarán grupos de, como máximo, 5 personas.
- Se debe entregar un único documento PDF con todas las consignas solicitadas (por cada entrega). El mismo deberá contener la carátula con el nombre, apellido y LU de los integrantes del equipo.
- Fechas de entregas:
  - Primera entrega: **04 de Octubre**
  - Entrega final: **15 de Noviembre**
- En los días de entrega se debe exponer la solución propuesta.

##Contexto general

**Arnold Fitness Center** es una cadena de gimnasios muy conocida en todo el país. En esta ocasión nos han contratado para desarrollar un sistema para que los clientes usen mientras hacen su actividad física en los establecimientos. Lo van a llamar **GymPal**; y la finalidad de esta app es dar un detallado seguimiento del entrenamiento al socio, así como también incrementar la motivación del mismo a través del otorgamiento de distintos trofeos por cada logro obtenido.

Los socios de **Arnold** tendrán acceso al sistema y de cada uno nos interesa saber la edad, sexo biológico, peso, altura y la objetivo principal por la cual está entrenando. Actualmente los objetivos definidos son tres y de éstos dependen los entrenamientos y rutinas que la aplicación va a generar para el socio.

Los objetivos disponibles son:

- **Bajar de peso**: los días de entrenamiento siempre serán de entre 1 a 1 hora y media. Los ejercicios que se tendrán en cuenta serán todos aquellos cuyo nivel aeróbico sean >=3. El sistema deberá calcular el peso ideal al que debe llegar el usuario teniendo en cuenta su peso inicial, altura y sexo. Se considera que este objetivo se cumple cuando se llega al peso ideal. Luego de cumplir este objetivo, la app propondrá realizar un cambio del mismo a “mantener la figura” (ver más abajo).
- **Tonificar cuerpo**: los días de entrenamiento siempre serán de entre 2 a 2 horas y media. Se tendrán en cuenta todos aquellos ejercicios que **NO** sean tan aeróbicos (nivel aeróbico <=4) y que sean considerados fuertes en ejercitación muscular. Este objetivo comienza a cumplirse desde que se logra llegar al nivel ideal de masa muscular y porcentaje de grasa corporal según la altura, peso y sexo (un sistema externo se encargará de brindarnos estos valores ideales). Una vez que se comienza a cumplir el objetivo, la app podrá sugerir optar por “mantener la figura” (ver más abajo).
- **Mantener la figura**: los días de entrenamiento serán de entre 45 minutos a 1 hora y 20. Los ejercicios que se tendrán en cuenta son aquellos cuyo nivel aeróbico oscile entre 2 y 4 y que además tengan un nivel medio-bajo de ejercitación muscular. Este objetivo se cumple si el peso oscila entre +-N unidades en comparación con el peso inicial (siendo N un valor configurable).

Teniendo en cuenta el objetivo principal elegido por el usuario y los días de entrenamiento establecidos, se generará una **rutina** para el socio. Cada rutina tendrá una duración de 4 semanas.

La rutina se armará en base a diferentes entrenamientos, los cuales consiste en una serie de ejercicios combinados de acuerdo al tipo de músculo que trabajen. Existen 5 grandes grupos musculares; y por cada uno de ellos, se conocen los distintos tipos de ejercicios disponibles. Los grupos musculares son: **pecho**, **espalda**, **hombros**, **piernas** y **brazos**. Un día de entrenamiento debe agrupar ejercicios que se combinen. De cada ejercicios se conoce la cantidad de series, repeticiones y peso asignado. Asimismo, cada ejercicio dispone del nivel aeróbico (un valor entero entre 1 y 10) y el nivel de exigencia muscular (bajo, medio, alto) utilizado para la asignación de las rutinas en base al objetivo elegido por el socio.

Los socios podrán pesarse utilizando las balanzas que se encuentran en los vestuarios de los establecimientos, así como también dejar registro de su masa muscular y porcentaje de grasa corporal. Estas mediciones se tendrán en cuenta para ver si se está cumpliendo con el objetivo principal y permitir realizar el **refuerzo** de la rutina.

Cuando se **refuerza** una rutina, se cambian los valores de las repeticiones, series o peso asignado para cada ejercicio. Es muy importante que cada socio pueda ver su progreso, ya que esto lo ayudará a tomar mejores decisiones a la hora de entrenar.

Cada vez que un socio acceda a un establecimiento deberá seleccionar la opción de “Comenzar entrenamiento del día”. La aplicación mostrará al socio todos los ejercicios que tiene que hacer ese día, junto con las series, repeticiones y peso asignado por cada uno, así como también un video ilustrativo de cómo hacer bien el ejercicio. El socio podrá ingresar a cada ejercicio para registrar la cantidad de series, repeticiones y peso levantado; y finalmente marcar el mismo como completado. El sistema deberá ir guardando registro de todos los ejercicios del día que se cumplieron junto con los valores (series, repeticiones y peso).

Por otra parte, la aplicación pretende cumplir con el concepto de **gamification** para motivar a los socios a cumplir sus objetivos. Por este motivo es que se otorgan los siguientes trofeos:

- **Trofeo a la dedicación**: se otorga este trofeo a aquellos socios que cumplen con su objetivo.
- **Trofeo a la constancia**: se otorga este trofeo a aquellos socios que cumplen a la perfección con las rutinas. Una rutina se cumple a la perfección cuando se asisten todos los días de entrenamientos y se realizan todos los ejercicios, sin importar la cantidad de series y repeticiones que el usuario haya realizado.
- **Trofeo al creído**: se otorga este trofeo a quien se pese más de 3 veces al mes.

Cuando se logre un trofeo, la app enviará una push notification al socio. Para ello, se utilizará el servicio de Firebase. 

Además, cabe destacar que:

- El Servicio de Login y Autenticación es externo a la plataforma.
- El pesaje, la medición de la masa muscular y la grasa corporal no son parte del sistema. Sin embargo, debe quedar correctamente comunicado en su diseño como interactúa con estos componentes o sistemas externos.

##Consignas

- Primera entrega
  - Realizar una iteración inicial del diagrama de clases del sistema, detallando, solamente, las clases de la capa de dominio.
- Entrega final
  - Realizar el diagrama de clases del sistema, detallando, solamente, las clases de la capa de dominio.
  - Justificar utilización de patrones de diseño en el caso que se hayan utilizado.
  - Implementar el diagrama de clases propuesto en Java, mostrando el correcto funcionamiento de los requerimientos principales a través de Tests Unitarios.

