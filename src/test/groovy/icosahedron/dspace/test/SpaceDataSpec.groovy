package icosahedron.dspace.test

import icosahedron.dspace.data.SpaceDataSourceConfiguration
import icosahedron.dspace.data.SpaceDataSourceFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.ThreadLocalRandom

@ContextConfiguration(classes = [SpaceDataSourceConfiguration])
final class SpaceDataSpec extends Specification {
    @Autowired JdbcTemplate jdbcTemplate

    @Shared random = ThreadLocalRandom.current()

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "exercise location table"() {
        given:
        List<List> intendedRecords = []
        def intendedRecordStrings = (1..10).collect {
            def x0 = random.nextLong(0, Long.MAX_VALUE)
            def x1 = random.nextLong(0, Long.MAX_VALUE)
            def x2 = random.nextLong(0, Long.MAX_VALUE)
            def x3 = random.nextLong(0, Long.MAX_VALUE)
            intendedRecords.add([ x0, x1, x2, x3 ])
            '[ID:' + it + ', X0:' + x0 + ', X1:' + x1 + ', X2:' + x2 + ', X3:' + x3 + ']'
        }

        when:
        intendedRecords.each {
            def sql = 'insert into Location(x0, x1, x2, x3) values(' + it.join(',') + ')'
            jdbcTemplate.update(sql)
        }

        then:
        def actualRecords = jdbcTemplate.queryForList("select * from Location")
        def actualRecordsText = actualRecords.join('\n')
        println(actualRecordsText)
        actualRecords.size() == intendedRecords.size()

        and:
        actualRecordsText == intendedRecordStrings.join('\n')
    }

    def "exercise weight table"() {
        given:
        List<List> intendedRecords = []
        def intendedRecordStrings = (1..10).collect {
            def x0 = random.nextLong(0, Long.MAX_VALUE)
            def x1 = random.nextLong(0, Long.MAX_VALUE)
            def x2 = random.nextLong(0, Long.MAX_VALUE)
            def x3 = random.nextLong(0, Long.MAX_VALUE)
            intendedRecords.add([ x0, x1, x2, x3 ])
            '[ID:' + it + ', X0:' + x0 + ', X1:' + x1 + ', X2:' + x2 + ', X3:' + x3 + ']'
        }

        when:
        intendedRecords.each {
            def sql = 'insert into Location(x0, x1, x2, x3) values(' + it.join(',') + ')'
            jdbcTemplate.update(sql)
        }

        then:
        def actualRecords = jdbcTemplate.queryForList("select * from Location")
        def actualRecordsText = actualRecords.join('\n')
        println(actualRecordsText)
        actualRecords.size() == intendedRecords.size()

        and:
        actualRecordsText == intendedRecordStrings.join('\n')
    }
}
