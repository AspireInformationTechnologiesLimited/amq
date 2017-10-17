package com.ait.devops.amq

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.RoutingContext;

/**
 * Created by sande on 21/04/2017.
 */
class Boot extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		super.start();
		
		def server = vertx.createHttpServer()
		def router = Router.router(vertx)
		router.route().handler({ routingContext ->

		  // This handler will be called for every request
		  def response = routingContext.response()
		  response.putHeader("content-type", "text/plain")

		  // Write to the response and end it
		  response.end("Hello World from Vert.x-Web!", "UTF-8")

		})
		server.requestHandler(router.&accept).listen(8080, '0.0.0.0')
		
	}
}
