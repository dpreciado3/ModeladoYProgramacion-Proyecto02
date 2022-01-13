SOFTWARE DEV TYCOON
====================
Implementación de patrones Observer, Iterator, Builder, Strategy y MVC.
------------------
### Nombres
- Brito Juárez Britny 421074668
- David Salvador Preciado Márquez 421091670

### Problemática
Imagina esto: eres un graduado de la licenciatura en ciencias de la computación de la UNAM, con toda una vida profesional por delante. Con tu frente en alto, decides aceptar la primer oferta de empleo que recibes de una empresa de desarrollo de software llamada “Cheemsoft”. Para tu sorpresa, desde el primer día de trabajo ya tienen un proyecto designado para ti.

El jefe, Cheemsberto, te explica que desde hace varios años la empresa tiene problemas con su gestión de proyectos (en parte su culpa, piensas tú, pero decides no gastar saliva). En repetidas ocasiones les ha ocurrido que tienen claros los requerimientos de un cliente, pero no tienen idea de qué patrones de diseño son apropiados para cubrirlos. Por esto, desperdician mucho tiempo y recursos implementando cosas que al final no utilizan. Esto ha dirigido a la empresa en un camino que muy seguramente la llevará a la quiebra. Cheemsberto te explica que como última instancia recurrió a contratar un empleado recién graduado que pudiera traer ideas frescas a la empresa.

Mientras te gritas internamente por haber aceptado la primer oferta que encontraste y haces planes para renunciar, el jefe te explica lo que requiere de ti. Con la finalidad de poder anticipar estos escenarios de desarrollo fallido y así poder planear mejor los proyectos futuros, Cheemsberto quiere un sistema que tenga la capacidad de simular a su misma empresa, sin el riesgo financiero que implica tomar decisiones sobre esta.

Ignorando tu expresión cada vez más preocupada, Cheemsberto continúa con su descripción:

- Desea poder recibir requisitos de clientes dentro de la simulación y poder decidir sobre qué organización llevará el proyecto de desarrollo; esto es, qué patrones de diseño aprovechará, qué entornos de desarrollo usará, etc.
- Desea que estas decisiones tengan impacto sobre el desempeño financiero de la empresa simulada, y que de acuerdo con las finanzas se vean limitadas (o ampliadas) las opciones a las que tenga acceso la misma. 
- Espera que exista una variedad de clientes y de proyectos sobre los cuales avance la simulación.
- Le gustaría ver que los clientes simulados ofrezcan algún tipo de retroalimentación sobre sus proyectos finalizados, y que estas mismas críticas tengan algún efecto en las finanzas de la empresa. De preferencia, estas críticas deberían guiarlo en su camino a hacer mejores proyectos dentro de la simulación.
- Desea que la simulación tenga algún tipo de progresión en la que la empresa empiece muy pequeña y tenga la oportunidad de crecer a un gran corporativo. Relacionado con esto, habrá algún tipo de meta u objetivo final.
- Prefiere que exista cierto riesgo en la simulación de que la empresa se vaya a la quiebra, pero que siempre exista la posibilidad de reiniciar la simulación desde cero si esto ocurre (o si lo decide en cualquier otro momento).

Cheemsberto te explica que en principio quiere este sistema para mejorar sus habilidades gerenciales, pero que no descarta la posibilidad de publicarlo como un videojuego si logras cumplir con todos sus requisitos (y si resulta ser divertido). En ese caso, te compartiría parte de las ganancias. En parte por lástima y en parte por tu necesidad de ingresar dinero a tu cuenta bancaria, decides aceptar el reto de desarrollar este sistema. Tú puedes ;)


### Descripción y justificación de patrones
- Observer

    Se implementó este patrón por la relación que guardan los controladores con el modelo. Lo aprovechamos para actualizar
    los controladores con datos del modelo, y así estos puedan trabajar sus algoritmos con la información más actual.
    Así, registramos los controladores como observadores y el modelo como sujeto, lo cual nos abre la posibilidad de
    agregar más controladores en un futuro y sencillamente registrarlos como observadores. Las clases que corresponden
    a controladores y modelo son parte de este patrón, así como las interfaces que estos implementan.
    
- Iterator

    Decidimos aprovechar este patrón como auxiliar en la evaluación de los patrones escogidos por el jugador. En la clase
    "Patrones" podemos guardar listas que guarden un cierto conjunto de patrones de acuerdo con categorías que decida
    el diseñador del juego, y el resto de clases solo pueden obtener estas clasificaciones con los iteradores de estas listas.
    Así, ninguna otra clase puede acceder a las listas en sí y por lo tanto no se pueden modificar estas categorías fuera de
    la clase Patrones, lo cuál consideramos que es deseable en un aspecto tan apegado a la jugabilidad como lo es la evaluación.
    Además, la integración de este patrón facilita la integración de nuevas categorías en un futuro, simplemente se tendrían 
    que agregar listas a la clase Patrones y no se tendrían que modificar las clases correspondientes a los patrones.
    
- Builder

    Este patrón se escogió porque los objetos de la clase Proyecto se pueden ver como composiciones de distintos
    otros objetos más simples, lo cual corresponde directamente con la definición del patrón. La implementación
    de este patrón facilita añadir nuevos proyectos para el juego, simplemente se tienen que agregar en la clase
    ConstructorProyectos, que es la clase que aprovecha este patrón.
    
- Strategy

    Se decidió implementar este patrón para simular los distintos "niveles" de dificultad por los que pasa el jugador
    a lo largo del juego. En estos niveles se tienen distintas opciones y además distintas consecuencias sobre la partida, 
    por lo que nos pareció natural que cada nivel representara una estrategia con la cual se desarrolla el juego. Las clases
    que integran a este patrón son la clase ModeloPartida, la clase Nivel y aquellas que la extienden. Este patrón nos 
    facilita agregar más niveles en un futuro, solo se tendrían que escribir clases que extiendan a la clase abstracta Nivel.
    El cambio de nivel se maneja desde el controlador del modelo.
    
- MVC

    Todo el sistema esta compuesto siguiendo las pautas del patrón MVC. Las clases que inician con "Vista" se encargan
    de todo el aspecto gráfico con el que interactúa el usuario. Con el apoyo de la paquetería Swing, creamos una interfaz
    gráfica que puede imprimir y recibir entradas en la estructura visual determinada por las clases Vista. Las clases que
    inician con "Controlador" se encargan de manejar cada una de estas vistas, dándole formato a sus contenidos y procesando
    las entradas del jugador. Como tercer y último componente, el resto de clases (utilizadas todas en ModeloPartida) nos
    proporcionan una base de datos sobre la cual registrar el progreso de la partida y también se encargan de la lógica más 
    básica del juego, por ejemplo, la implementación de ciertos patrones de diseño que manejan la estructura de todo el Modelo.
    En conjunto, este patrón nos permite separar los aspectos visuales del juego, los aspectos lógicos y la información
    de la partida. Esto permite un mantenimiento más sencillo y abre las oportunidad de crecimiento a futuro.

### Para ejecutar el programa
Para poder ejecutar y compilar el programa basta con ejecutar desde la consola, en el directorio /src, los siguientes comandos:
```
$ javac SoftwareDevTycoon.java
...
$ java SoftwareDevTycoon
```
Al ingresar eso en consola se abrirá una ventana con tres recuadros: uno corresponde al estatus de tu empresa en el juego, uno corresponde a la retroalimentación principal que tendrá el juego contigo, y otro corresponde a una caja de texto en la cual podrás ingresar tus elecciones. Por favor lee con atención las instrucciones del juego e ingresa solamente lo que se te pide. Solo se puede interactuar con la caja de texto, los otros dos recuadros son únicamente de lectura.

### Para mirar la documentación
Para poder crear la documentación con JavaDoc se ejecuta desde la consola, en el directorio /src, el siguiente comando:
```
$ javadoc *.java
```
