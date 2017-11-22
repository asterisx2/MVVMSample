package ashwin.work.mvvmsample.Dagger.Module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashwin on 22/11/17.
 */
@Module
public class AppModule {

    private Context appContext;

    public AppModule(@NonNull Context context){
        appContext=context;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return appContext;
    }
}
