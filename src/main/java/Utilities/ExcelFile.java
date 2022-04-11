package Utilities;

public class ExcelFile {
    private ExcelRead excelRead;

    public ExcelFile (String ExcelPath){
        excelRead = new ExcelRead(ExcelPath);
    }



    public Object[][] getTestDataFromExcelFile(int sheetNumber) {
        int testCaseStartRow = 1;
        int testCaseStartColumn = 0;
        int num_of_rows = excelRead.getRowNum(sheetNumber);
        int num_of_col = excelRead.getColNum(sheetNumber);
        String excel_File_Data[][] = new String[num_of_rows
                - testCaseStartRow][num_of_col];
        for (int i = testCaseStartRow; i <num_of_rows; i++) {
            for (int j = testCaseStartColumn; j < num_of_col; j++) {
                excel_File_Data[i - testCaseStartRow][j
                        - testCaseStartColumn] = excelRead.fetchData(
                        sheetNumber, i, j);
            }
        }
        return excel_File_Data;

    }


}
