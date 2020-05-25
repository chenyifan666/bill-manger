package com.cyf.billmanger.config.realm;

import com.cyf.billmanger.entities.Role;
import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.RoleRepository;
import com.cyf.billmanger.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userRepository.findUserByUsername(username);
        Role role = roleRepository.findRoleById(user.getUserType().longValue());
        Set<String> roles = new HashSet<>();
        roles.add(role.getName());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        User user = userRepository.findUserByUsername(username);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
        return authenticationInfo;
    }
}
