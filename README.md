# ShopsRUs Code Challenge
by: Johnny Ramos

## Installation
ShopsRUs requires JavaSE 11 to run.

Download, install and open Intellij IDEA

In the window, select "Open" option. Find the project path, select build.gradle and "OK" button. Finally, select "Open as a project" option.

To run the project correctly, it's necessary to install a plugin called MapStruct Support.

For this task, select File->Settings->Plugins. Then, in the settings icon, select "Install Plugin from Disk". Find and select "MapStruct-Intellij-Plugin-1.2.4.zip".

For the database, open your PostgreSQL UI and create a database. Then, run the SQL files in the project directory. First, you need to run the file named "schema.sql". After that, run "data.sql".

Finally, find the file named "application.properties" in the Intellij project and edit the database variables with this struct:

```
spring.datasource.url=jdbc:postgresql://{HOST}:{PORT}/{DATABASE}
spring.datasource.username={USERNAME}
spring.datasource.password={PASSWORD}
```

## Run the application

After the installation, in the Intellij project, you have to right clic on "ShopsRUsApplication" and clic on "Run ShopsRUsApplication" option. The default server will start on port 8090. If the port is in use, you can change the port number in "application.properties" file.
```
server.port={PORT}
```

## Test API's endpoints
If you want to test the API's endpoints, you can go to the route /api/v1/swagger-ui.html#/. There is a documentation of the API's endpoints

## Run Unit Tests
If you want to run unit tests of each endpoint, in the Intellij project, go to src/test/java/ and right-click on the test and select "Run {NAME}ControllerTest".  