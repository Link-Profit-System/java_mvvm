package org.common;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

import java.util.Properties;

public class GeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(final Definition definition, final Mode mode) {

        String name = super.getJavaClassName(definition, mode);

        switch (mode) {
            case POJO:
                return name + "Vo";
            case DEFAULT:
                return 'J' + name;
        }

        return name;
    }
}
