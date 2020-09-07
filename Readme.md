Rest Api Voting For Restaurants
===============================

Rest api with access right. There is user can leave yourself vote from a restaurant, where he wants to lunch.
A Person can vote once a day. He can change vote, if time less than 11:00 morning, otherwise his vote can't be counted.
Restaurant have menu, that contains some dishes, usually 2-5 position, but can be more.  

<h3>There are two types of user :</h3>

<h4>Anonymous :</h4>
<li>He can create account for yourself 

<h4>Admin :</h4>
<li>He can add, get, update, delete restaurants
<li>He can add, get, update, delete dish

<h4>User :</h4>
<li>He can add, change, delete vote
<li>He can update, delete yourself account

<h3>What frameworks and technologies were used?</h3>
 <li>Spring 
<ul>
<li>DataJpa
<li>Security
<li>MVC
</ul>
</li>
<li>Hibernate
<li>Ecache
<li>Jackson
<li>Logack & SLF4J 
<li>Database - HSQLDB in memory implementation

<h3>Some curls request</h3>

<h4>get all restaurant user</h4>
curl -u abc@abc.com:user http://localhost:8080/restaurantvote/restaurants/get

<h4>create restaurant</h4>
curl -u abc1@abc.com:admin -H "Content-Type: application/json" -d "{\"name\": \"Restaurant - Test\"}" http://localhost:8080/restaurantvote/restaurants
  
<h4>create vote by user for restaurant</h4>
curl -u abc@abc.com:user -H "Content-type: application/json" -d "{\"user\": {\"id\": \"100000\"}}" http://localhost:8080/restaurantvote/votes/restaurants/100002

<h4>Other request your can see in RestTest.http</h4> 