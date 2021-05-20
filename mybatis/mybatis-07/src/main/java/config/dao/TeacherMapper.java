package config.dao;

import config.pojo.Student;
import config.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    public List<Teacher> getTeacher();

    // 获取指定老师下的所有学生及老师的信息
    Teacher getTeacherStudent(@Param("teacherId") int id);
}
