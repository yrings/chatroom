package CharContentTest;

import com.pojo.CharContent;
import com.pojo.User;
import com.service.CharContentService;
import com.service.CharContetnImpl.CharContentServiceImpl;
import org.testng.annotations.Test;

import java.io.IOException;

public class CharContentServiceTest {
    @Test
    public void addNewcontent() throws IOException {
        User user = new User();
        user.setUsername("tom");
        CharContent cc = new CharContent();
        cc.setContent("彳亍");
        cc.setUsername("tom");

        CharContentService charContentService = new CharContentServiceImpl();
        charContentService.addNewcontent(cc);

    }
}
