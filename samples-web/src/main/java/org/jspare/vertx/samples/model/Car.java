/*
 *
 */
package org.jspare.vertx.samples.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

	private String name;
	private int year;
}