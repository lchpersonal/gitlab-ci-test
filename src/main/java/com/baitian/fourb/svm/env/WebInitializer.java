package com.baitian.fourb.svm.env;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final List<Runnable> ServletContainerShutdownRunnables = new ArrayList<>();

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MvcConfig.class};  //web上下文
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//DispatcherServlet的映射路径
    }

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        container.addListener(new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                ServletContainerShutdownRunnables.forEach((runnable) -> runnable.run());
            }

        });
        super.onStartup(container);
    }

    public static void addShutdownHook(Runnable shutdownHook) {
        ServletContainerShutdownRunnables.add(shutdownHook);
    }
}