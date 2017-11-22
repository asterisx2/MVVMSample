package ashwin.work.mvvmsample.Model.DAO;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ashwin on 22/11/17.
 */

public interface PageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Page> pages);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Page... page);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updatePage(Page... page);

    @Delete
    public void deletePage(Page... page);

    @Query("SELECT count(*) FROM Page Where page=:page & perPage=:perPage & login=:login")
    public abstract int hasPage(int page, int perPage, String login);
}
