package org.ismaelviss.userSearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();

        params.put("keyword", cliArguments.getKeyword());
        params.put("limit", cliArguments.getLimit());
        return params;
    }
}
