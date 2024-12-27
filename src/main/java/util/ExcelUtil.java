package util;

import model.Player;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class ExcelUtil {
    private ExcelUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static XSSFWorkbook createXlxs(List<Player> playerList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Рэйтинг");
        Row rowHead = sheet.createRow(0);
        rowHead.createCell(0).setCellValue("№");
        rowHead.createCell(1).setCellValue("ФИО");
        rowHead.createCell(2).setCellValue("Рэйтинг");
        for (int i = 0; i < playerList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1.0);
            row.createCell(1).setCellValue(playerList.get(i).getName());
            row.createCell(2).setCellValue(playerList.get(i).getScore());
        }
        return workbook;

    }

    public static void writeXlxs(XSSFWorkbook workbook) throws IOException {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm"));
        try (FileOutputStream fileOut = new FileOutputStream("newfile_"+dateTime+".xlsx")) {
            workbook.write(fileOut);
        }
    }

}
