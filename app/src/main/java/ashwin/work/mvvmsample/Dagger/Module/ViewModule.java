package ashwin.work.mvvmsample.Dagger.Module;


import ashwin.work.mvvmsample.View.UserAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {


    @Provides
    public UserAdapter providesUserAdapter(){
        return new UserAdapter();
    }

}
