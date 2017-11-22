package ashwin.work.mvvmsample.View.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ashwin.work.mvvmsample.Dagger.App;
import ashwin.work.mvvmsample.R;

import ashwin.work.mvvmsample.View.UserAdapter;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;

import java.util.List;


public class UserFragment extends Fragment implements UserViewModel.ChangeLoginName {

    // TODO: Customize parameter argument names

    //@Inject
    UserViewModel viewModel;

    //@Inject
    UserAdapter userAdapter;

    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserFragment() {
        App.getComponent().inject(this);

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView= getActivity().findViewById(R.id.recyclerView);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userAdapter = new UserAdapter(viewModel);

        viewModel.userList.observe(this, pagedList -> {
            userAdapter.setList(pagedList);
        });

        viewModel.setChangeLoginNameListener(this);

        recyclerView.setAdapter(userAdapter);
        showChangeUsernameDialog();
        return view;
    }
    public void showChangeUsernameDialog(){

    }
    public void setUsername(String s){
        viewModel.setLogin(s);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_insert:
                showChangeUsernameDialog();
                break;
        }
        return true;
    }

    @Override
    public void showLoginChange() {

    }

    @Override
    public void hideLoginChange() {

    }
}
