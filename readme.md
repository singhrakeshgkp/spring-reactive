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
- Approach 2->


### Creating Subscribers Reactive-web4
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
  - Nothing will happens as we don't have subscriber. In reactive-wb3 when we were returning from controller or we were registering router spring boot was automatically creating subscriber for us.

### Creating Custom Publishers

### Essential Methods

### Securing Reactive application

### Using websockets
