package reqres;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import reqres.client.UserClient;
import reqres.entities.*;

public class Main {
    public static void main(String args[])
    {
        UserClient client1 = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(UserClient.class, "https://reqres.in/api");

        //GET
        System.out.println(client1.findByID(2));

        //GET Pagination
        int page = 1;
        while(page <= client1.findByPage(page).getTotal_pages()) {
            System.out.println(client1.findByPage(page));
            page += 1;
        }

        //POST user
        UserCreationReq u1 = new UserCreationReq("krishna", "leader");
        UserCreationResponse response1 = client1.createUser(u1);
        System.out.println(response1);

        //PUT user
        UserCreationReq u2 = new UserCreationReq("morpheus", "zion resident");
        UserUpdationResponse response2 = client1.updateUser(u2, 2);
        System.out.println(response2);


        //DELETE user
        client1.deleteUser(2);

        //GET User Not Found
        try {
            System.out.println(client1.findByID(Integer.parseInt(response1.getId())));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //POST to register user
        Register r1 = new Register("eve.holt@reqres.in",
                "pistol");
        System.out.println(client1.register(r1));
    }
}
