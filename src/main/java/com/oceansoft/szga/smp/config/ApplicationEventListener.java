package com.oceansoft.szga.smp.config;

import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author JackChan
 * @Date 2020/7/5 0005 下午 12:23
 */
@Component
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        FlowReportService flowReportService = contextRefreshedEvent.getApplicationContext().getBean(FlowReportService.class);
        UserUtils.setReportService(flowReportService);
        LOGGER.info("执行注入 flowReportService ");
    }
}
