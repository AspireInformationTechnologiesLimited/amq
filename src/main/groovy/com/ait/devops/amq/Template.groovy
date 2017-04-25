package com.ait.devops.amq

import groovy.text.SimpleTemplateEngine

/**
 * Created by sande on 21/04/2017.
 */
enum Template {

    INSTANCE;

    public String enrich(String template, Map data)
    {
        new SimpleTemplateEngine().createTemplate(template).make(data).toString()
    }

    public Map<String, String> getData()
    {
        [   "messageId" : getUUID(),
            "threadId" : getUUID(),
            "createdUtc": getUTCDate(),
            "resourceId" :randomNumericId(8),
            "resourceCreatedUtc" : getUTCDate()
        ] as Map
    }

    private String randomNumericId(int numOfDigits)
    {
        String.valueOf(System.nanoTime() ).substring(0, numOfDigits);
    }

    private String getUTCDate()
    {
        new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'", TimeZone.getTimeZone("UTC"))
    }

    private String getUUID()
    {
        java.util.UUID.randomUUID().toString()
    }

}
