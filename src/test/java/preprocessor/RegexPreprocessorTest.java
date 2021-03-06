package preprocessor;

import org.junit.Assert;
import org.junit.Test;

public class RegexPreprocessorTest {

    @Test
    public void regexPreprocessorTest() {
        RegexPreprocessor rpp = new RegexPreprocessor("^.*(fakebook\\.com.*)/$", "$1");
        String test = "https://www.fakebook.com/personOne/";
        String res = "fakebook.com/personOne";
        Assert.assertEquals(res, rpp.applyProcessor(test));
    }

}