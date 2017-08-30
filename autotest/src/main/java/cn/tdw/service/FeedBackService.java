package cn.tdw.service;

import cn.tdw.dao.FeedBackDAO;
import cn.tdw.dto.FeedBackDTO;
import cn.tdw.dto.FeedBackSearchDTO;
import com.tuandai.pagehelper.util.Page;
import com.tuandai.pagehelper.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuganqin on 2017/8/14.
 */
@Service
public class FeedBackService {

    @Autowired
    private FeedBackDAO feedBackMapper;

    public Page<FeedBackDTO> queryFeedBacks(FeedBackSearchDTO dto) {
        Page<FeedBackDTO> page = PageHelper.startPage(dto.getPage(), dto.getLimit());
        if (page != null) {
            List<FeedBackDTO> feedBacks = feedBackMapper.queryFeedBacks(dto);
            page.setDataList(feedBacks);
        }
        return page;
    }
}

