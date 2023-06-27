# Table of contents
- [Spring Reactive Basics](#Spring-Reactive-Basics)
  - [Docs](#docs)
  - [Hello world Application](#hello-world-application)
  - [Flux](#Flux)
    - [Testing](#Testing)
  - [Service Communication](#service-communication)


# Spring Reactive Basics
## Docs
- https://spring.io/guides/gs/reactive-rest-service/
- jfdf
## Hello world Application
- Proj = ```reactive-web1``` branch = ```001-simple-reac-application```, ref https://spring.io/guides/gs/reactive-rest-service/
- Create a new spring boot application with spring reactive web dependency.
- Create Handler, Router, Clients classes
- Run the application, on console it should print ```Hello world``` or try to access ```localhost:8080/hello-world``` url, it should return the ```hello world``` msg back in response.

## Flux
- Proj = ```reactive-web1``` Branch ```002-flux```
- Create Customer Model, CustomerService, CustomerHandler, CustomerHandlerImpl and CustomerRouterConfig class.
- Run the application. hit ```http://localhost:8080/customers``` get url you will observe data will be comming as stream.
- Test it using Chrome (it will only work with supported reactive client, as such postman is not supporting)
### Testing

## Service Communication
- Proj = ```reactive-web1 and reactive web2``` Branch ```003-service-communication```
- Setup reactive web2 proj and call customer endpoint from reactive-web2 application
- Create Customer Model, WebClientConfig, Customerproxy, CustomerService, CustomerHandler, CustomerHandlerImpl and CustomerRouterConfig class.
- Run Both the application, and hit```localhost:8181/reactive-web2/customers``` url. reactive-web2 will call reactive-web1 and return the response.
### Reactive Router (reactive-web2)

- Create  customer and customer service class
- Create  ```RouterConfig``` class
- Create CustomerHandler class and run the application. Now test it using Chrome (it will only work with supported reactive client, as such postman is not supporting
- Run 


### Calling reactive-web2 from reactive-web3 application(router implementation)
- Config webClient bean for reference refer ```WebClientConfig.java``` class.
- Create ```CustomerProxy.java``` class and write the code to get the data from reactive-web2 application
- Now consumer part is completed here.
- Create ```CustomerService.java``` class it will uses ```Customerproxy``` to fetch the data form ```reactive-wb2``` application
- Create Router and handler classess
- Now run and test application

#### Handling Error 
- Approach 1 ->
  - Go to WebClientConfig.java class (reactive-web3) and append below code
    ```
     .onErrorResume(WebClientException.class,e->{
                  Customer customer = new Customer("demo customer");
                  return Flux.just(customer);
              });
    ```



### Creating Subscribers Reactive-web4

```
Flux                     Subscriber
      flux.subscribe()
 <--------------------------------
     onSubscribe()
 --------------------------------->
     subscription.request(2)
 <---------------------------------
     subscripiton.onNext(value)
 --------------------------------->
 subscripiton.onNext(value)
 --------------------------------->
     s.onSomplete
---------------------------------->

 onError()-if excep thrown by flux
---------------------------------->
  
```
- Mono and Flux are Publishers
  ```
  Mono & Flux <------Subscription------Subscriber
  ```
- Create new spring boot application with reactive-web dependency
- Create a controller ```TestController.java```
  - create one endpoint msg1 and perform below operation and run the application.
    ```
    var flux = Flux.fromIterable(Set.of(2, 2, 4, 4, 3, 6, 7, 7));
    flux.doOnNext(ele-> System.out.println(ele));
    ```
  - If you observe the output Nothing will happen as we don't have subscriber. In reactive-wb3 when we were returning from controller or we were registering router spring boot was automatically creating subscriber for us.
  - we can create the subscriber using following line.
    ```
    .subscribe(ele-> System.out.println("subs"+ele));
    ```
  - In order to get the data subscriber have to request the value form publisher see method ```msg2```
    ```
    subscription.request(1); Here subscriber request for 1 element at a time, subscriber can request multiple element, this is also known as back pressure.
    ```

### Creating Custom Publishers (reactive-web5)
- create a ```TestPublisher.java``` class, this class should implement Publisher class.
- Create ```TestSubscriber, TestController, and Testsubscription``` java classess.
- Now test application
- Creating Flux publisher using create method-> recommended way to create Flux refer ```test2``` method of ```TestController.java``` class
  ```
    Flux<String> flux = Flux.create(sink->{
            for(int i =0;i<5;i++){
               sink.next("ele "+i);
            }
            sink.complete();
        });
        flux.subscribe(ele-> System.out.println(ele));
  ```
- ```flux.log``` -> To print all the action happing under hood
  ```
  .subscribe(ele-> System.out.println(ele)) -> this lines doesn't request data from publisher aslo it doen't uses backpresure. It simply say give me whatever you have.
  ```
  
### Essential Methods
- refer reactive-web6 applications and reference documentations.

### Securing Reactive application

### Using websockets
