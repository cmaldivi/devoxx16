package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.test.TestSubscriber;
import rx.schedulers.TestScheduler;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part05Request {

	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	@Test
	public void requestNoValue() {
		Flux<User> flux = repository.findAll();
		TestSubscriber<User> testSubscriber = createSubscriber();
		testSubscriber
				.bindTo(flux)
				.await()
				.assertNoValues();
	}

	TestSubscriber<User> createSubscriber() {
		return new TestSubscriber<>(0);
	}

//========================================================================================

	@Test
	public void requestValueOneByOne() {
		Flux<User> flux = repository.findAll();
		TestSubscriber<User> testSubscriber = createSubscriber();
		testSubscriber
				.bindTo(flux)
				.assertValueCount(0);
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SKYLER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.JESSE)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.WALTER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SAUL)
				.assertComplete();
	}

	void requestOne(TestSubscriber<User> testSubscriber) {
		testSubscriber.request(1);
	}

//========================================================================================

	@Test
	public void experimentWithLog() {
	Flux<User> flux = fluxWithLog();
		TestSubscriber<User> testSubscriber = createSubscriber();
		testSubscriber
				.bindTo(flux)
				.assertValueCount(0);
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SKYLER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.JESSE)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.WALTER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SAUL)
				.assertComplete();
	}

	Flux<User> fluxWithLog() {
		return repository.findAll().log();
	}


//========================================================================================

	@Test
	public void experimentWithDoOn() {
		Flux<User> flux = fluxWithDoOnPrintln();
		TestSubscriber<User> testSubscriber = createSubscriber();
		testSubscriber
				.bindTo(flux)
				.assertValueCount(0);
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SKYLER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.JESSE)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.WALTER)
				.assertNotTerminated();
		requestOne(testSubscriber);
		testSubscriber
				.awaitAndAssertNextValues(User.SAUL)
				.assertComplete();
	}

	Flux<User> fluxWithDoOnPrintln() {
		Flux<User> flux = repository.findAll();
		flux.doOnSubscribe(u -> System.out.println("Starring: "));
		flux.doOnNext(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
		flux.doOnComplete(() -> System.out.println(" end!"));
		return flux;
	}

}
