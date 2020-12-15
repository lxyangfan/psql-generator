package com.frank.psqlgenerator.data;

import com.frank.psqlgenerator.bo.TableEntity;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class TableRepositoryTest {


    @Test
    public void testParseTableFromExcel() {

        URL resource = TableRepositoryTest.class.getClassLoader().getResource("excel/schema.xlsx");
        String filepath = resource.getPath();
        List<TableEntity> tables = TableRepository.getTablesFromExcel(filepath);
        Assert.assertNotNull(tables);

    }


}
