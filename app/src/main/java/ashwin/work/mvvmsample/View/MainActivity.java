package ashwin.work.mvvmsample.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import ashwin.work.mvvmsample.R;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;

/**
 * Created by ashwin on 21/11/17.
 */

public class MainActivity extends AppCompatActivity {


    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView recyclerView = findViewById(R.id.userList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        final UserAdapter userUserAdapter = new UserAdapter(viewModel);

        viewModel.userList.observe(this, pagedList -> {
            userUserAdapter.setList(pagedList);
        });

        recyclerView.setAdapter(userUserAdapter);

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
