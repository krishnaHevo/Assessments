package ecommerce.resouces;

import ecommerce.db.ProductsDB;
import ecommerce.representations.Product;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RolesAllowed("ADMIN")
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductsAPI {
    ProductsDB db = new ProductsDB();

    @GET
    public Response findAll() {
        List<Product> products = db.getAllProducts();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response findByID(@PathParam("id") Integer id) throws NotFoundException {
        Product product = db.getProductByID(id);
        if(product != null)
            return Response.ok(product).build();
        throw new NotFoundException();
    }

    @POST
    public Response post(Product product) {
        if(db.getProductByID(product.getId()) == null) {
            db.addProduct(product);
            return Response.ok().build();
        }
        throw new BadRequestException();
    }

    @PUT
    @Path("/{id}")
    public Response put(@PathParam("id") Integer id, Product product) {
        if(db.getProductByID(id) != null) {
            db.updateProduct(id, product);
            return Response.ok(product).build();
        }
        throw new BadRequestException();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) throws NotFoundException {
        boolean deleted = db.removeProduct(id);
        if(deleted)
            return Response.ok().build();
        throw new NotFoundException();
    }
}
