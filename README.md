# nordeaTask

## Money flow application


1. This is an application that fetches data about one's imaginary monthly bank statements from an external API. 
   Parse data to calculate monthly balance with income and spending that is sent to an external API. There is no need to build a persistence layer.

2. Things to consider
   * What problem does this application try to solve?
     - This application will act as a middle layer or a single platform to provide a comfortable interface to carry out the banking-related functions by integrating 
         different banking APIs which actually decouples the user entity with bank entity where user can have n number of banks but the business operation will be same.
     - This application will avoid unauthenticated access to the API by implementing an extra security layer that authenticates and authorize the user
     - Processing internal API calls within the corporate firewall instead of routing them through a cloud outside can improve the performance significantly

   * What kind of architecture was used to achieve the solution?
     - I have used the Springboot Reactive microservice architecture which will actually retrieve the data from an external API(In our case for the sake of testing created an internal API) non blocking way which is not in traditional rest client.
   * How to test your application?
     - To test our application please consider the below mentioned steps
       1) First clone the repositiory using (git clone https://github.com/rishibabu/nordeaTask.git)
       2) This is **java** based Spring boot application which uses **maven** as a build tool to test you need to download jdk from https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html
       3) Set the **Environment** variables for running java command everywhere(refer https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows) or go the jdk bin folder directly and copy the java exe file path then go to the jar file location run the java command
       4) Next download the Maven build tool from https://maven.apache.org/download.cgi.
       5) After setting up java and downloading the maven then go to our cloned project base location,copy the path eg-> D:\XXX\NordeaRepo\Nordea 
       6) Go to the maven bin folder eg - D:\XXX\apache-maven-3.8.5-bin\bin then open the command prompt run the command **mvn -f D:\XXX\NordeaRepo\Nordea clean install**.This command will create a **jar** file inside the **target** folder of our project eg-D:\XXX\NordeaRepo\Nordea\target
       7) Go to the target folder then open the command prompt run the famous java - jar command **eg java -jar xxx-snaphot.jar**
       8) The application will be running in your **localhost** at port **8080**, after it is up and running go to the **Swagger** link http://localhost:8080/swagger-ui/index.html#/banking-controller/getEmployeeDetails then hit the **try it out** button then give the parameter **EmployeeID** as EMP100 for the sake of testing the GET call will give a sample savings response for that user 
 
   * If the application must be deployed to a server in remote location, how would you do it?
     - The application can be packaged as either **jar** or **war**.If it needs to be manually deployed in standalone application server like **Tomcat** the war generated from our application can be copied to the **webapps/ROOT**.war folder of the server
     - The recommended and popular way of deployment is using any **CI/CD** tools like j**enkins,aws,azure** etc to continuously integrate the changes commited in any version control application like **git** and build the jar files.Then run the continuous deployment pipeline which run the generated jar files
     - Along with CI/CD another approach which actually scales up the performance of our application by **containerization** which will convert our micro services as docker containers and then can be managed by any docker orchestration tools like **Kubernetes** to manage the cluster
