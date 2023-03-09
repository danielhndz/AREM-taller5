# :hammer_and_wrench: Modularización, Virtualización, Docker, AWS

## Arquitecturas Empresariales

### :pushpin: Daniel Felipe Hernández Mancipe

<br/>

En este proyecto se profundizan los conceptos de modulación por medio de virtualización usando Docker y AWS. Se construye una aplicación con la arquitectura propuesta y se despliega en AWS usando EC2 y Docker.

![statement](../media/statement.png?raw=true)

1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2.
2. [LogService](/log-service/src/main/java/edu/escuelaing/arem/Launcher.java) es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
3. La aplicación web [APP-LB-RoundRobin](/round-robin-load-balancer/src/main/java/edu/escuelaing/arem/Launcher.java.java) está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio [LogService](/log-service/src/main/java/edu/escuelaing/arem/Launcher.java).

## Getting Started

### Prerequisites

- Java >= 11.x
- Maven >= 3.x
- Git >= 2.x
- JUnit 4.x

### Installing

Simplemente clone el repositorio:

```bash
git clone https://github.com/danielhndz/AREM-taller5.git
```

Luego compile los dos subproyectos con maven, `Log Service` y `Round-Robin Load Balancer`:

```bash
cd <project-folder>
mvn compile
```

En el readme de cada subproyecto se muestra un ejemplo de una salida exitosa.

### Using

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Git](https://git-scm.com/) - Version Management
- [JUnit4](https://junit.org/junit4/) - Unit testing framework for Java

## Design Metaphor

- Autor: Daniel Hernández
- Última modificación: 09/03/2023

## Authors

- **Daniel Hernández** - _Initial work_ - [danielhndz](https://github.com/danielhndz)

## License

This project is licensed under the GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details

## Javadoc

Para generar Javadocs independientes para el proyecto en la carpeta `/target/site/apidocs` ejecute:

```bash
mvn javadoc:javadoc
```
