Arjun AppDirect Challenge

AppDirect Integration Challenge

This application serves as a minimal integration of AppDirect's APIs and includes the following:

Integration of AppDirect's subscription management and user management events
Spring-based web application using Spring Boot
Spring Security - protects restricted URLs, validates OAuth 1.0 and OpenID headers and maintains session
OpenID authentication
OAuth 1.0 one-legged authentication of incoming requests from AppDirect
OAuth 1.0 signing of outbound requests to AppDirect
H2 in-memory SQL database
Thymeleaf templates and Bootstrap for minimal web UI


To get the code:

Clone the repository:

$ git clone https://github.com/arjunkarnwal/ArjunKAppDirectChallenge.git
If this is your first time using Github, review http://help.github.com to learn the basics.

Running locally:


In your preferred IDE such as Eclipse, IDEA:
To create a jar and deploy the application from the command line with gradle:
Import app-direct-challenge as a Gradle Project.
Do the following
$ ArjunKAppDirectChallenge
$ gradle build
$ ./gradlew build
$ java -jar build/libs/ArjunKAppDirectChallenge-0.1.0.jar
Access the deployed web application at: http://localhost:8080/

Other info:

You can access a running instance of this application at https://polar-falls-88115.herokuapp.com

Questions?

Feel free to drop me an email!