# **Descripción:**

Este framework implementa el enfoque BDD (Behavior Driven Development) mediante Cucumber, permitiendo que los escenarios estén escritos en lenguaje Gherkin.
La ejecución de casos de prueba se realizan tanto con TestNG como con Cucumber y el motor de automatización es Selenium WebDriver.
Incluye integración con reportes gráficos y detallados mediante:

* Cucumber Reports (por defecto)
* Extent Reports

Su objetivo es ser escalable, mantenible y fácil de extender.


# **Pre-requisitos**
Asegúrate de tener instalado:

✔️ Java 11 o superior
✔️ Maven 3+
✔️ Git
✔️ Un navegador soportado (Chrome, Edge, Firefox)
✔️ IDE recomendado: IntelliJ IDEA o Eclipse


# **Instalacion**

Descargar el repositorio desde github:\
`git clone https://github.com/bukiman/SeleniumFramework.git`

Ingresar al repositorio:\
`cd SeleniumFramework`

Instalar las dependencias:\
`mvn clean install`


# **Ejecución de Pruebas**

1. Ejecutar todas las pruebas con Maven\
   `mvn clean test`


2. Ejecutar una suite TestNG específica\
   `mvn clean test -DsuiteXmlFile=testng.xml`


3. Ejecutar escenarios por tag de Cucumber\
   `mvn test -Dcucumber.filter.tags="@Regression"`