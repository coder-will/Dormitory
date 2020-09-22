import com.zj.dao.AdminMapper;
import com.zj.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void TestFindAdmin() throws IOException {
        String s = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(s);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.deleteAdmin(15);
        sqlSession.commit();
        sqlSession.close();

    }

}
