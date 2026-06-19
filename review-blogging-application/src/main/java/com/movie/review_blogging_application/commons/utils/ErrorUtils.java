package com.movie.review_blogging_application.commons.utils;

import com.movie.review_blogging_application.commons.constants.ProjectConstants;
import com.movie.review_blogging_application.commons.payload.Error;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ErrorUtils {
    private ErrorUtils(){}

    public static String runtimeExceptionMessageBuilder(Set<Error> validationMessages){
        StringBuilder builder = new StringBuilder();
        int len = validationMessages.size();
        int i = 0;
        for(Error error: validationMessages){
            i++;
            builder.append(error.getMessage());
            if(i != len){
                builder.append(ProjectConstants.COMMA);
            }
        }
        return Objects.toString(builder, "");
    }

    public static String runtimeExceptionMessageBuilder(List<Error> validationMessages){
        StringBuilder builder = new StringBuilder();
        int len = validationMessages.size();
        int i = 0;
        for(Error error: validationMessages){
            i++;
            builder.append(error.getMessage());
            if(i != len){
                builder.append(ProjectConstants.COMMA);
            }
        }
        return Objects.toString(builder, "");
    }

    public static <T> Set<Error> errorTypeCast(Set<T> errors){
        return errors.stream()
                .filter(Error.class::isInstance)
                .map(Error.class::cast)
                .collect(Collectors.toSet());
    }
}
