package bean.request;

import com.fupengfei.thesis.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Fu Pengfei
 * @Date 2019-04-11
 * @Description TODO
 */
@Setter
@Getter
public class StaffCreateReq implements Serializable {

    private String name;
    private Integer age;
    private Gender gender;
}
