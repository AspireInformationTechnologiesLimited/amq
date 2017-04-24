package com.ait.devops.amq

/**
 * Created by sande on 21/04/2017.
 */
class AMQConfig {

    public static void main(String[] args) {

        String loc = System.getProperty("conf");

        if( !( loc))
        {
            println("usage :: java -Dloc=<config location> -jar <<amq-xx-all.jar>>")
        }
        else
        {

        }

    }
}
