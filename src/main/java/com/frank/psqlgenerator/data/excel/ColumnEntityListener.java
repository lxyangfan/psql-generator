package com.frank.psqlgenerator.data.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.frank.psqlgenerator.bo.ColumnEntity;
import com.google.common.collect.Lists;

import java.util.List;

public class ColumnEntityListener extends AnalysisEventListener<ColumnEntity> {

    private List<ColumnEntity> columnEntityList = Lists.newArrayList();

    public void invoke(ColumnEntity columnEntity, AnalysisContext analysisContext) {
        String trimWhiteSpace = columnEntity.getColumn().trim();
        columnEntity.setColumn(trimWhiteSpace);
        columnEntityList.add(columnEntity);
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public void setColumnEntityList(List<ColumnEntity> columnEntityList) {
        this.columnEntityList = columnEntityList;
    }

    public List<ColumnEntity> getColumnEntityList() {
        return columnEntityList;
    }
}
