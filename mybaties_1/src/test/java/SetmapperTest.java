import cn.edu.cqwu.mapper.SetMapper;
import cn.edu.cqwu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SetmapperTest {
    @Test
    public  void DeleteStudentInterface() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SetMapper setMapper=sqlSession.getMapper(SetMapper.class);
        int i=setMapper.deleteStudent(3);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public  void UpdateStudentInterface() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SetMapper setMapper=sqlSession.getMapper(SetMapper.class);
        Student student=new Student();
        student.setId(3);
        student.setMajor("dddddd");
        int i=setMapper.updateStudent(student);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public  void InsertStudentInterface() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SetMapper setMapper=sqlSession.getMapper(SetMapper.class);
        Student student=new Student();
        student.setId(3);
        student.setName("set3");
        student.setSno(1222);
        student.setMajor("cccccc");
        int i=setMapper.insertStudent(student);
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public  void SelectAllStudentInterface() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SetMapper setMapper=sqlSession.getMapper(SetMapper.class);
        List<Student> students=setMapper.selectAllStudent();
        sqlSession.commit();
        System.out.println(students);
    }
    @Test
    public  void SelectStudentInterface() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //得到一个mapper
        SetMapper setMapper=sqlSession.getMapper(SetMapper.class);
        //通过mapper调用接口方法
        Student student=setMapper.selectStudent(2);
        sqlSession.commit();
        System.out.println(student);
    }


    @Test
    public  void DeleteStudent() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.insert("cn.edu.cqwu.mapper.SetMapper.deleteStudent",3);
//        删除的时候开起数据库事务，所以要提交事务
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public  void UpdateStudent() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Student student=new Student();
        student.setId(3);
        student.setMajor("bbb");
        int i=sqlSession.insert("cn.edu.cqwu.mapper.SetMapper.updateStudent",student);
//        修改的时候开起数据库事务，所以要提交事务
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public  void InsertStudent() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Student student=new Student();
        student.setId(3);
        student.setName("set2");
        student.setSno(12);
        student.setMajor("aaa");
        int i=sqlSession.insert("cn.edu.cqwu.mapper.SetMapper.insertStudent",student);
//        插入的时候开起数据库事务，所以要提交事务
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public  void SelectAllStudent() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<Student> students=sqlSession.selectList("cn.edu.cqwu.mapper.SetMapper.selectAllStudent");
        System.out.println(students);
    }
    @Test
    public  void SelectStudent() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
//        映射文件的namespace和id
        Student student=sqlSession.selectOne("cn.edu.cqwu.mapper.SetMapper.selectStudent",1);
        System.out.println(student);
    }

}
