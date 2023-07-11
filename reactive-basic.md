# Table of contents
- [Spring Reactive Basics](#Spring-Reactive-Basics)
  - [Docs](#docs)
  - [Hello world Application](#hello-world-application)
  - [Flux](#Flux)
    - [Testing](#Testing)
  - [Service Communication](#service-communication)
    - [Error Handling](#error-handling)
  - [Subscriber and Publisher](#subscriber-and-publisher)
    - [Custom Subscriber](#creating-custom-subscriber)
    - [Custom Publisher](#creating-custom-publisher)


# Spring Reactive Basics

## Docs
- https://spring.io/guides/gs/reactive-rest-service/
- https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/web-reactive.html
- https://spring.io/blog/2016/06/13/notes-on-reactive-programming-part-ii-writing-some-code

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

### Error Handling

- Proj = ```reactive-web2``` Branch ```004-error-handling```
- Approach 1 ->
  - Go to CustomerProxy.java class (reactive-web2) and append below code
    ```
     .onErrorResume(WebClientException.class,e->{
                  Customer customer = new Customer("demo customer");
                  return Flux.just(customer);
              });
    ```



## Subscriber And Publisher

<p>The data wonn't start flowing until we subscribe. subscribe() method can be used to collect all the elements in a stream</p>
<p>To make the data flow you have to subscribe to the Flux using one of the subscribe() methods.  when we  return anything from controller or we register router spring boot  automatically creates subscriber for us. </p>
<p> Mono and Flux are Publishers

  Mono & Flux <------Subscription------Subscriber
</p>

- Proj = ```reactive-web1``` Branch ```005-subscriber```
- Create a new Controller class ```TestSubscriberController``` Controller
  - Create ```subsriberTest1``` method with void return type. Run the application and try to access ```http://localhost:8080/subs1``` end point.This method will subscribe one stream/event and print the whole pipline process on console.

### Creating custom subscriber
- Crate a new class ```TestSubscriber``` class implementing Subscriber interface
- Create new method ```subsriberTest2``` in ```TestSubscriberController``` write the req logic and run the application
- Now test using ```http://localhost:8080/subs2``` endpoint
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
    ```
    var flux = Flux.fromIterable(Set.of(2, 2, 4, 4, 3, 6, 7, 7));
    flux.doOnNext(ele-> System.out.println(ele));
    ```
  - If you observe the output Nothing will happen as we don't have subscriber. 
  - we can create the subscriber using following line.
    ```
    .subscribe(ele-> System.out.println("subs"+ele));
    ```
  - In order to get the data subscriber have to request the value form publisher see method ```subsriberTest2```
    ```
    subscription.request(1); Here subscriber request for 1 element at a time, subscriber can request multiple element, this is also known as back pressure.
    ```
### Creating Custom Publisher
- create a ```TestPublisher.java``` class, this class will implement Publisher class.
- Now test application
- Creating Flux publisher using create method-> recommended way to create Flux refer ```test-pub2``` method of ```TestPublisher.java``` class
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
