### Reactive Router (reactive-web2)

- Create  customer and customer service class
- Create  ```RouterConfig``` class
- Create CustomerHandler class and run the application. Now test it using Chrome (it will only work with supported reactive client, as such postman is not supporting)


### Calling reactive-web2 router from reactive-web3 application
- Config webClient bean for reference refer ```WebClientConfig.java``` class.
- Create ```CustomerProxy.java``` class and write the code to get the data from reactive-web2 application
- Now consumer part is completed here.
- Expose the new endpoint and return the reactive-web2 response on newly exposed endpoint(to expose new endpoint follow steps mentioned in reactive-web2)
