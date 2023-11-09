package Base;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name="ValidTestData(username,password)")
    public static Object[][] Data()
    {
        return new Object[][]{
                {"standard_user","secret_sauce"}//valid Data For Username and password
                , {"problem_user","secret_sauce"},
                {"visual_user","secret_sauce"}
        };
    }
}
