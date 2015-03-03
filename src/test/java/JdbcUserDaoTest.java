import com.tyurin.dao.JdbcUserDao;
import com.tyurin.dao.UserDao;
import com.tyurin.domain.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JdbcUserDaoTest {

    private UserDao userDao = new JdbcUserDao();

    @Test
    public void findOneTest() {
        User user = userDao.findOne(1001L);
        assertNotNull(user);
    }

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }
}
