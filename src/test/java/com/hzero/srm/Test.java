package com.hzero.srm;

import org.hzero.test1.TestApplication;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.Header;
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

    @org.junit.Test
    public void testlist() {
        rfxService.publishRfx(16L, 17L);
    }


}
