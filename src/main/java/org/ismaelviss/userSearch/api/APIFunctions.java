package org.ismaelviss.userSearch.api;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import org.apache.logging.log4j.LogManager;
import org.ismaelviss.userSearch.UserSearch;

public interface APIFunctions {
    public static <T> T buildAPI(Class<T> clazz, String url) {
        org.apache.logging.log4j.Logger logger =  LogManager.getLogger(APIFunctions.class);
        return Feign.builder()
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .logger(new Logger() {
                    @Override
                    protected void log(String configKey, String format, Object... args) {
                        logger.debug(String.format(format, args));
                    }
                })
                .target(clazz, url);
    }
}
