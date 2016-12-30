/*
 *
 */
package org.jspare.vertx.samples.proxy;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import lombok.NoArgsConstructor;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
@DataObject(generateConverter = true)
@NoArgsConstructor
public class Product {

	private String name;

	public Product(JsonObject jsonObject) {

		ProductConverter.fromJson(jsonObject, this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		ProductConverter.toJson(this, json);
		return json;
	}

}
