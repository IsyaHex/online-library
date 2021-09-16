package com.library.ui.component;

import com.library.ui.config.HttpSessionConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;

@Component
public class CustomShutdownHook {
    private final HttpSessionConfig httpSessionConfig;


    public CustomShutdownHook(HttpSessionConfig httpSessionConfig) {
        this.httpSessionConfig = httpSessionConfig;
    }

    @PreDestroy
    public void desctroy() {
        httpSessionConfig.getActiveSession().forEach(HttpSession::invalidate);
    }
}
