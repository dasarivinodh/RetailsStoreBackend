# RetailsStoreBackend

######   Setting Java (java 1.8 needed)  ########

Make sure your  %JAVA_HOME%  and %JRE_HOME% is set to java 1.8


######  Setting DB (MySql) ########

Install My Sql DB 

Option 1:

1. create a database with name 'hibernate'

2. Spring boot will take care remaining(creating tables)

Option 2:

Run the hiberbate.sql file provided in Repository


######  Application Properties ########

configure the datasource url , username and password 

default values

spring.datasource.url=jdbc:mysql://localhost:3306/hibernate?useSSL=false

spring.datasource.username=root

spring.datasource.password=root

see application properties file under src/main/resources for more info

###### maven command to run the build #######

mvn clean install             (with test cases)

mvn clean install -DskipTests (with out test cases)

Any issues, try to remove files already installed in local repositary 

###### start the application ###### 

java -jar {projectname}-{SNAPSHOT-VERSION}-SNAPSHOT.jar

Note: make sure mysql server is up and running 

Application runs by default in 8080 port



