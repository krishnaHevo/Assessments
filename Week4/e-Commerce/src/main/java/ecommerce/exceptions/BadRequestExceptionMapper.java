package ecommerce.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.CONFLICT;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestExceptionMapper.class);

    public Response toResponse(final BadRequestException exception) {
        LOGGER.info("Bad request", exception);
        Response response;
        final String details = "Violated " + exception.getCause() + " constraint.";
        response = Response.status(CONFLICT)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new ErrorMessage(CONFLICT.getStatusCode(), "Bad request", details))
                .build();
        return response;
    }
}
