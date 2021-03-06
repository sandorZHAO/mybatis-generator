package com.pyjava.plugin.meta.database;

import com.pyjava.plugin.meta.database.ColumnMeta;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据表元数据
 *
 * @author zhaojj9
 * @since 1.0.0
 */
@Data
@ToString
public class TableMeta {
    /**
     * 表所属的库
     */
    private String schemaName;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 注释
     */
    private String comment;
    /**
     * 列信息
     */
    private List<ColumnMeta> columns = new ArrayList<>();
}
