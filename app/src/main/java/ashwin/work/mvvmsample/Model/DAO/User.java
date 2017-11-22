package ashwin.work.mvvmsample.Model.DAO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

/**
 * Created by ashwin on 21/11/17.
 */

@Entity
public class User extends BaseObservable {
    @Ignore
    public static DiffCallback<User> DIFF_CALLBACK = new DiffCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.userId == newItem.userId;
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    public long userId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    public String address;

    @Override
    @Ignore
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        User user = (User) obj;

        return user.userId == this.userId && user.firstName == this.firstName;
    }

    @Override
    @Ignore
    public String toString(){
        return "["+Long.toString(userId)+"] "+"My name is: "+firstName+", and I live in "+address+".";
    }
}
