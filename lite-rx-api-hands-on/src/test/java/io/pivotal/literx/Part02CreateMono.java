package io.pivotal.literx;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.core.test.TestSubscriber;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/core/docs/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 * @see <a href="http://projectreactor.io/core/docs/api/reactor/core/test/TestSubscriber.html">TestSubscriber Javadoc</a>
 */
public class Part02CreateMono {

//========================================================================================

	@Test
	public void empty() {
		Mono<String> mono = emptyMono();
		TestSubscriber<String> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(mono)
				.assertValueCount(0)
				.assertComplete();
	}

	Mono<String> emptyMono() {
		return Mono.empty();
	}

//========================================================================================

	@Test
	public void fromValue() {
		Mono<String> mono = fooMono();
		TestSubscriber<String> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(mono)
				.assertValues("foo")
				.assertComplete();
	}

	Mono<String> fooMono() {
		return Mono.just("foo");
	}

//========================================================================================

	@Test
	public void error() {
		Mono<String> mono = errorMono();
		TestSubscriber<String> testSubscriber = new TestSubscriber<>();
		testSubscriber
				.bindTo(mono)
				.assertError(IllegalStateException.class)
				.assertNotComplete();
	}

	Mono<String> errorMono() {
		return Mono.error(new IllegalStateException());
	}

}
