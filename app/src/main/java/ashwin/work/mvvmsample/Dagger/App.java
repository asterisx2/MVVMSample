package ashwin.work.mvvmsample.Dagger;

import android.app.Application;

import ashwin.work.mvvmsample.Dagger.Component.AppComponent;
import ashwin.work.mvvmsample.Dagger.Component.DaggerAppComponent;
import ashwin.work.mvvmsample.Dagger.Module.DatabaseModule;
import ashwin.work.mvvmsample.Dagger.Module.AppModule;
import ashwin.work.mvvmsample.Dagger.Module.ViewModule;

/**
 * Created by ashwin on 22/11/17.
 */

public class App extends Application {
    private static AppComponent component;
    public static AppComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        component=buildComponent();
    }

    private AppComponent buildComponent() {

        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .viewModule(new ViewModule())
                .build();
    }
}
