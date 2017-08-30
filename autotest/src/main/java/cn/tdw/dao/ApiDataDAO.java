package cn.tdw.dao;

import cn.tdw.domain.ApiData;
import cn.tdw.dto.ApidataDTO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by huangzhenwei  on 2017/8/22.
 */
@Mapper
public interface ApiDataDAO {

    List<ApiData> apiDataList(@Param("userId")String userId);


}
