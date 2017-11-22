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

    //@Inject
    UserViewModel viewModel;

    //@Inject
    UserAdapter userAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);

        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userAdapter = new UserAdapter(viewModel);

        viewModel.userList.observe(this, pagedList -> {
            userAdapter.setList(pagedList);
        });

        recyclerView.setAdapter(userAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_insert:
                viewModel.insertUser();
                break;
        }
        return true;
    }


}
