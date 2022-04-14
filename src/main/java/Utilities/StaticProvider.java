package Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class StaticProvider {

    private int cartValidationSheet = 0;
    private int invalidLoginSheet = 1;
    private int validLoginSheet = 0;
    private int validSignUpSheet = 0;

    @DataProvider(name = "ValidSignUpSheetData")
    public Object[][] getValidSignUpSheetData() throws IOException {
        String signUpExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\SignUpData.xlsx";
        ExcelFile signUpSheetExcelFile = new ExcelFile(signUpExcelPath);
        return signUpSheetExcelFile.getTestDataFromExcelFile(validSignUpSheet);

    }

    @DataProvider(name = "CartValidationSheetData")
    public Object[][] getCartValidationData() throws IOException {
        String cartValidationExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\CartValidationData.xlsx";
        ExcelFile cartValidationExcelFile = new ExcelFile(cartValidationExcelPath);
        return cartValidationExcelFile.getTestDataFromExcelFile(cartValidationSheet);

    }

    @DataProvider(name = "InvalidLoginSheetData")
    public Object[][] getInvalidLoginData() throws IOException {
        String logInExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\LogInData.xlsx";
        ExcelFile logInSheetExcel = new ExcelFile(logInExcelPath);
        return logInSheetExcel.getTestDataFromExcelFile(invalidLoginSheet);

    }

    @DataProvider(name = "ValidLoginSheetData")
    public Object[][] getValidLoginData() throws IOException {
        String logInExcelPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\LogInData.xlsx";
        ExcelFile logInSheetExcel = new ExcelFile(logInExcelPath);
        return logInSheetExcel.getTestDataFromExcelFile(validLoginSheet);

    }

}
