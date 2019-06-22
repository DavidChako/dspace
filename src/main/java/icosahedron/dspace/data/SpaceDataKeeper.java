package icosahedron.dspace.data;

import org.springframework.jdbc.core.JdbcTemplate;

public class SpaceDataKeeper {
    private final JdbcTemplate jdbcTemplate;

    public SpaceDataKeeper(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void insert(final GenericTetray tetray) {
//        this.jdbcTemplate.update(GenericTetray.INSERT_TEMPLATE, tetray);
//    }
//    public class UserDaoImpl implements UserDao {
//
//        private final String INSERT_SQL = "INSERT INTO USERS(name,address,email) values(?,?,?)";
//        private final String FETCH_SQL = "select record_id, name, address, email from users";
//        private final String FETCH_SQL_BY_ID = "select * from users where record_id = ?";
//
//        @Autowired
//        private JdbcTemplate jdbcTemplate;
//
//        public User create(final User user) {
//            KeyHolder holder = new GeneratedKeyHolder();
//            jdbcTemplate.update(new PreparedStatementCreator() {
//                @Override
//                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                    PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
//                    ps.setString(1, user.getName());
//                    ps.setString(2, user.getAddress());
//                    ps.setString(3, user.getEmail());
//                    return ps;
//                }
//            }, holder);
//
//            int newUserId = holder.getKey().intValue();
//            user.setId(newUserId);
//            return user;
//        }
//
//        public List findAll() {
//            return jdbcTemplate.query(FETCH_SQL, new UserMapper());
//        }
//
//        public User findUserById(int id) {
//            return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new UserMapper());
//        }
//
}
