import config.dao.BlogMapper;
import config.pojo.Blog;
import config.utils.IDUtils;
import config.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void TestUUId(){
        IDUtils idUtils =new IDUtils();
        System.out.println(idUtils.getId());
    }
    @Test
    public void insertBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog =new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis学习");
        blog.setAuthor("GF的小跟班");
        blog.setCreateTime(new Date());
        blog.setViews(1999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis测试");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        sqlSession.close();
    }
    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","GF的小跟班");
        List<Blog> blogList = mapper.queryBlogIf(map);
        for(Blog blog : blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","GF的小跟班");
        map.put("views",1999);
        List<Blog> blogList = mapper.queryBlogChoose(map);
        for(Blog blog : blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Mybatis学习2");
        // map.put("views",1999);
        map.put("id","1");


        mapper.updateBlog(map);
        sqlSession.close();
    }
}
