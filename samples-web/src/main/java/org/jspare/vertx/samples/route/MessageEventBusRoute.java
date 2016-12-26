/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.annotation.VertxInject;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.handling.Parameter;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.handling.Handling;

import io.vertx.core.eventbus.EventBus;

public class MessageEventBusRoute extends Handling {

	@VertxInject
	private EventBus eventBus;
	
	@Get("/eventbus/:name")
	@Handler
	public void hello(@Parameter("name") String name) {
		
		eventBus.send("messages.send", name, result -> {
			
			if(result.succeeded()){
				
				success(result.result().body().toString());
			}else{
				
			}
		});
	}
}