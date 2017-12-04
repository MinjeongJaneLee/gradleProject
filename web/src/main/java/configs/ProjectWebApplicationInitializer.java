package configs;


import com.spring.utility.filter.XssRequestFilter;
import configs.spring.RootContext;
import lombok.extern.apachecommons.CommonsLog;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.EnumSet;


@CommonsLog
public class ProjectWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStart");

        initializeListener(servletContext);
        initializeFilter(servletContext);
        initializeServlet(servletContext);
    }


    private void initializeListener(ServletContext servletContext) {
        log.info("initializeListener");

        registerRootContextListener(servletContext);
        registerSessionLister(servletContext);
    }


    private void initializeFilter(ServletContext servletContext) {
        log.info("initializeFilter");

        registerCharacterEncodingFilter(servletContext);
        registerMultipartFilter(servletContext);
        registerSpringSecurityFilter(servletContext);
        registerXssRequestFilter(servletContext);
        registerSitemeshFilter(servletContext);
    }


    private void initializeServlet(ServletContext servletContext) {
        log.info("initializeServlet");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
        dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }


    private void registerRootContextListener(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.getEnvironment().setDefault("local");
        rootContext.register(RootContext.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
        servletContext.addListener(contextLoaderListener);
    }


    private void registerSessionLister(ServletContext servletContext) {
        servletContext.addListener(new HttpSessionListener() {

            @Override
            public void sessionCreated(HttpSessionEvent se) {
                se.getSession().setMaxInactiveInterval(30 * 24 * 60 * 60); // 1month
            }


            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
            }
        });
    }

    private void registerCharacterEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }


    private void registerXssRequestFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("xssRequestFilter", XssRequestFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }


    private void registerSpringSecurityFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }


    private void registerMultipartFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        filter.setInitParameter("multipartResolverBeanName", "multipartResolver");
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }


    private void registerSitemeshFilter(ServletContext servletContext) {
        // @formatter:off
        FilterRegistration.Dynamic filter = servletContext.addFilter("sitemeshFilter", new SiteMeshFilterBuilder()
                .addDecoratorPath("/**/_*", "/WEB-INF/views/decorators/empty-layout.jsp")
                .addDecoratorPath("/**/*", "/WEB-INF/views/decorators/sub-layout.jsp")
                .addDecoratorPath("/security/*", "/WEB-INF/views/decorators/security-layout.jsp")
                .addExcludedPath("/decorators/*")
                .addExcludedPath("/**/layer*")
                .addExcludedPath("/test/*")
                .addExcludedPath("/embed/*")
                .addExcludedPath("/resources/*")
                .setMimeTypes("text/html", "application/xhtml+xml", "application/vnd.wap.xhtml+xml")
                .addTagRuleBundles(new DivExtractingTagRuleBundle())
                .create());

        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        // @formatter:on
    }
}
