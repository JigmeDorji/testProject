package com.test.srv.auth.security;

import com.test.srv.auth.dto.UserAccessPermissionListDTO;
import com.test.srv.auth.dto.UserDTO;
import com.test.srv.auth.service.UserAccessPermissionService;
import com.test.srv.auth.service.UserLoginService;
import com.test.srv.enumeration.LoginErrorCode;
import com.test.srv.enumeration.Permission;
import com.test.srv.enumeration.UserRoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class WebAuthenticationProvider implements AuthenticationProvider {
    //region private variable
    @Autowired
    private PasswordEncoder passwordEncoder;
    //endregion

    //region private service
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserAccessPermissionService userAccessPermissionService;
    //endregion

    //region public method

    /**
     * It processes authentication information
     *
     * @param authentication authentication
     * @return Authentication
     * @throws org.springframework.security.core.AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String username = String.valueOf(auth.getPrincipal());
        username = username.trim().toUpperCase();
        String password = String.valueOf(auth.getCredentials());

        UserDTO userLogin = userLoginService.login(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException(LoginErrorCode.FAILED.getCode());
        } else if (!userLogin.getUserStatus().equals('A')) {
            throw new LockedException(LoginErrorCode.LOCKED.getCode());
        } else if (passwordEncoder.matches(password, userLogin.getUserPassword())) {
            Collection<GrantedAuthority> authorities = getAccessRight(userLogin);
            return new UsernamePasswordAuthenticationToken(userLogin, userLogin.getUserPassword(), authorities);
        } else {
            throw new BadCredentialsException(LoginErrorCode.FAILED.getCode());
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * It supplies authorization information according to user group
     *
     * @return Set
     */
    private Collection<GrantedAuthority> getAccessRight(UserDTO userDTO) {

        Collection<GrantedAuthority> authorities = new HashSet<>();
        List<UserAccessPermissionListDTO> userAccessPermissionListDTOList = userAccessPermissionService
                .getUserAccessPermissionDetails(userDTO.getUserRoleTypeId());
        userAccessPermissionListDTOList.forEach(userAccessPermissionListDTO -> {
            Integer screenId = userAccessPermissionListDTO.getScreenId();

            //parent permission
//            if (Objects.equals(ChildMenuEnum.USER_CREATION.getValue(), screenId) || Objects.equals(ChildMenuEnum.USER_ACCESS_PERMISSION_SETUP.getValue(), screenId) ||
//                    Objects.equals(ChildMenuEnum.COMPANY_REGISTRATION.getValue(), screenId) || Objects.equals(ChildMenuEnum.FINANCIAL_YEAR_SETUP.getValue(), screenId)) {
//                if (userAccessPermissionListDTO.getIsScreenAccessAllowed() == 'Y') {
//                    authorities.add(new SimpleGrantedAuthority(ParentMenuEnum.COMMON_CONTROL.getValue() + "-" + Permission.VIEW));
//                }
//            }

            //Screen permission
            if (userAccessPermissionListDTO.getIsScreenAccessAllowed() != null && userAccessPermissionListDTO.getIsScreenAccessAllowed() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.VIEW));
            }
            if (userAccessPermissionListDTO.getIsDeleteAccessAllowed() != null && userAccessPermissionListDTO.getIsDeleteAccessAllowed() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.DELETE));

            }
            if (userAccessPermissionListDTO.getIsSaveAccessAllowed() != null && userAccessPermissionListDTO.getIsSaveAccessAllowed() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.ADD));
            }
            if (userAccessPermissionListDTO.getIsEditAccessAllowed() != null && userAccessPermissionListDTO.getIsEditAccessAllowed() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.EDIT));
            }
            if (!Objects.equals(userDTO.getUserRoleTypeId(), UserRoleType.INITIATOR_COMPANY.getValue())) {
                authorities.add(new SimpleGrantedAuthority(screenId + "-" + Permission.COMPONENT_VIEW));
            }
        });
        return authorities;
    }
    //endregion
}
