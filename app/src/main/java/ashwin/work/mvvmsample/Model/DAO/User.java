package ashwin.work.mvvmsample.Model.DAO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashwin on 21/11/17.
 */

@Entity
public class User extends BaseObservable {
    @Ignore
    public static DiffCallback<User> DIFF_CALLBACK = new DiffCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };
    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    public Integer id;
    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    public String gravatarId;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("followers_url")
    @Expose
    public String followersUrl;
    @SerializedName("following_url")
    @Expose
    public String followingUrl;
    @SerializedName("gists_url")
    @Expose
    public String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    public String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    public String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    public String organizationsUrl;
    @SerializedName("repos_url")
    @Expose
    public String reposUrl;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("received_events_url")
    @Expose
    public String receivedEventsUrl;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("site_admin")
    @Expose
    public Boolean siteAdmin;



    @Override
    @Ignore
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        User user = (User) obj;

        return user.id == this.id && user.login == this.login;
    }

    @Override
    @Ignore
    public String toString(){
        return "["+Long.toString(id)+"] "+"The login name is: "+login+".";
    }
}
