package com.example.demo;

import com.example.demo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class ReactorCreateDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<User> stringFlux = Flux.just("u1", "u2", "u3")
                .flatMap((id) -> ReactorCreateDemo.findUserById(id))
                .flatMap((user) -> ReactorCreateDemo.saveUser(user).then(Mono.just(user)))
                .doOnComplete(() -> System.out.println("Pipeline finished"))
                ;

        stringFlux.subscribe();
        Thread.sleep(10000);
    }





    static Mono<User> findUserById(String id) {
        return Mono.just(new User(id))
                .delayElement(Duration.ofMillis(300));
    }

    static Mono<Void> saveUser(User user) {
        return Mono.fromRunnable(() ->
                System.out.println("Saved user: " + user.getId())
        );
    }



}
