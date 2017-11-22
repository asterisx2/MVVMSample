package ashwin.work.mvvmsample.Model.DAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ashwin on 21/11/17.
 */

@Database(entities = {User.class, Page.class}, version = 2, exportSchema = false)
abstract public class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "UserDb";

    public abstract UserDao userDao();

    public abstract PageDao pageDao();
}