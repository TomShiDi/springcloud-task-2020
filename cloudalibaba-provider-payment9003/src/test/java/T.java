import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
@SpringBootTest
public class T {
    @Test
    public void getRandomString() {
        System.out.println(IdUtil.simpleUUID());
    }
}
