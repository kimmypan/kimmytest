package cn.tdw.dao;

import cn.tdw.dto.PostLoanDTO;
import cn.tdw.dto.PostLoanSearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huangwenchang on 2017/8/15.
 */
@Mapper
public interface PostLoanDAO {
    List<PostLoanDTO> list(PostLoanSearchDTO searchDTO);
}
