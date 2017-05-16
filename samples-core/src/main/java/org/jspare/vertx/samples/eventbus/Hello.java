/*
 *
 */
package org.jspare.vertx.samples.eventbus;

import org.jspare.vertx.annotation.Consumer;
import org.jspare.vertx.annotation.LocalConsumer;

import io.vertx.core.eventbus.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hello {

	@Consumer("hello")
	public void helloWorld(Message<String> event) {

		log.debug("Event driven says Hello {}", event.body());
		event.reply("Hello " + event.body());
	}

	@LocalConsumer("local.hello")
	public void helloWorldLocal(Message<String> event) {

		log.debug("Event driven says Hello {}", event.body());
		event.reply("Hello " + event.body());
	}
}