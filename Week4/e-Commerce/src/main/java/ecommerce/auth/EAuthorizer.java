package ecommerce.auth;

import io.dropwizard.auth.Authorizer;

public class EAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("krishna") && role.equals("ADMIN");
    }
}
