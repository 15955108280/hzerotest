package org.hzero.test1.api.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;
/**
 * description
 *
 * @author YXP 2019/08/26 15:12
 */
@ChoerodonExtraData
public class TodoExtraDataManager implements ExtraDataManager {

    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("hord-test");
        choerodonRouteData.setPath("/hord-test/**");
        choerodonRouteData.setServiceId("hzero-test");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
