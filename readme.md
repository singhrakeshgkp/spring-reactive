### Docs
https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html
### Reactive Router (reactive-web2)

- Create  customer and customer service class
- Create  ```RouterConfig``` class
- Create CustomerHandler class and run the application. Now test it using Chrome (it will only work with supported reactive client, as such postman is not supporting)


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

### Securing Reactive application

### Using websockets
