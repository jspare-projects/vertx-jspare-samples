/*
 *
 */
package org.jspare.vertx.samples.route;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jspare.vertx.samples.model.Car;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.handling.ArrayModel;
import org.jspare.vertx.web.annotation.handling.MapModel;
import org.jspare.vertx.web.annotation.handling.Model;
import org.jspare.vertx.web.annotation.handling.Parameter;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.method.Post;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handler.APIHandler;

@SubRouter("/cars")
public class CarRoute extends APIHandler {

	@Get("/:id")
	@Handler
	public void getById(@Parameter("id") Integer id) {

		success(new Car("Car " + id, 2000 + id));
	}

	@Get
	@Handler
	public void list() {

		success(Arrays.asList(new Car("Punto", 2010), new Car("Veloster", 2013)));
	}

	@Post
	@Handler
	public void save(@Model Car car) {

		success(car);
	}

	@Post("/bulk")
	@Handler
	public void saveBulk(@ArrayModel(Car.class) List<Car> cars) {

		success(cars);
	}

	@Post("/type/bulk")
	@Handler
	public void saveTypeBulk(@MapModel(Car.class) Map<String, Car> cars) {

		success(cars);
	}

}