# reward-program

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.


###To Run this project locally

$ git clone https://github.com/razinkabir2022/reward-program.git
$ mvn spring-boot: run

Endpoints:

http://localhost:8080/v1/customers/
http://localhost:8080/v1/customers/{id}