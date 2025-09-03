package finalmission.global.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import finalmission.global.exception.MissingLoginException;
import finalmission.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    public LoginInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    request.setAttribute("memberInfo", authService.getMemberInfoByToken(token));
                    return true;
                }
            }
        }
        throw new MissingLoginException("로그인이 필요합니다.");
    }
}
