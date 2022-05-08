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
   * How to test your application?
   * If the application must be deployed to a server in remote location, how would you do it?
