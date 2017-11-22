package ashwin.work.mvvmsample.Dagger.Module;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import javax.inject.Inject;

import ashwin.work.mvvmsample.View.UserAdapter;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by ashwin on 22/11/17.
 */
@Module
public class ViewModule {


    @Provides
    public UserAdapter providesUserAdapter(){
        return new UserAdapter();
    }



}
