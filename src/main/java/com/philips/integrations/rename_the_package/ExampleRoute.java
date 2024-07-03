package com.philips.integrations.rename_the_package;

import org.apache.camel.builder.RouteBuilder;

public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {                        
        
        from("tie-router:example_event?consumersSync={{example.sync:1}}&consumersAsync={{example.async:1}}")
            .id("example-route")            
            .toD("logger:example_name?level=INFO&message=Example route called: ${body}")
            .setBody().simple("{ \"example\" : \"${body}\" }");
        
    }

}
