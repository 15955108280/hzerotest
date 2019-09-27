package com.hzero.srm;

import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.TestApplication;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.repository.RfxRepository;
import org.hzero.test1.infra.mapper.HeaderMapper;
import org.hzero.test1.infra.mapper.RfxMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * description
 *
 * @author YXP 2019/08/26 20:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class, Test.class})
public class Test {
    @Autowired
    RfxMapper rfxMapper;
    @Autowired
    HeaderMapper headerMapper;
    @Autowired
    RfxService rfxService;
    @Autowired
    RfxRepository rfxRepository;

    @org.junit.Test
    public void testlist() {
        PageRequest pageRequest = new PageRequest(1,10);
        QueryDTO queryDTO = new QueryDTO();
        rfxRepository.listLineItem(pageRequest,queryDTO);
    }


}
