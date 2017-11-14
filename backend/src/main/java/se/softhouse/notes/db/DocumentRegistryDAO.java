package se.softhouse.notes.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import se.softhouse.notes.db.entity.DocumentRegistry;

import java.util.List;
import java.util.Optional;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface DocumentRegistryDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS `registry` (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +  //
            "title VARCHAR(12) NOT NULL, " + //
            "text VARCHAR(255) NOT NULL)")
    void createTable();

    @SqlQuery("select * FROM `registry`")
    List<DocumentRegistry> selectAll();

    @SqlQuery("select * FROM `registry` WHERE id = :id")
    Optional<DocumentRegistry> get( @Bind("id") int id);

    @SqlUpdate("INSERT INTO `registry` (title, text) VALUES(:title, :text)")
    void insert(@BindBean DocumentRegistry documentRegistry);

    @SqlUpdate("UPDATE `registry` set title = :title, text = :text WHERE id = :id")
    void update(@BindBean DocumentRegistry documentRegistry);

    @SqlUpdate("DELETE FROM `registry` WHERE id = :id")
    void delete(@BindBean("id") int id);


}
