package ecommerce;

import ecommerce.auth.EAuthenticator;
import ecommerce.auth.EAuthorizer;
import ecommerce.auth.User;
import ecommerce.exceptions.BadRequestExceptionMapper;
import ecommerce.exceptions.NotFoundExceptionMapper;
import ecommerce.resouces.ProductsAPI;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ECommerceApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new ECommerceApplication().run(args);
    }

    @Override
    public String getName() {
        return "ECommerce";
    }

    @Override
    public void run(Configuration configuration, final Environment environment) {
        final ProductsAPI productsAPI = new ProductsAPI();
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new EAuthenticator())
                .setAuthorizer(new EAuthorizer())
                .setRealm("SUPER SECRET STUFF")
                .buildAuthFilter()));
        environment.jersey().register(NotFoundExceptionMapper.class);
        environment.jersey().register(BadRequestExceptionMapper.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(productsAPI);
    }
}
