package icosahedron.dspace.test


import icosahedron.dspace.data.SpaceDataKeeper
import icosahedron.dspace.data.SpaceDataSourceFactory
import icosahedron.dspace.pole.Tetray
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Shared
import spock.lang.Specification

final class SpaceDataKeeperSpec extends Specification {
    @Shared factory = new SpaceDataSourceFactory()
    @Shared dataSource = factory.createEmbeddedH2DataSource()
    @Shared jdbcTemplate = new JdbcTemplate(dataSource)

    def "constructor sets jdbcTemplate by direct reference"() {
        given:
        def dataKeeper = new SpaceDataKeeper(this.jdbcTemplate)
        def jdbcTemplateField = dataKeeper.class.getDeclaredField("jdbcTemplate")
        jdbcTemplateField.setAccessible(true)

        when:
        def actualJdbcTemplate = jdbcTemplateField.get(dataKeeper)

        then:
        actualJdbcTemplate.is(jdbcTemplate)
    }

    def "insert and then retrieve #entity"() {
        given:
        def dataKeeper = new SpaceDataKeeper(this.jdbcTemplate)

        when:
        dataKeeper.insert(entity)

        then:
        def retrievedEntity = dataKeeper.retrieve()
        where:
        entity << [ new Tetray(1,1,1,1) ]
    }
}
