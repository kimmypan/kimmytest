package cn.tdw.service;

import cn.tdw.dao.OverDueRecordDAO;
import cn.tdw.domain.OverDueRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by huangwenchang on 2017/8/15.
 */
@Service
public class OverDueRecordService {

    @Autowired
    OverDueRecordDAO overDueRecordDAO;

    public List<OverDueRecord> list(Map paramsMap) {
          return overDueRecordDAO.list(paramsMap);
    }
}
