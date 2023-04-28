package cn.edu.cqwu.mapper;

import cn.edu.cqwu.pojo.Student;

import java.util.List;
//通过接口调用xml文件内容，接口名与xml文件名相同
public interface SetMapper {
//    方法名与映射文件id相同
//    id查找
    Student selectStudent(int id);
//    新增
    int insertStudent(Student student);//参数
//    修改
    int updateStudent(Student student);
//    删除
    int deleteStudent(int id);
//    查找全部
    List<Student> selectAllStudent();

}
