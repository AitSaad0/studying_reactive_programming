# How do we build systems that stay fast, scalable, and stable under high load using non-blocking and asynchronous communication? 

## Reactive applications

### Handle many concurents user
### Uses asynchronous, non-blocking executions
### Stay responsive even when parts of stystem are slow or failing

### ==> Reactive is not about syntaxe, it s about architectior and behavior

## The Reative Manifesto (philosophie)

### Responsive

-> Systems Responds quickly and consistency
-> Has upper bounds on response time (QoS)
-> Builds user trust

### Resilient 

-> The system stay responsive even when something fails 
-> Failures are isolated, not propagated


### Elastic 

-> The system scale up and down automatically
-> Handles load spikes without degradation 
-> No central bottlenecks


### Message driven 
-> Componenets are communicate via asynchronous messages
-> No direct Blocking calls
-> Loose coupling

“Send message and move on (fire-and-forget).”

Important:
Message-driven is what enables responsiveness, resilience, and elasticity.

## Reactive streams

A standard for asynchronous stream with non-blocking backpressure

## Non-Blocking 

-> Threads starts work -> leaves
-> Result comes later via event 
-> Tread can handle other requests

### Thread are not wasted waiting 

## Backpressure

The consmer controls how fast the producer sends data 

why? 

-> Prevents memmory overflow 
-> Prevents system crash under load 

## Observer Pattern 

Roles : 
-> Observable/Provider -> source of data/events
-> Observer/Subscriber -> receives and reacts 
-> Observers register
-> Provider notifies them when something happens

### This is the producer-consumer model, but asynchronous

## Core interfaces(JDK 9 Additions)

### Publisher<T>
--> Produces data 
--> Sends items to subscribers

### Subscriber<T>
--> Receives data
--> Handles: 
    -->onNext
    -->onError
    -->onComplete

### Subscription 
--> Connects Publisher and Subscriber
--> Controls: 
    --> demand(request(n))
    --> cancellation 
➡️ This is where backpressure lives.


### Processor<T, R>
--> Both a Subscriber and a Publisher
--> Transform data 

➡️ Think: map/filter stage in a pipeline.^


## One-paragraph mental model (IMPORTANT)

Reactive programming is about building message-driven, non-blocking systems where data flows as streams from producers to consumers. The Reactive Streams specification defines how this flow must behave safely using backpressure. Libraries like RxJava and Reactor implement this model. The Reactive Manifesto defines the system-level qualities (responsive, resilient, elastic, message-driven) that this approach enables.


┌──────────────────────────────────────────────────────────┐
│                  REACTIVE MANIFESTO                       │
│  (How the system SHOULD behave)                           │
│                                                          │
│  Responsive ─ Resilient ─ Elastic ─ Message-Driven        │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│              MESSAGE-DRIVEN COMMUNICATION                 │
│        (Asynchronous, event-based, non-blocking)          │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│                REACTIVE STREAMS (STANDARD)                │
│   "Rules for async streams with backpressure"             │
│                                                          │
│  • Non-blocking                                           │
│  • Backpressure                                          │
│  • Interoperability                                      │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│           CORE REACTIVE STREAMS INTERFACES                │
│                                                          │
│   Publisher ──► Subscription ──► Subscriber               │
│        │                              ▲                   │
│        └──────────── Processor ───────┘                   │
│        (transform stream)                                 │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│           REACTIVE EXTENSIONS (Rx MODEL)                  │
│                                                          │
│  Observer Pattern                                        │
│  • Observable (Provider / Source)                        │
│  • Observer (Subscriber / Consumer)                      │
│  • Operators (map, filter, merge…)                       │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│        REACTIVE LIBRARIES (IMPLEMENTATIONS)               │
│                                                          │
│  • Reactor (Spring’s choice)                              │
│  • RxJava                                                │
│  • Akka Streams / Vert.x                                 │
│                                                          │
│  (All respect Reactive Streams rules)                    │
└──────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────┐
│              SPRING FRAMEWORK (SPRING 5+)                 │
│                                                          │
│  • Reactor is first-class                                │
│  • Spring WebFlux                                        │
│  • WebClient                                             │
│  • Reactive Security & Data                              │
└──────────────────────────────────────────────────────────┘
