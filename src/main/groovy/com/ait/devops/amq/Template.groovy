package com.ait.devops.amq

import groovy.text.SimpleTemplateEngine
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat

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
        new DateTime(DateTimeZone.UTC).toString(ISODateTimeFormat.dateTime())
    }

    private String getUUID()
    {
        java.util.UUID.randomUUID().toString()
    }

}
