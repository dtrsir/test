import com.zhong.dao.book.BookMapper;
import com.zhong.pojo.Book;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BookMapperTest {

    //通过图书id获取图书信息
    @Test
    public void getBookByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = mapper.getBookById(1);

        System.out.println("=====================================");
        System.out.println(book);
        System.out.println("=====================================");

        sqlSession.close();
    }

    //通过条件查询图书(通过map传递参数)。 书名，作者，出版社，库存（分页currentPageNo和PageSize）
    @Test
    public void getBookListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("author", "小c");
        map.put("publisher", "中国教育出版社");
        map.put("from", 0);
        map.put("pageSize", 5);

        List<Book> bookList = mapper.getBookList(map);


        System.out.println("=======================================");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("=======================================");

        sqlSession.close();
    }

    //通过条件统计图书数量。作者，出版社，库存
    @Test
    public void getBookCountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        HashMap map = new HashMap();
        map.put("stock", 5);

        int bookCount = mapper.getBookCount(map);

        System.out.println("==================================");
        System.out.println("book have " + bookCount);
        System.out.println("==================================");

        sqlSession.close();
    }

    //查询某一个时间段内出版的图书
    @Test
    public void getBookByPublicTimeTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        //获得一个日历类的实例
        Calendar calendar = Calendar.getInstance();

        //封装指定日期
        calendar.set(2001,0,1);
        //转换称date类
        Date time1 = calendar.getTime();
        calendar.set(2011,0,1);
        Date time2 = calendar.getTime();

        mapper.getBookByPublicTime(time1, time2,0,5);
        sqlSession.close();
    }

    //添加图书
    @Test
    public void addBookTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Calendar instance = Calendar.getInstance();
        instance.set(2002, 1, 1);
        Date time = instance.getTime();
        BigDecimal bigDecimal = new BigDecimal(123.00);
        Book book = new Book(4, "jsp设计", "小j", "中国教育出版社", time, bigDecimal, 10, 1, new Date(), null,null);
        int row = mapper.addBook(book);
        if (row > 0) {
            System.out.println("========================");
            System.out.println("insert success!!");
            System.out.println("========================");
        }else {
            System.out.println("========================");
            System.out.println("insert fail!!");
            System.out.println("========================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //通过id删除图书
    @Test
    public void deleteBookTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int row = mapper.deleteBook(4);
        if (row > 0) {
            System.out.println("========================");
            System.out.println("delete success!!");
            System.out.println("========================");
        }else {
            System.out.println("========================");
            System.out.println("delete fail!!");
            System.out.println("========================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //修改图书信息
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book(4, null, null, null, null, null, null, null, null, 1, new Date());
        int row = mapper.modify(book);
        if (row > 0) {
            System.out.println("========================");
            System.out.println("modify success!!");
            System.out.println("========================");
        }else {
            System.out.println("========================");
            System.out.println("modify fail!!");
            System.out.println("========================");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
