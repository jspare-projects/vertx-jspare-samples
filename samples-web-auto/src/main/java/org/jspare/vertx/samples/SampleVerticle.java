/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.vertx.experimental.AutoConfiguration;
import org.jspare.vertx.experimental.AutoConfigurationVerticle;
import org.jspare.vertx.experimental.Module;

import io.vertx.core.http.HttpServerOptions;

@AutoConfiguration(@Module("httpServer"))
public class SampleVerticle extends AutoConfigurationVerticle {

  @Override
  public void start() throws Exception {
    super.start();
  }

  protected HttpServerOptions options() {
    return new HttpServerOptions().setPort(8000);
  }
}