package reqres.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import reqres.entities.*;

public interface UserClient {
    @RequestLine("GET /users/{id}")
    User findByID(@Param("id") int id);

    @RequestLine("GET /users?page={num}")
    UserList findByPage(@Param("num") int num);

    @RequestLine("POST /users")
    @Headers("Content-Type: application/json")
    UserCreationResponse createUser(UserCreationReq user);

    @RequestLine("POST /register")
    @Headers("Content-Type: application/json")
    RegResponse register(Register user);

    @RequestLine("PUT /users/{num}")
    @Headers("Content-Type: application/json")
    UserUpdationResponse updateUser(UserCreationReq user, @Param("num") int num);

    @RequestLine("DELETE /users/{id}")
    void deleteUser(@Param("id") int id);
}
