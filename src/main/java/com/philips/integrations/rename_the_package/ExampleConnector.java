package com.philips.integrations.rename_the_package;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class ExampleConnector extends RouteBuilder {

    @Override
    public void configure() throws Exception {                

        from("netty-http:http://0.0.0.0:{{integrationname.connector.port:9090}}/{{integrationname.connector.path}}")
            .id("example-connector")
            .setHeader("pi.type").constant("sync")       
            .setProperty("test", constant("potato"))                        
            .process(this::doSomething)
            .toD("tie-router:example_event?timeout=5000&type=sync");

    }

    private void doSomething(Exchange exchange) {
        exchange.getMessage().setBody(exchange.getIn().getBody(String.class) + " > hello world");
    }

}
