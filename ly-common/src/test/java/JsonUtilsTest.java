import com.leyou.common.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class JsonUtilsTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        String name;
        Integer age;
    }

    @Test
    public void serializeTest() {
        User user = new User("hello", 22);
        String s = JsonUtils.serialize(user);
        System.out.println("hellooosaf"+s);
        User user1 = JsonUtils.parse(s, User.class);
        System.out.println("user1" + user1);
    }
}
