package cn.tdw.controller;

import cn.tdw.common.utils.R;
import cn.tdw.dto.FeedBackSearchDTO;
import cn.tdw.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 反馈管理
 * Created by wuganqin on 2017/8/14.
 */
@RestController
@RequestMapping("/manager/feedBack")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping(value = "/opinions", method = RequestMethod.GET)
    public R queryFeedBacks(FeedBackSearchDTO dto) {
        return R.ok().put("page", feedBackService.queryFeedBacks(dto));
    }

}
