package ashwin.work.mvvmsample.Model.DAO;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import ashwin.work.mvvmsample.Dagger.App;

/**
 * Created by ashwin on 22/11/17.
 */

public class DAOHelper {
    @Inject
    Context context;

    public AppDatabase appDatabase;
    UserDao userDao;
    PageDao pageDao;
    public DAOHelper(){
        App.getComponent().inject(this);
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
            userDao=appDatabase.userDao();
            pageDao=appDatabase.pageDao();
    }


}
