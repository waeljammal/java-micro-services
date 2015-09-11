# java-micro-services
Java Spring Micro Services

# Technology Stack
- Java 8
- Ribbon
- Hystrix
- Spring Boot
- Spring Cloud
- Eureka
- Auto discovery, quickly deploy more micro services

This example demonstrates how you could implement a micro services architecture that is redunant, scalable, load balanced
and highly performant.

# Requirements
- Ability to define a technology stack per micro service, for example one micro service might work better if using nosql while another might work better with sql.
- Ability to scale a single part of your infrastructure quickly to resolve bottle necks
- Ability to spread the load between multiple databases or use a single cluster
- Low configuration using auto discovery and fallbacks

# Usage
- Each module in the project is an independant application
- Start up all the servers located in pw-server
- Start up all the services in pw-micro-services

You can use your IDE to just launch the main application in each module, I use multi start in InteliJ Idea to launch them for me
with a single click. Otherwise you can use mvn spring-boot:run
