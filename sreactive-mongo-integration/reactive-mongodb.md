
### Setup Project (sreactive-mongo-integration)
- Create new spring boot project with following dependency
  - Reactive web, lombok, reactive mongodb and 
  - Create Reservation.java, SampleDataInitializer.java(it will save the data in db)
  - Run mongo db server
  - Run your application, data should be saved in mongodb
 ### Expose rest style endpoints
 - create a new class ```ReservatonsController.java``` and define a get endpoint
 - run the application and test the ```http://localhost:8080/reservations``` end point
 ### Expose reactive style endpoints
 - create an ```HttpConfiguration.java``` class 
 - comment the endpoint defined on controller
 - and test the same endpoint, it should produce the same result

### Send Message to cleint via websocket
 - configure websocket -> Read advantage about websocket
 - create Greeting Producer, request and response java classess
 - Create websocket client ```ws.html```
 
### Building an edge service (setup a new project sreactive-client)
<p>All the devices android, iphone, web .. etc will talk to edge service and edge service will forward the request to other microservices</p>

- Create new project sreactive-client with following dependencies
  - lombock, reactive web. rsocket and gateway
- Create a ```ReservationClient.java``` class
- Create a RouterFunction bean 
- now test ```reservation/names``` endpoints.

### RSocket
<p>is a binary protocol and support 4 message exchange pattern. single value in and single value out, single value in multiple value out, multi value in and multi value out, single value in and no value out</p>
if you want to perform stream of data in and stream of data out, this kind of operation is much harder to perform with http.

- create new controller ```RsocketGreetingsController``` in ```sreactive-mongo-integration``` application and specify the port in ```application.prop``` file
- Now do the following things in ```sreactive-client``` application
  - Define rsocket bean in main class
  - Create new GreetingClient (it uses RosocketRequester not webclient)
  - create new endpoint that stream the data(in router function).
  - run both the application and hit the ```http://localhost:8181/sse/greetings/rakesh``` endpoint
   
    
