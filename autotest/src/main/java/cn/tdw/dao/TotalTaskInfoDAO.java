package cn.tdw.dao;

import cn.tdw.dto.TraceDetailTotalDTO;


/**
 * Created by wuganqin on 2017/8/15.
 */
public interface TotalTaskInfoDAO  extends TaskInfoDAO{
    TraceDetailTotalDTO queryTraceDetailTotal();
}
