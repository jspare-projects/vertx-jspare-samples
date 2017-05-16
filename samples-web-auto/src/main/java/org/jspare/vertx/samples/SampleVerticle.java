/*
 *
 */
package org.jspare.vertx.samples;

import io.vertx.core.Vertx;
import org.jspare.core.Environment;
import org.jspare.vertx.autoconfiguration.AutoConfiguration;
import org.jspare.vertx.autoconfiguration.AutoConfigurationVerticle;
import org.jspare.vertx.autoconfiguration.Resource;

import io.vertx.core.http.HttpServerOptions;
import org.jspare.vertx.bootstrap.EnvironmentUtils;
import org.jspare.vertx.web.module.HttpServerModule;

@AutoConfiguration(
        @Resource(HttpServerModule.class)
)
public class SampleVerticle extends AutoConfigurationVerticle {

  public static void main(String[] args){
    Environment.create();
    Vertx vertx = Vertx.vertx();
    EnvironmentUtils.bindInterfaces(vertx);
    vertx.deployVerticle(new SampleVerticle());
  }

  @Override
  public void start() throws Exception {
    super.start();
  }

  protected HttpServerOptions options() {
    return new HttpServerOptions().setPort(8000);
  }
}