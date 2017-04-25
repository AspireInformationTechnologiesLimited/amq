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
            println("usage :: java -Dconf=<config location> -jar <<amq-xx-all.jar>>")
        }
        else
        {
            //String json = new File(loc).text;
            def config = new JsonSlurper().parse(new File(loc))
            String tmpLoc = config.templateLoc

            AMQActor amqActor = new AMQActor(config.userId, config.password, config.url, config.publishTo)
            config.templates.each{ template ->
                Map<String, String> data = Template.INSTANCE.getData()
                String payload = Template.INSTANCE.enrich(
                        new File(tmpLoc+(String.valueOf(template.source).replaceAll("\\.","_")+"_"+template.resourceName).toLowerCase()+".xml").text,
                        data)
                amqActor.publish(payload, (([template.source, template.resourceName] + data.values()).join(",")).toString())
            }

            amqActor.tearDown()
        }

    }
}
