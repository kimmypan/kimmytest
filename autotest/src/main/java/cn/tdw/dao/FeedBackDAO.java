package cn.tdw.dao;

import cn.tdw.dto.FeedBackDTO;
import cn.tdw.dto.FeedBackSearchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuganqin on 2017/8/14.
 */
@Mapper
public interface FeedBackDAO {
    List<FeedBackDTO> queryFeedBacks(@Param("dto") FeedBackSearchDTO dto);
}
