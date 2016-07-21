# Servicios REST, Spring MVC, AngularJS más Spring Boot 


# Índice de contenidos.
1. Introducción.
2. Entorno.
3. Configuración del proyecto
4. Servicios REST con Spring MVC
5. Junit -> 4.11
6. Conclusiones.

## 1. Introducción.

Dervicios REST con Spring MVC consumidos  desde una aplicación en AngularJS. 

implementar los recursos REST con Spring MVC. 
su consumo a través de una aplicación hecha en AngularJS o a través de un cliente REST</p>
Se define un API genérico para simular servicios REST con entidades de negocio genérica



## 2. Entorno.

El tutorial se ha realizado con el siguiente entorno:

<li>Oracle Java SDK 1.7.0_60</li>
<li>Spring Boot 1.1.10.RELEASE</li>
<li>Spring MVC 4.0.8.RELEASE</li>
<li>AngularJS 1.2.21</li>


## 3. Configuración del proyecto.
mvn clean install
mvn spring-boot:run -o
mvn -Dtest=FacturasControllerTest test 
curl -XGET http://127.0.0.1:8080/facturas/


## 4. Servicios REST con Spring MVC. Angular, JUnit,Postman, Simulador genérico

http://127.0.0.1:8080/ ->
http://127.0.0.1:8080/facturacion->
http://127.0.0.1:8080/facturas
http://127.0.0.1:8080//facturas/ultima
http://127.0.0.1:8080/prueba
http://127.0.0.1:8080/films

[{"title":"12 years a slave","year":2013,"director":"Steve McQueen"},{"title":"Argo","year":2012,"director":"Ben Affleck"},{"title":"The Artist","year":2011,"director":"Michel Hazanavicius"},{"title":"The King's speech","year":2010,"director":"Tom Hooper"},{"title":"The Hurt Locker","year":2009,"director":"Kathryn Bigelow"},{"title":"Slumdog Millionaire","year":2008,"director":"Danny Boyle"},{"title":"No Country for Old Men","year":2007,"director":"Joel y Ethan Coen"}]



## 4. Junit 4

## Ejecutar la clase
  
@BeforeClass - oneTimeSetUp
@Before - setUp
@Test - testOneItemCollection
@After - tearDown
@Before - setUp
@Test - testEmptyCollection
@After - tearDown
@AfterClass - oneTimeTearDown
Picked up _JAVA_OPTIONS: -Djava.net.preferIPv4Stack=true


