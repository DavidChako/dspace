package icosahedron.dspace.test

import icosahedron.dspace.data.SpaceDataSourceConfiguration
import icosahedron.dspace.data.SpaceDataSourceFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

final class SpaceDataSourceFactorySpec extends Specification {
    def "create and exercise embedded H2 datasource"() {
        given:
        def factory = new SpaceDataSourceFactory()

        when:
        def dataSource = factory.createEmbeddedH2DataSource()

        then:
        dataSource
    }

//    def "exercise embedded H2 datasource"() {
//        given:
//        def factory = new SpaceDataSourceFactory()
//        def dataSource = factory.createEmbeddedH2DataSource()
//        def jdbcTemplate = new JdbcTemplate(dataSource)
//
//        when:
//
//        then:
//
//        and:
//    }
}
