# Spring Reactive Testing (writing test first)

## Producer (sreactive-mongo-integration2)
### Source -Josh Long https://www.youtube.com/watch?v=N24JZi-xFx0
##### Create ReservationPojoTest
##### Create ReservationEntityTest 
##### RepositoryQueryTest - Persist and validate the data.
##### ReservationHttpTest - Testing web tier
- Run it first it will throw bean creation error, as we have only injected web tier and we are performing slice testing. Spring will load the context(bean) related to web tier.
- To deal with this kind of error we normally mock.
  ```
   @MockBean
    private ReservationRepo repository;
  ```
  
## Client (sreactive-client-integration)
- Create a ```ReservationClient.java, Reservation.java``` classes
- Create a web client bean in Spring boot main class
- Now run the test, it will fail as its unbale to connect to localhost, localhost producer is not up. To test this in issolation we will mock it using wiremock.
- Add wiremock and mock the response. Run the test this time it will pass. But if multiple team working on the same project they may have defined the attribute with different name such as ```Reservation.resName, Reservation.name``` etc. In this case test will never pass
- To deal with the above scenario we will use contract, and spring ```spring-cloud-contract-maven-plugin``` plugin. This plugin will breaks the build if the contract doesn't line up with our expectation about the actual api.
  - Create new folder ```/resources/contract``` under test directory of producer application.
  - Create new file ```AllReservations.groovy``` file, it could be yml or Pact  ..etc file format.
  - Create new class ```BaseClass.java``` mention the same class in pom.xml file ```<baseClassForTests>com.example.BaseClass</baseClassForTests>```
  - Build the producer project
- Now instead of wire mock we will use ```StubRunner``` to test the client.
- [Read More about spring cloud contract](https://cloud.spring.io/spring-cloud-static/spring-cloud-contract/1.0.2.RELEASE/)


