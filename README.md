some description here

### Prerequisite : 
Before staring the service start the instance of mongo db on localhost to store the pototo Bags.

###  Structure

This project has following end points,

/market/addPotatoBag :- add a potato bag to the store
/market/getListOfPotatoBags/{numberOfBags} :- to get list of specified number of bags
/market/getListOfPotatoBags :- to get list of bags , since number is not specified it will return 3 bags in the list.
/market/getPotatoBagById/{bagId} :- to get the potato bag by id.
/market/deletePotatoBagById/{bagId} :- to delete the potato bag by id.
/market/getListOfAllPotatoBags :- to get list of all potato bags.



### mvn build
mvn clean install

### spring boot build
spring-boot:run

### Docker build
mvn clean install docker:stop docker:build
	 			
Potato Bag JSON Structure example

	{
	"numberOfPotatos" : "45",
	"supplier" : "DE_COSTER",
	"packageTimestamp" : "2018-07-23 03:08:45",
	"price" : "10"
}

## Things to do
Test cases could be increased
Comments should be improved


