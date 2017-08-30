package cn.tdw.dao;

import cn.tdw.domain.BorrowInfo;
import cn.tdw.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liubin
 * @Date 2017/8/14 10:23
 */
@Mapper
public interface BorrowInfoDAO {

    List<BorrowInfo> selectByCollectionTask(CollectionTaskSearchDTO searchDto);

    BorrowInfo selectByPrimaryKey();


    //根据借款详情
    BorrowInfo selectBorrowInfo(@Param("userId") String userId, @Param("borrowId") String borrowId);
/*
    //新增公告
    void inBulletin(@Param("announcement") String announcement,@Param("borrowId") String borrowId);*/

    //修改公告
    void upBulletin(@Param("announcement") String announcement,@Param("borrowId")String borrowId);

    List<AllocationsInfoDTO> selectAllocateWithoutResloveList(AllocationsInfoSearchDTO searchDTO);

    List<TraceDetailDTO> queryTraceDetails(TraceDetailSearchDTO dto);
}
