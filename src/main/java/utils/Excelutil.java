package utils;


import java.io.*;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {

    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        return excelRows;
    }

    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == CellType.STRING) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.STRING) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == CellType.ERROR) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }



    public List<String> getColumnData(String excelFilePath, String sheetName, String columnName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return getColumnValues(sheet, columnName);
    }

    private List<String> getColumnValues(Sheet sheet, String columnName) {
        List<String> columnValues = new ArrayList<>();
        int headerRowNumber = getHeaderRowNumber(sheet);

        if (headerRowNumber != -1) {
            Row headerRow = sheet.getRow(headerRowNumber);
            int totalRows = sheet.getPhysicalNumberOfRows();
            int columnIndex = -1;

            // Find the column index for the specified column name
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            // If the column exists, retrieve the values from that column
            if (columnIndex != -1) {
                for (int currentRow = headerRowNumber + 1; currentRow < totalRows; currentRow++) {
                    Row row = sheet.getRow(currentRow);
                    if (row != null) {
                        Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        String cellValue = getCellStringValue(cell);
                        columnValues.add(cellValue);
                    }
                }
            } else {
                throw new IllegalArgumentException("Column '" + columnName + "' not found in the sheet.");
            }
        }

        return columnValues;
    }

    private String getCellStringValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return NumberToTextConverter.toText(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case ERROR:
                return Byte.toString(cell.getErrorCellValue());
            case BLANK:
            default:
                return "";
        }

    }
    public String getImagePathFromExcel(String excelFilePath, String sheetName, String columnName)
            throws InvalidFormatException, IOException {

        // Get all values from the given column
        List<String> columnValues = getColumnData(excelFilePath, sheetName, columnName);

        // Check if column is empty
        if (columnValues == null || columnValues.isEmpty()) {
            throw new IllegalArgumentException("No values found in column: " + columnName);
        }

        // Take the first non-empty path
        String imagePath = null;
        for (String value : columnValues) {
            if (value != null && !value.trim().isEmpty()) {
                imagePath = value.trim();
                break;
            }
        }

        if (imagePath == null) {
            throw new IllegalArgumentException("No valid image path found in column: " + columnName);
        }

        // Verify the file exists
        File imgFile = new File(imagePath);
        if (!imgFile.exists()) {
            throw new IOException("Image file not found at path: " + imagePath);
        }

        return imgFile.getAbsolutePath();
    }

    public Map<String, String> getRowData(String filePath, String sheetName, int rowIndex) throws IOException {
        InputStream fileStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filePath);

        Workbook workbook;
        if (fileStream != null) {
            // Load from resources
            workbook = WorkbookFactory.create(fileStream);
        } else {
            // Fallback: load from normal file system (absolute/relative path)
            File file = new File(filePath);
            if (!file.exists()) {
                String projectPath = System.getProperty("user.dir");
                file = new File(projectPath, filePath); // try relative to project root
            }
            if (!file.exists()) {
                throw new FileNotFoundException("Excel file not found at: " + file.getAbsolutePath());
            }
            workbook = WorkbookFactory.create(file);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
        }

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(rowIndex);

        if (headerRow == null) throw new IllegalStateException("Header row missing in sheet " + sheetName);
        if (dataRow == null) throw new IllegalArgumentException("Row " + rowIndex + " not found in sheet " + sheetName);

        Map<String, String> rowData = new HashMap<>();
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String key = headerRow.getCell(i).getStringCellValue();
            Cell cell = dataRow.getCell(i);
            String value = (cell != null) ? cell.toString() : "";
            rowData.put(key, value);
        }

        workbook.close();
        return rowData;
    }


        public String getCellData(String excelFilePath, String sheetName, String rowName, String columnName) throws IOException {
            try (FileInputStream fis = new FileInputStream(excelFilePath);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet " + sheetName + " not found");
                }

                // Header row
                Row headerRow = sheet.getRow(0);
                if (headerRow == null) {
                    throw new IllegalStateException("Header row missing in " + sheetName);
                }

                // Find column index for the given column name
                int columnIndex = -1;
                for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                    if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                        columnIndex = i;
                        break;
                    }
                }

                if (columnIndex == -1) {
                    throw new IllegalArgumentException("Column '" + columnName + "' not found");
                }

                // Find row by first column (RowName)
                int rowCount = sheet.getPhysicalNumberOfRows();
                for (int i = 1; i < rowCount; i++) { // start after header
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell firstCell = row.getCell(0);
                        if (firstCell != null && firstCell.getStringCellValue().equalsIgnoreCase(rowName)) {
                            // Return the cell value from the matched column
                            return getCellValue(row.getCell(columnIndex));
                        }
                    }
                }
            }
            throw new IllegalArgumentException("Row '" + rowName + "' not found in sheet " + sheetName);
        }
    public List<Map<String, String>> getSheetData(String excelFilePath, String sheetName) throws IOException {
        List<Map<String, String>> sheetData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new IllegalArgumentException("Sheet " + sheetName + " not found");

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) throw new IllegalStateException("Header row missing in " + sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = headerRow.getLastCellNum();

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowMap = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = getCellValue(row.getCell(j));
                    rowMap.put(key, value);
                }
                sheetData.add(rowMap);
            }
        }
        return sheetData;
    }



        // Helper → convert cell to String
        private String getCellValue(Cell cell) {
            if (cell == null) return "";
            return switch (cell.getCellType()) {
                case STRING -> cell.getStringCellValue();
                case NUMERIC -> (DateUtil.isCellDateFormatted(cell))
                        ? cell.getDateCellValue().toString()
                        : String.valueOf((long) cell.getNumericCellValue());
                case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                default -> "";
            };
        }

    }




