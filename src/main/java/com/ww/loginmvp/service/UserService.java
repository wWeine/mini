package com.ww.loginmvp.service;

import com.ww.loginmvp.dto.LoginDTO;
import com.ww.loginmvp.vo.UserInfoVO;

public interface UserService {
    String login(LoginDTO dto);
    UserInfoVO info(Long id);
}