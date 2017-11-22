package ashwin.work.mvvmsample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.util.Log;

import ashwin.work.mvvmsample.Model.AppDatabase;
import ashwin.work.mvvmsample.Model.User;
import ashwin.work.mvvmsample.Model.UserDao;
import ashwin.work.mvvmsample.Utils.DatabaseCreator;

/**
 * Created by ashwin on 21/11/17.
 */

public class UserViewModel extends AndroidViewModel {
    AppDatabase appDatabase;
    UserDao userDao;
    public LiveData<PagedList<User>> userList;


    public UserViewModel(Application application) {
        super(application);
        appDatabase = Room.databaseBuilder(getApplication(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        userDao = appDatabase.userDao();
        init();
    }
    public void onItemClick(User user){
        Log.i("Item Clicked",user.toString());
    }
    public void init() {
        userList = userDao.usersByFirstName().create(0,
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
                appDatabase.userDao().insertAll(databaseCreator.getRandomUserList());
                return null;
            }
        }.execute();
    }
}
