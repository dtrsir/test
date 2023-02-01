import com.zhong.dao.BlogMapper;
import com.zhong.pojo.Blog;
import com.zhong.utils.IdUtils;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java");
        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring");
        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("微服务");
        mapper.addBook(blog);

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("title","Java");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String,String> map = new HashMap<String,String>();

        map.put("author","狂神说1");
        map.put("title","Java1");
        map.put("id","51997c2de5674c4a9c3208d7095875fc");

        int i = mapper.updateBlog(map);

        if (i>0) {
            System.out.println("success!");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        map.put("ids",ids);



        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }


        sqlSession.close();

    }


}

