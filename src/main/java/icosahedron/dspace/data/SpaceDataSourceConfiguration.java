package icosahedron.dspace.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SpaceDataSourceConfiguration {
    @Bean
    public SpaceDataSourceFactory dataSourceFactory() {
        return new SpaceDataSourceFactory();
    }

    @Bean
    public DataSource dataSource(final SpaceDataSourceFactory dataSourceFactory) {
        return dataSourceFactory.createEmbeddedH2DataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
