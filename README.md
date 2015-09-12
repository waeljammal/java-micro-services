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
- Flat tables, maintaining a disconnect makes it easier to split up your data storage or even use different implementations such as mongo, mysql, oracle etc. accross different micro services. For instance instead of portals having a strong relation with domains they are instead linked together by the domains id making the relationship weak, when requesting portals you supply the domain id to get all portals for that domain and so on, there are no joining tables so you could host your portals in mysql while hosting your domains in mongo, whatever suits the microservice the most.

This example demonstrates how you could implement a micro services architecture that is redunant, scalable, load balanced
and highly performant.

# Requirements
- Ability to define a technology stack per micro service, for example one micro service might work better if using nosql while another might work better with sql.
- Ability to scale a single part of your infrastructure quickly to resolve bottle necks
- Ability to spread the load between multiple databases or use a single cluster
- Low configuration using auto discovery and fallbacks
- Global SSO authentication
- Support for multiple authentication methods (openid, etc.)

# How to run it
- Each module in the project is an independant application
- Start up all the servers located in pw-server
- Start up all the services in pw-micro-services
- It can take up to 30 seconds for the services to be auto discovered, this can be changed as well in the eureka configuration.

You can use your IDE to launch the main application in each module, I use multirun (https://plugins.jetbrains.com/plugin/7248?pr=idea) in InteliJ Idea to launch them for me with a single click. Otherwise you can use mvn spring-boot:run

Note that you do not connect to the micro services directly, instead all requests are made to the pw-gateway, your micro services would sit behind the DMZ and be inaccessible to the public, only your API gateways will be public.

# URL's
- **Hystrix Dashboard** | http://localhost:9903/
- **Hystrix Dashboard Stream URL** | http://localhost:9023/hystrix.stream | Paste into the input
- **Eureka Dashboard** | http://localhost:8761/
- **Domain Service** | http://localhost:9023/domain-service
- **Domain With Portals Service** | http://localhost:9023/1/domain-with-portals
- **Domain With Portals & Fallbacks** | http://localhost:9023/1/domain-with-portals-alternative
- **Portal Service** | http://localhost:9023/portal-service/1
- **Basic Health Report** | http://localhost:8761/health
- **Discovered Services Feed** | http://localhost:8761/eureka/apps
- **Metrics** | http://localhost:8761/metrics | Many others like /restart /refresh /pause /stop /start
- There is much more I recommend you read | http://projects.spring.io/spring-cloud/spring-cloud.html

# Testing Authentication

There is no demo ui included so you will need to test authentication using the command line, follow the instructions below to test this.

- pw-service-security-sso is the openid sso service, this is currently configured to be a service but this is flexible and can be configured instead like the gateway so you could have pw-auth-openid-gateway etc. instead.

To test that auth is working try to visit **http://localhost:9023/secured-resource/hello-world** you should receive an unauthorized message. If so follow the steps below to authenticate and call the service again.

First make sure the secured resource module is started and paste the following line into your command line:

```
curl -X POST -vu demo:demosecret http://localhost:9023/security-sso-service/uaa/oauth/token -H "Accept: application/json" -d "password=password1&username=user1&grant_type=password&scope=openid&client_secret=demosecret&client_id=demo"
```

You should receive a response like the following:

```
{"access_token":"9be2e7b3-daa5-41de-b7b7-005016e10f68","token_type":"bearer","refresh_token":"7e87f6f2-6525-4664-b545-feb3e80b6752","expires_in":42560,"scope":"openid"}
```

Copy the access_token value and replace the _PASTE-TOKEN-HERE_ string in the line below and run that in your command line:

```
curl http://localhost:9023/secured-resource/hello-world -H "Authorization: Bearer _PASTE-TOKEN-HERE_"
```

You should receive a response from the call.
