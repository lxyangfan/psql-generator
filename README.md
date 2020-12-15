# psql-generator
A simple Postgres SQL generator using excel file as modeling input.


Example:
```
    @Test
    public void testGenerateSql() throws Exception {

        TableGenerateParam param = new TableGenerateParam();
        param.setOutputPath("out.sql"); // 1. set the output sql path
        URL resource = TableRepositoryTest.class.getClassLoader().getResource("excel/schema.xlsx");  // 2. set input excel model file
        String filepath = resource.getPath();
        param.setInputExcelPath(filepath);
        TableService.generate(param); // 3. do the work

    }

```
