package com.frank.psqlgenerator.service;

import com.frank.psqlgenerator.bo.TableEntity;
import com.frank.psqlgenerator.data.TableRepository;
import com.frank.psqlgenerator.dto.TableGenerateParam;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TableService {

    public static void generate(TableGenerateParam param) throws Exception {
        // 1、创建个Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        URL tabkeTpl = TableService.class.getClassLoader().getResource("table.ftl");
        // 2、设置模板文件所在的路径的目录
        configuration.setClassLoaderForTemplateLoading(TableService.class.getClassLoader(), "/");
        // 3、设置模板文件的字符集
        configuration.setDefaultEncoding("UTF-8");
        // 4、首先创建模板文件，再加载模板文件 模板文件的后缀官方统一的标准是.ftl 其实任何类型都行。
        Template template = configuration.getTemplate("table.ftl");// 可以是<相对路径>，也可以是<绝对路径>
        // 5、创建模板文件需要展示数据的数据集对象，可以使用POJO，也可以使用map 一般是使用map

        Map model = new HashMap<>();
        List<TableEntity> tables = TableRepository.getTablesFromExcel(param.getInputExcelPath());
        model.put("items", tables.stream().filter(t -> !t.getColumns().isEmpty()).collect(Collectors.toList()));

        // 6、创建一个FileWriter对象 指定生成的静态文件的文件路径及文件名
        // 拼接一个前缀和后缀
        FileWriter writer = new FileWriter(new File(param.getOutputPath()));
        // 7、调用模板对象的process方法，执行输出文件。
        template.process(model, writer);
        // 8、关闭流
        writer.close();
    }

}
