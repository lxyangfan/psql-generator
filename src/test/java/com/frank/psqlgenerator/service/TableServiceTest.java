package com.frank.psqlgenerator.service;

import com.frank.psqlgenerator.data.TableRepositoryTest;
import com.frank.psqlgenerator.dto.TableGenerateParam;
import org.junit.Test;

import java.net.URL;

public class TableServiceTest {

    @Test
    public void testGenerateSql() throws Exception {

        TableGenerateParam param = new TableGenerateParam();
        param.setOutputPath("out.sql");
        URL resource = TableRepositoryTest.class.getClassLoader().getResource("excel/schema.xlsx");
        String filepath = resource.getPath();
        param.setInputExcelPath(filepath);
        TableService.generate(param);

    }
}
