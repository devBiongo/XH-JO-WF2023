package com.jo.framework.security.filter;

import com.jo.common.constant.CacheConstants;
import com.jo.common.core.model.LoginUser;
import com.jo.common.core.redis.RedisCache;
import com.jo.common.enums.ResponseCode;
import com.jo.common.exception.ServiceException;
import com.jo.common.utils.JwtUtils;
import com.jo.common.utils.StringUtils;
import com.jo.framework.security.context.AuthenticationContextHolder;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器
 *
 * @author Joffrey
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String jwt = JwtUtils.extractJwt(request);
        if (StringUtils.isNotEmpty(jwt)) {
            LoginUser loginUser = null;
            try {
                Claims claims = JwtUtils.parseJWT(jwt);
                loginUser = redisCache.getCacheObject(CacheConstants.LOGIN_TOKEN_KEY+ claims.get("userId"));
            } catch (Exception e) {
                AuthenticationContextHolder.clearContext();
                throw new ServiceException(ResponseCode.INVALID_TOKEN.getDescription());
            }
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
