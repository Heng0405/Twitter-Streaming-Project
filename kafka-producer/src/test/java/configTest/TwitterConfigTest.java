package configTest;

import config.TwitterConfig;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class TwitterConfigTest {


    @Test
    public void testTwitterConfig(){
        TwitterConfig config = TwitterConfig.getInstance();
        assertEquals("6KhRLFHC3XrNZZnFpSjn48WPE",config.getConsumerKey());
    }

}
