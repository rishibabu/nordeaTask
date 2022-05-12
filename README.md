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
      - First clone the repositiory using the git clone command 
     - This is java based Spring boot application which uses maven as a build tool to test you need to
      - First download jdk from https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html then either set the Enviroenment variables for running           java command everywhere or go the jdk bin folder directly and copy the java exe file path then go to the jar file location run the java command.
     - Download the Maven build tool from https://maven.apache.org/download.cgi 
     - Go inside the project folder
   * If the application must be deployed to a server in remote location, how would you do it?
