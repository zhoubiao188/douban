//import com.cn.scitc.mapper.MovieMapper;
//import com.cn.scitc.model.Movie;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//
//public class Test {
//    @org.junit.Test
//    public void fun1(){
//        SqlSessionFactory s;
//        try {
//            s  = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
//            SqlSession session = s.openSession();
//            MovieMapper dao = session.getMapper(MovieMapper.class);
//            Movie movie = new Movie();
//            movie.setId("111111111");
//            movie.setRate("wwww");
//            movie.setTitle("aaaaaa");
//            movie.setCasts("assssss");
//            movie.setCover("assssssss");
//            dao.insert(movie);
//            session.commit();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
