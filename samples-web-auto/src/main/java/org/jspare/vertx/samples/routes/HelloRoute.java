package org.jspare.vertx.samples.routes;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.handler.APIHandler;

public class HelloRoute extends APIHandler {
  
  @Get("/hello")
  @Handler
  public void hello(){
    
    success("working");
  }
}