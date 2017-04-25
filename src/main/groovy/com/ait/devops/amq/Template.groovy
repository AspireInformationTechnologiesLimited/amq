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
        ]
    }

    private String randomNumericId(int numOfDigits)
    {
        long timeSeed = System.nanoTime(); // to get the current date time value
        double randSeed = Math.random() * 1000; // random number generation
        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
        String.valueOf(timeSeed * randSeed).substring(0, numOfDigits).replaceAll(".","");
    }

    private String getUTCDate()
    {
        new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'", TimeZone.getTimeZone("UTC"))
    }

    private String getUUID()
    {
        UUID.randomUUID().toString()
    }

}
