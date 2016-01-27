Creación de servicios web CXF con Grails 3.0.X
=======

Este proyecto consiste en probar la creación de servicios web usando [Apache CXF](http://cxf.apache.org/) y [Grails 3.0.X](https://grails.org/).

Además usaremos una política contract-first, por lo que se partirá de un fichero wsdl con la descripción del servicio para generar el código fuente del mismo.

Requisitos previos
======

Tener instalado y configurado en el equipo de desarrollo:
* JDK 1.7 o superior
* Grails 3.0.X
* Apache CXF 3.1.4 o superior

Generación del código a partir de un fichero wsdl
=====

Usaremos una política contract-first para la generación del código fuente del cliente, lo que significa que partiremos de un fichero wsdl, que contendrá las especificaciones del servicio web, para generar el código Java que cumpla con dichas especificaciones.

Para ello usaremos la herramienta wsdl2java que se distribuye con los binarios de Apache CXF. Este comando se ejecutará con los siguientes parámetros:
RUTA_APACHE_CXF\bin>wsdl2java -d <DIRECTORIO_SALIDA> -p <PAQUETE> <URL_WSDL>

-d sirve para indicar el directorio donde se generará el código fuente.
-p indica el paquete del que colgarán las clases generadas.
El último parámetro se utiliza para indicar la ubicación del fichero wsdl, que puede ser una ruta local o una dirección web.

Por ejemplo, para crear el código del servicio dentro del paquete **es.franl2p**, en el directorio **C:\Grails\workspace\grailsCxf\src\main\groovy** a partir del fichero **C:\Grails\workspace\grailsCxf\src\main\groovy\ProductosServices.wsdl** usaremos el siguiente comando:
C:\Software\Java\apache-cxf-3.1.4\bin>wsdl2java -d C:\Grails\workspace\grailsCxf\src\main\groovy -p es.franl2p C:\Grails\workspace\grailsCxf\src\main\groovy\ProductosServices.wsdl

Creación del Endpoint
=====
Para crear los endpoints encargados de procesar las peticiones sl servicio web bastará con crear unos servicios en Grails, usando el comando de grails create-service, y añadiéndole a la clase del servicio la siguiente anotación: @GrailsCxfEndpoint.

Finalmente habrá que añadir a cada uno de los métodos que se expongan de la clase las siguientes anotaciones: @WebMethod y @WebResult.

Probar el servicio web
=====
Podremos comprobar qué servicios está levantados accediendo desde cualquier navegador a la siguiente URL : http://localhost:8080/services

Esta página mostrará los servicios web publicados por nuestra aplicación y podremos descargarnos el fichero wsdl de cada servicio para poder invocarlos desde otra aplicación, por ejemplo SoapUI.
