package com.frank.psqlgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableGenerateParam {

    private String inputExcelPath;

    private String outputPath;

}
