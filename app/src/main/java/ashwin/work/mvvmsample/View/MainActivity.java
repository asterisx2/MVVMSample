package ashwin.work.mvvmsample.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import javax.inject.Inject;

import ashwin.work.mvvmsample.Dagger.App;
import ashwin.work.mvvmsample.R;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;

/**
 * Created by ashwin on 21/11/17.
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



}
