package com.frank.psqlgenerator.data;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.frank.psqlgenerator.bo.ColumnEntity;
import com.frank.psqlgenerator.bo.TableEntity;
import com.frank.psqlgenerator.data.excel.ColumnEntityListener;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import static com.frank.psqlgenerator.converter.TableEntityConverter.parseSheetName;

@Slf4j
public class TableRepository {


    public static List<TableEntity> getTablesFromExcel(String fileName) {
        List<ReadSheet> sheets = EasyExcel.read(fileName).build().excelExecutor().sheetList();
        List<TableEntity> tables = Lists.newArrayList();
        for (ReadSheet readSheet : sheets) {
            String sheetName = readSheet.getSheetName();
            getOneSheet(fileName, sheetName).ifPresent(tables::add);
        }
        return tables;
    }

    private static Optional<TableEntity> getOneSheet(String fileName, String sheetName) {
        ExcelReader excelReader = null;
        try {
            ColumnEntityListener listener = new ColumnEntityListener();
            excelReader = EasyExcel.read(fileName, ColumnEntity.class, listener).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetName).build();
            excelReader.read(readSheet);

            TableEntity tableEntity = new TableEntity();
            parseSheetName(tableEntity, sheetName);

            tableEntity.setColumns(listener.getColumnEntityList());
            return Optional.of(tableEntity);
        } catch (Exception e) {
            log.error("Error getOneSheet, fileName => {}, sheetName => {}", fileName, sheetName, e);
            return Optional.empty();
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

}
