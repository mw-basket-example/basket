# Basket price calculator

Program that takes a basket of items and outputs its total cost. The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches.

## Functionality

In order to run calculation please use com.example.basket.BasketPriceRunner providing one or more arguments:
* Banana
* Orange
* Apple
* Lemon
* Peach

Example:
```
java -cp basket-1.0.0-SNAPSHOT.jar com.example.basket.BasketPriceRunner Banana Apple Orange Banana
```
Output:
```
Price of the basket is: £3.05
```

## Environment

Program supports:
* Java 5 (as per spec provided)
* Maven 3.1.1

## Management

* Build and install application:
```
mvn clean install
```
* Run example:
```
mvn exec:java
```