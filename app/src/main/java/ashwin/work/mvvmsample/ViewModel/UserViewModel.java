package ashwin.work.mvvmsample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.os.AsyncTask;
import android.util.Log;

import javax.inject.Inject;

import ashwin.work.mvvmsample.Dagger.App;
import ashwin.work.mvvmsample.Model.DAO.AppDatabase;
import ashwin.work.mvvmsample.Model.DAO.User;
import ashwin.work.mvvmsample.Model.DAO.UserDao;
import ashwin.work.mvvmsample.Utils.DatabaseCreator;

/**
 * Created by ashwin on 21/11/17.
 */

public class UserViewModel extends AndroidViewModel {


    @Inject
    AppDatabase database;

    @Inject
    UserDao dao;
    public LiveData<PagedList<User>> userList;


    @Inject
    public UserViewModel(Application application) {
        super(application);
        App.getComponent().inject(this);
        init();
    }
    public void onItemClick(User user){
        Log.i("Item Clicked",user.toString());
    }
    public void init() {
        userList = dao.usersByFirstName().create(0,
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(10)
                        .setPrefetchDistance(5)
                        .build());
    }
    public void insertUser() {
        final DatabaseCreator databaseCreator = new DatabaseCreator();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insertAll(databaseCreator.getRandomUserList());
                return null;
            }
        }.execute();
    }
}
