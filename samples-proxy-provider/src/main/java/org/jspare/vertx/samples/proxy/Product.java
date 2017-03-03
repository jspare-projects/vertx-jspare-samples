/*
 *
 */
package org.jspare.vertx.samples.proxy;

import java.time.ZonedDateTime;

import org.jspare.vertx.utils.DataObjectConverter;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import lombok.Data;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
@Data
@DataObject
public class Product {

	private String name;
	private ZonedDateTime creation;

	public Product(){
	}
	
	public Product(JsonObject jsonObject) {

		DataObjectConverter.fromJson(jsonObject, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		DataObjectConverter.toJson(this, json);
		return json;
	}
}