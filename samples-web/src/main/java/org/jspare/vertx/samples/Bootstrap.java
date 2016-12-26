/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Application;
import org.jspare.vertx.bootstrap.VertxApplication;

public class Bootstrap extends VertxApplication {

	public static void main(String[] args) {

		Application.run(Bootstrap.class);
	}
}