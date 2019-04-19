package org.vinsw.mq.conf;

import static org.apache.commons.lang3.Validate.notNull;
import static org.vinsw.mq.conf.Constants.*;

public class Configuration {

    public static void initEnv() {
        String keyStore = System.getenv(ACTIVEMQ_HOME) + DEFAULT_BROKER_KS;
        String trustStore = System.getenv(ACTIVEMQ_HOME) + DEFAULT_CLIENT_TS;
        System.setProperty("javax.net.ssl.keyStorePassword", Constants.DEFAULT_KS_PASSWORD);
        System.setProperty("javax.net.ssl.keyStore", keyStore);
        System.setProperty("javax.net.ssl.trustStore", trustStore);
    }

    public static String getBrokerUrl(String protocol) {
        String hostname = System.getenv("HOSTNAME"); // The HOSTNAME env variable need to be set
        notNull(hostname);
        String url = protocol + hostname + ":" + ACTIVEMQ_PORT;
        return url;
    }

}
