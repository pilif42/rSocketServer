# Prerequisite - RSocket Client CLI by Toshiaki Maki:
    - to install:
            - cd tools
            - wget -O rsc.jar https://github.com/making/rsc/releases/download/0.4.2/rsc-0.4.2.jar
    - to test:
            - java -jar rsc.jar --help


# To build: 
mvn clean install


# To run: 
Run config in IntelliJ pointing to RsocketServerApplication
Or: mvn clean package spring-boot:run -DskipTests=true


# To test:
cd tools
java -jar rsc.jar --debug --request --data "{\"origin\":\"Client\",\"interaction\":\"Request\"}" --route request-response tcp://localhost:7000
        - value of --route matches @MessageMapping("request-response") in RSocketController.
        - 3 ‘message frames’ are shown in the output thanks to '--debug':
                - Metadata = the routing metadata (request-response) being sent to the server.
                - Data = message that the client is sending to the server = {"origin":"Client","interaction":"Request"}
                - Data = server’s response message back to the client = {"origin":"Server","interaction":"Response","index":0,"created":1590311085}
                
                
# Server used under the hood: 
https://netty.io/ -> see log statement = o.s.b.rsocket.netty.NettyRSocketServer : Netty RSocket started on port(s): 7000


# TODOs
https://spring.io/blog/2020/03/23/getting-started-with-rsocket-spring-boot-request-stream
https://spring.io/blog/2020/04/06/getting-started-with-rsocket-spring-boot-channels
Read about Netty.
