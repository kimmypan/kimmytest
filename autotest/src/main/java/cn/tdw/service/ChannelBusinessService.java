package cn.tdw.service;

import cn.tdw.dao.ChannelBusinessDAO;
import cn.tdw.domain.ChannelBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangwenchang on 2017/8/15.
 */
@Service
public class ChannelBusinessService {

    @Autowired
    ChannelBusinessDAO channelBusinessDAO;

    public List<ChannelBusiness> list() {
        return channelBusinessDAO.list();
    }
}
