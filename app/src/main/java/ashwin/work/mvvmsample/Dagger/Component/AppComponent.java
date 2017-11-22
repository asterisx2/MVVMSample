package ashwin.work.mvvmsample.Dagger.Component;

import javax.inject.Singleton;

import ashwin.work.mvvmsample.Dagger.Module.AppModule;
import ashwin.work.mvvmsample.Dagger.Module.DatabaseModule;
import ashwin.work.mvvmsample.Dagger.Module.ViewModule;
import ashwin.work.mvvmsample.Model.DAO.DAOHelper;
import ashwin.work.mvvmsample.View.Fragments.UserFragment;
import ashwin.work.mvvmsample.View.MainActivity;
import ashwin.work.mvvmsample.View.UserAdapter;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;
import dagger.Component;

/**
 * Created by ashwin on 22/11/17.
 */
@Component(modules = {ViewModule.class, AppModule.class, DatabaseModule.class})
@Singleton
public interface AppComponent {

    void inject(UserFragment userFragment);

    void inject(UserViewModel model);

    void inject(UserAdapter adapter);

    void inject(DAOHelper helper);
}
