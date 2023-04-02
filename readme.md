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
- 

### Creating Custom Publishers

### Essential Methods

### Securing Reactive application

### Using websockets
