package com.ait.devops.amq

import groovy.json.JsonSlurper

/**
 * Created by sande on 21/04/2017.
 */
class Boot {

    public static void main(String[] args) {

        String loc = System.getProperty("conf");

        if( !( loc))
        {
            println("usage :: java -Dloc=<config location> -jar <<amq-xx-all.jar>>")
        }
        else
        {
            String json = new File(loc).text;
            def config = new JsonSlurper(new File(json).text)
            String tmpLoc = config.templateLoc

            AMQActor amqActor = new AMQActor(json)
            config.templates.each{ template ->
                Map<String, String> data = getData()
                String payload = Template.INSTANCE.enrich(
                        new File(tmpLoc+(template.source+"_"+template.resourceName).toLowerCase()).text,
                        data)
                amqActor.publish(payload, ([template.source, template.resourceName] << data.values()).join(","))
            }

            amqActor.tearDown()
        }

    }
}
