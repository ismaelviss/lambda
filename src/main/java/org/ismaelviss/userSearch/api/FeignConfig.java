package org.ismaelviss.userSearch.api;

import feign.Logger;

public class FeignConfig {

    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
