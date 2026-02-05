# Reactor: the reactive foundation in Spring 

Reactor is Spring's <native reactive library> and the reference implementation used by Spring WebFlux 

it is :
--> An implementation of Reactive Streams 
--> Built around non-blocking, asynchronous data flows 
--> Based on event-driven execution 

### Reactor provides two main reactive types: 
--> Mono<T> -> emits 0 or 1 element
--> Flux<T> -> emits 0 to N elements

Both: 
--> Implemet Publisher<T>
--> Are lazy (nothing happens until subscription)
--> Respect backpressure
--> Are cold by default 

# Reactive Streams

Reactive Streams defines a standard contract for async strea processing 

Core interfaces 
-> Publisher --> produces data
-> Subscriber --> consumes data 
-> Subscription --> controles demand (request(n), cancel)
-> Processor --> both publisher and subscriber

# Flux vs Mono
### Flux --> Streams of values(0..N)
### Mono --> async result(0..1)

# Cold s Hot streams 

## Cold streams 
-> Start emitting on subscription 
-> Each subscriber gets data from the beginnig
-> Subscrier controls demand 
-> Ideal for backpressure

Example: 
->Database queries
->HTTP calls
->File reading

📌 Mono and Flux are cold by default

## Hot streams

--> Data exists independently of subscribers 
--> Late subscribers miss pastdata 
--> No replay by default 
--> Flow control needs buffering

Examples:

Kafka topics

WebSockets

Mouse events

Stock prices

📌 Hot ≠ starts early
📌 Hot = no replay for late subscribers


# Message-driven vs Reactive Streams 
## Message-driven systems 
--> Use message brokers (Kafka, RabbitMQ)
--> Producers send messages blindly 
--> Consumers pull from broker 
--> Typically hot streams 
--> Good for distributed systems

## Reactive Streams
-> In-memory, demand-driven 
-> Publisher waits for demand
-> Strong backpressure support 
-> Used inside applications(WebFlx, DB, HTTP)

# Why Spring needed WebFlux 
### Traditional Spring MVC is:
-> Servlet-based 
-> Thread-per-request
-> Blocking I/O
-> Limited scalabilty under high concurrency

### Modern application require: 
-> High concurrency 
-> Low resource usage 
-> Non-blocking I/O
-> Event-driven processig
-> Event-loop based 
-> Fewer threads handle many requests 


## WebFlux introduces: 
-> Reacive controllers 
-> Reactive WebClient 
-> Reactive WebSocket 
-> Reactive security 

