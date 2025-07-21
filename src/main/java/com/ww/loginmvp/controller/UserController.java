package com.ww.loginmvp.controller;

import com.ww.loginmvp.dto.LoginDTO;
import com.ww.loginmvp.service.UserService;
import com.ww.loginmvp.vo.UserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "认证接口")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO dto) {
        return userService.login(dto);
    }

    @Operation(summary = "当前用户信息")
    @GetMapping("/info")
    public UserInfoVO info(Authentication authentication) {
        Long userId = Long.valueOf(authentication.getName());
        return userService.info(userId);
    }
}