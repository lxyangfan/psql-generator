package com.frank.psqlgenerator.converter;

import com.frank.psqlgenerator.bo.TableEntity;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@Slf4j
public class TableEntityConverter {

    public static void parseSheetName(TableEntity entity, String sheetName) {

        entity.setRawTableName(sheetName);

        if (Objects.nonNull(sheetName) && sheetName.contains(".")) {
            List<String> parts = Lists.newArrayList(Splitter.on(".").split(sheetName).iterator());
            if (parts.size() >= 3) {
                entity.setDatabase(parts.get(0));
                entity.setSchema(parts.get(1));
                entity.setTable(parts.get(2));
            } else if (parts.size() == 2) {
                entity.setSchema(parts.get(0));
                entity.setTable(parts.get(1));
            } else if (parts.size() == 1) {
                entity.setTable(parts.get(0));
            }
        } else {
            log.warn("not contains comma ");
        }
    }
}
