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
  
## Client (sreactive-mongo-inte-client)
