package ashwin.work.mvvmsample.Dagger.Module;

import android.content.Context;

import javax.inject.Inject;

import ashwin.work.mvvmsample.Model.DAO.AppDatabase;
import ashwin.work.mvvmsample.Model.DAO.DAOHelper;
import ashwin.work.mvvmsample.Model.DAO.UserDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ashwin on 22/11/17.
 */
@Module
public class DatabaseModule {
    @Inject
    Context context;


    @Provides
    public AppDatabase providesDatabase(){
        return new DAOHelper().appDatabase;
    }


    @Provides
    @Inject
    public UserDao providesUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }

}
