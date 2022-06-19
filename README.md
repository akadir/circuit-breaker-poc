# circuit breaker poc

The story of Echo and Narcissus can be found [here](https://en.wikipedia.org/wiki/Echo_and_Narcissus).

![Echo and Narcissus by John William Waterhouse](https://upload.wikimedia.org/wikipedia/commons/9/9c/John_William_Waterhouse_-_Echo_and_Narcissus_-_Google_Art_Project.jpg "Echo and Narcissus by John William Waterhouse")

# Demo

1. start Echo and Narcissus
2. send a request to the Echo's [http://localhost:8080/echo](http://localhost:8080/echo) endpoint. It should print `Narcissus is responding`
3. stop Narcissus.
4. refresh the page. It should print a different message: `Narcissus is not responding me, I think I'm gonna die.`

you can also see the status of the circuit breaker from the [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) address