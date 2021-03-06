package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.test.TestSubscriber;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part03Transform {

	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	@Test
	public void transformMono() {
		Mono<User> mono = repository.findFirst();
		TestSubscriber<User> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(capitalizeOne(mono))
				.await()
				.assertValues(new User("SWHITE", "SKYLER", "WHITE"))
				.assertComplete();
	}

	Mono<User> capitalizeOne(Mono<User> mono) {
		return mono.map(u -> toUpper(u));
	}

	private User toUpper(User u) {
		return new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase());
	}

//========================================================================================

	@Test
	public void transformFlux() {
		Flux<User> flux = repository.findAll();
		TestSubscriber<User> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(capitalizeMany(flux))
				.await()
				.assertValues(
					new User("SWHITE", "SKYLER", "WHITE"),
					new User("JPINKMAN", "JESSE", "PINKMAN"),
					new User("WWHITE", "WALTER", "WHITE"),
					new User("SGOODMAN", "SAUL", "GOODMAN"))
				.assertComplete();
	}

	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(u -> toUpper(u));
	}

//========================================================================================

	@Test
	public void  asyncTransformFlux() {
		Flux<User> flux = repository.findAll();
		TestSubscriber<User> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(asyncCapitalizeMany(flux))
				.await()
				.assertValues(
					new User("SWHITE", "SKYLER", "WHITE"),
					new User("JPINKMAN", "JESSE", "PINKMAN"),
					new User("WWHITE", "WALTER", "WHITE"),
					new User("SGOODMAN", "SAUL", "GOODMAN"))
				.assertComplete();
	}

	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return flux.flatMap(u -> asyncCapitalizeUser(u));
	}

	Mono<User> asyncCapitalizeUser(User u) {
		return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

}
