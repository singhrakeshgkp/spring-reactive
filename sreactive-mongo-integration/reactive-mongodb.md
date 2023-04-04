
### Setup Project
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

### Send Message to cleint via websocket
 - configure websocket -> Read advantage about websocket
 - create Greeting Producer, request and response java classess
 - Create websocket client ```ws.html``
 
### Building an edge service
<p>All the devices android, iphone, web .. etc will talk to edge service and edge service will forward the request to other microservices</p>
- Create new project sreactive-client with following dependencies
  - lombock, reactive web. rsocket and gateway
  - 
- fdjk

` 
