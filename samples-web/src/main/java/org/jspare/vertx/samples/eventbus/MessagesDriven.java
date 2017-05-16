/*
 *
 */
package org.jspare.vertx.samples.eventbus;

import org.jspare.vertx.annotation.Consumer;

import io.vertx.core.eventbus.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessagesDriven {

	@Consumer("messages.send")
	public void helloWorld(Message<String> event) {

		String body = event.body();

		if ("fail".equals(body)) {

			event.fail(1, "failed");
			return;
		}

		log.debug("Event driven says Hello {}", event.body());
		event.reply("Hello " + event.body());
	}
}