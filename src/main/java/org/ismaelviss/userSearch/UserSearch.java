package org.ismaelviss.userSearch;

import com.beust.jcommander.JCommander;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ismaelviss.userSearch.api.APIUsers;
import org.ismaelviss.userSearch.cli.CLIArguments;
import org.ismaelviss.userSearch.cli.CLIFunctions;
import org.ismaelviss.userSearch.dto.Datum;
import org.ismaelviss.userSearch.dto.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.ismaelviss.userSearch.api.APIFunctions.buildAPI;
import static org.ismaelviss.userSearch.cli.CommanderFunctions.buildCommanderWithName;
import static org.ismaelviss.userSearch.cli.CommanderFunctions.parseArguments;

public class UserSearch {
    private static Logger logger =  LogManager.getLogger(UserSearch.class);
    public static void main(String[] args) {



        args = new String[]{"prueba","--limit", "11"};
        Arrays.stream(args).forEach(System.out::println);

        JCommander jCommander = buildCommanderWithName("user-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);


        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI
                        .filter(cli -> !cli.isHelp())
                        .filter(cli -> cli.getLimit() != null)
                        .filter(cli -> cli.getKeyword() != null)
                        .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(UserSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<Datum> executeRequest(Map<String, Object> params) {
        APIUsers api = buildAPI(APIUsers.class, "https://dummyapi.io/data/v1");

        return Stream.of(params)
                .map(api::users)
                .flatMap(x ->  x.getData().stream());
    }
}
