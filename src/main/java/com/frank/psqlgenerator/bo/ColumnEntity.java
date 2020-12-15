package com.frank.psqlgenerator.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnEntity {

    private String column;

    private String comment;

    private String type;

    private String constrains;

    private String key;

    private boolean createKey;

}
