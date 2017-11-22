package ashwin.work.mvvmsample.View;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ashwin.work.mvvmsample.BR;
import ashwin.work.mvvmsample.Model.User;
import ashwin.work.mvvmsample.R;
import ashwin.work.mvvmsample.ViewModel.UserViewModel;
import ashwin.work.mvvmsample.databinding.ItemUserListBinding;

/**
 * Created by ashwin on 21/11/17.
 */

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserItemViewHolder> {
    UserViewModel model;

    protected UserAdapter(UserViewModel model) {
        super(User.DIFF_CALLBACK);
        this.model=model;
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_list, parent, false);
        UserItemViewHolder holder = new UserItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        User user= getItem(position);
        if(user!=null) {
            ItemUserListBinding viewDataBinding = holder.getBinding();
            viewDataBinding.setVariable(BR.user, user);
            viewDataBinding.setVariable(BR.handler, model);
            viewDataBinding.executePendingBindings();

        }
    }

    static class UserItemViewHolder extends RecyclerView.ViewHolder {
        private ItemUserListBinding mBinding;


        public UserItemViewHolder(View v) {
            super(v);
            mBinding= DataBindingUtil.bind(v);
        }

        public ItemUserListBinding getBinding(){
            return mBinding;
        }

    }
}
