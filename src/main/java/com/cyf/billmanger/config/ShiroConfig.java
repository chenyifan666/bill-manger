package com.cyf.billmanger.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.cyf.billmanger.config.filter.RoleOrFilter;
import com.cyf.billmanger.config.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("securityManager")SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        Map<String,Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roleOrFilter",new RoleOrFilter());

        bean.setFilters(filterMap);

        Map chainDefinitionMap = new LinkedHashMap();
        chainDefinitionMap.put("/toLogin","anon");
        chainDefinitionMap.put("/user/login","anon");
        chainDefinitionMap.put("/user/loginOut","anon");
        chainDefinitionMap.put("/css/**","anon");
        chainDefinitionMap.put("/js/**","anon");
        chainDefinitionMap.put("/img/**","anon");
        chainDefinitionMap.put("/user/**","roleOrFilter[admin]");
        chainDefinitionMap.put("/provider/**","roleOrFilter[admin,manager]");
        chainDefinitionMap.put("/**","authc");

        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/toLogin");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauth");
        bean.setFilterChainDefinitionMap(chainDefinitionMap);

        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("userRealm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean("userRealm")
    public Realm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }
}
