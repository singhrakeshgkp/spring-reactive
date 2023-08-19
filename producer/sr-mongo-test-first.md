# Table of contents
- [About](#about)
- [Project Setup](#project-setup)
- [Writing Tests](#writing-tests)
  - [Writing Tests For Pojo](#writing-tests-for-pojo)
  - [Writing Tests For Entity](#writing-tests-for-entity)
  - [Writing Tests For Repository](#writing-tests-for-repository)
  - [Writing Tests For Web Tier](#writing-tests-for-web-tier)
  ## About
  Here we will create a project, that will follow the test first approach.
  ## Project Setup
  - Create new project using Spring web reactive, lombok, contract verifier and mongo db reactive support dependency.
 ## Writing Tests   
### Writing Tests For Pojo
- Create a ```ReservationTest``` class to test ```Reservation``` Pojo
- Create a ```Reservation``` pojo class
- Write and verify the test.
### Writing Tests For Entity
- Create a ```ReservationEntityTest``` class. Write the test method, execute it and see the database collection, record should be present
### Writing Tests For Repository
- Create a ```ReservationRepositoryQueryTest``` and ```ReservationRepository``` class. 
- Create the query test mehtod and run the test.

### Writing Tests for Web tier
- Create a new class ```ReservationHttpTest``` and write the required test.

