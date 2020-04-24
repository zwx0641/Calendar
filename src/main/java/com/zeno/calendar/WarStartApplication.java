package com.zeno.calendar;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author rf
 * @Description: 使用web.xml的形式进行部署
 */
public class WarStartApplication extends SpringBootServletInitializer {
    /**
     * Overrride configurations
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // Use web.xml to run the app, pointing to CalendarApplication, then start SpringBoot
        return builder.sources(CalendarApplication.class);
    }
}
