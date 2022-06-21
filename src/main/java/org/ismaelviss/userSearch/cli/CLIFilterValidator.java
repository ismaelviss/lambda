package org.ismaelviss.userSearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIFilterValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("[0-9a-z]+&")) {
            System.err.println("El criterio de busqueda no es valido");
            throw new ParameterException("Unicamente numeros enteros positivos");
        }
    }
}
