package com.dtstack.dtcenter.common.loader.greenplum;

import com.dtstack.dtcenter.common.loader.rdbms.AbsTableClient;
import com.dtstack.dtcenter.common.loader.rdbms.ConnFactory;
import com.dtstack.dtcenter.loader.dto.source.ISourceDTO;
import com.dtstack.dtcenter.loader.exception.DtLoaderException;
import com.dtstack.dtcenter.loader.source.DataSourceType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * Greenplum表操作相关接口
 *
 * @author ：wangchuan
 * date：Created in 10:57 上午 2020/12/3
 * company: www.dtstack.com
 */
@Slf4j
public class GreenplumTableClient extends AbsTableClient {

    @Override
    protected ConnFactory getConnFactory() {
        return new GreenplumFactory();
    }

    @Override
    protected DataSourceType getSourceType() {
        return DataSourceType.GREENPLUM6;
    }

    @Override
    public List<String> showPartitions(ISourceDTO source, String tableName) {
        throw new DtLoaderException("greenplum不支持获取分区操作！");
    }

    @Override
    protected String getDropTableSql(String tableName) {
        return String.format("drop table if exists %s", tableName);
    }

    @Override
    public Boolean alterTableParams(ISourceDTO source, String tableName, Map<String, String> params) {
        throw new DtLoaderException("greenplum暂时不支持更改表参数操作！");
    }
}