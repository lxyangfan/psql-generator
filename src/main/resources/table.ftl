-- create by psql-generator
-- time: ${.now?string('yyyy-MM-dd HH:mm:ss')}
<#list items as item>

-- create table: ${item.rawTableName}
drop table if exists ${item.rawTableName};

create table if not exists ${item.rawTableName}
(
<#list item.columns as column>
    ${column.column!""} ${column.type!""} ${column.constrains!""}<#sep>,${'\n'} <#else>None
</#list>
);


<#list item.columns as column>
    <#if column.createKey >
CREATE ${column.key!''} INDEX  IF NOT EXISTS idx_${item.table}_${column.column} ON ${item.rawTableName} (${column.column});
    </#if>
</#list>

<#list item.columns as column>
    <#if column.comment??>
comment on column ${item.rawTableName}.${column.column} is '${column.comment}';
    </#if>
</#list>

</#list>
