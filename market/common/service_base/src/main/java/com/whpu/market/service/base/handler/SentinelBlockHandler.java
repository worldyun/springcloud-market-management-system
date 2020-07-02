package com.whpu.market.service.base.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.whpu.market.common.base.result.R;

/**
 * @author WorldYun
 * @since 2020/09/30
 */

public class SentinelBlockHandler {
    public static R handlerException(BlockException exception) {
        return R.error().message("服务不可用");
    }
}
