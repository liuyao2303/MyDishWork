package test.UserTest;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by xiaoliu on 2017/5/17.
 */

public class ToolTest {

    @Test
    public void md5 () {
        String b = DigestUtils.md5Hex("df");
        System.out.println();
    }
}
