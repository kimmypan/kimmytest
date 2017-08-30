package cn.tdw.service;

import cn.tdw.dao.PostLoanDAO;
import cn.tdw.dto.PostLoanDTO;
import cn.tdw.dto.PostLoanSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangwenchang on 2017/8/14.
 */
@Service
public class PostLoanService {
    @Autowired
    PostLoanDAO postLoanDAO;

    public List<PostLoanDTO> list(PostLoanSearchDTO searchDTO) {
        return postLoanDAO.list(searchDTO);
    }
}
