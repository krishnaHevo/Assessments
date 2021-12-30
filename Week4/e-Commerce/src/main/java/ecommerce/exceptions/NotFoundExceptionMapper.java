package ecommerce.exceptions;

import io.dropwizard.jersey.errors.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotFoundExceptionMapper.class);

    public Response toResponse(final NotFoundException exception) {
        LOGGER.info("NotFound failure", exception);
        Response response;
        final String details = "Violated " + exception.getCause() + " constraint.";
        response = Response.status(NOT_FOUND)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .entity(new ErrorMessage(NOT_FOUND.getStatusCode(), "Value not found", details))
                        .build();
        return response;
    }
}