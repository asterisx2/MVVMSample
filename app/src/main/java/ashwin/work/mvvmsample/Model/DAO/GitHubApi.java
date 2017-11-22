package ashwin.work.mvvmsample.Model.DAO;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashwin on 22/11/17.
 */

public class GitHubApi {
    public static GitHubService createGitHubService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .baseUrl("https://api.github.com");

        return builder.build().create(GitHubService.class);
    }
}
