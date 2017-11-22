package ashwin.work.mvvmsample.Model.DAO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

/**
 * Created by ashwin on 22/11/17.
 */
@Entity
public class Page {
    @Ignore
    public static DiffCallback<Page> DIFF_CALLBACK = new DiffCallback<Page>() {
        @Override
        public boolean areItemsTheSame(@NonNull Page oldItem, @NonNull Page newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Page oldItem, @NonNull Page newItem) {
            return oldItem.login==newItem.login&&oldItem.page==newItem.page&&oldItem.perPage==newItem.perPage;
        }
    };

    public Page(int page, int perPage, String login)
    {
        this.page=page;
        this.perPage=perPage;
        this.login=login;
    }

    @PrimaryKey(autoGenerate = true)
    public long id;

    public int page;

    public int perPage;

    public String login;
}
