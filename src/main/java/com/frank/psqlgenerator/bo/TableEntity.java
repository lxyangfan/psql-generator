package com.frank.psqlgenerator.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableEntity {

    private String database;

    private String schema;

    private String table;

    private String rawTableName;

    private List<ColumnEntity> columns;

}
