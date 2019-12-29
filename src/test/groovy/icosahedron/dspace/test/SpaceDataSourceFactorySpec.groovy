package icosahedron.dspace.test


import icosahedron.dspace.data.SpaceDataSourceFactory
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
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
