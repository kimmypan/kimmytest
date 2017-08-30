package cn.tdw.dao;

import cn.tdw.domain.OverDueRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by huangwenchang on 2017/8/15.
 */
@Mapper
public interface OverDueRecordDAO {

        List<OverDueRecord> list(Map paramsMap);
}
