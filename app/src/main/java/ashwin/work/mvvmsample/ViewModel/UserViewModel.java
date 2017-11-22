package ashwin.work.mvvmsample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import ashwin.work.mvvmsample.Dagger.App;
import ashwin.work.mvvmsample.Model.DAO.GitHubService;
import ashwin.work.mvvmsample.Model.DAO.PageDao;
import ashwin.work.mvvmsample.Model.DAO.Page;
import ashwin.work.mvvmsample.Model.DAO.User;
import ashwin.work.mvvmsample.Model.DAO.UserDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ashwin on 21/11/17.
 */

public class UserViewModel extends AndroidViewModel {

    @Inject
    Context context;

    @Inject
    UserDao userDao;

    @Inject
    PageDao pageDao;

    private ChangeLoginName _changeLoginName;

    int page=1;
    int per_page=20;

    private String login;
    @Inject
    GitHubService gitHubService;
    public LiveData<PagedList<User>> userList;


    @Inject
    public UserViewModel(Application application) {
        super(application);
        App.getComponent().inject(this);
        init();
    }
    public void onItemClick(String login){
        Log.i("Item Clicked",login);
    }
    public void init() {
        userList = userDao.usersByFirstName().create(0,
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(10)
                        .setPrefetchDistance(5)
                        .build());
    }
    private void getUsers() {
        if (pageDao.hasPage(page, per_page, login) == 0) {

            Call<List<User>> call = gitHubService.getUsers(page, per_page, login);

            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        new AsyncTask<Void, Void, Void>() {
                            @Override
                            protected Void doInBackground(Void... voids) {
                                userDao.insertAll(response.body());
                                pageDao.insert(new Page(page, per_page, login));
                                page++;
                                return null;
                            }
                        }.execute();
                    } else {
                        showError();
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    showError();
                }
            });
        }
    }
    public void setLogin(String s){
        this.login=s;
    }
    public void hide(){
        _changeLoginName.hideLoginChange();
    }
    public void show(){
        _changeLoginName.showLoginChange();
    }
    public void showError(){
        if(context!=null)
        Toast.makeText(context, "Error fetching values", Toast.LENGTH_LONG);
    }
    public void loadMoreFollowers(){
        getUsers();
    }
    public void loadFollowers_new() {
        if(login=="") {
            show();
        return;
        }
        hide();
        page=1;
        getUsers();
    }
    public void setChangeLoginNameListener(ChangeLoginName changeLoginName){
     _changeLoginName=changeLoginName;
    }
    public interface ChangeLoginName{
        void showLoginChange();

        void hideLoginChange();

    }
}
