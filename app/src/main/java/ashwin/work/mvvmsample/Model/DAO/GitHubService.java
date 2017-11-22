package ashwin.work.mvvmsample.Model.DAO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ashwin on 22/11/17.
 */

public interface GitHubService {
    @GET("/users/{userName}/followers")
    Call<List<User>> getUsers(@Query("page") int page, @Query("per_page") int perPage, @Path("userName") String login);
}

