package business.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

//初始化，并存储SqlSessionFactory
public class MybatisFactory {

    private Logger logger = LoggerFactory.getLogger(MybatisFactory.class);

    private static SqlSessionFactory factory = null;

    public void init() {
        try {
            if (factory == null){
                String resource = "mybatis_config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                factory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }catch (IOException e){
            logger.error("初始化MyBatis失败，错误:",e);
        }
    }

    public static SqlSession getSqlSession(){
        return factory.openSession();
    }

}