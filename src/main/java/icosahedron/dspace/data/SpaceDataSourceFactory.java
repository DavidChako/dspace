package icosahedron.dspace.data;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public final class SpaceDataSourceFactory {
    public final DataSource createEmbeddedH2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("DSPACE")
                .addScript("sql/table/Location.sql")
                .addScript("sql/table/Weight.sql")
                .build();
    }
}
