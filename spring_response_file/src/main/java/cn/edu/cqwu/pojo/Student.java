package cn.edu.cqwu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String name;
    private String sno;
    private int banji;
}
