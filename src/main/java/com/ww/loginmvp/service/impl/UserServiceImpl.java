package com.ww.loginmvp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ww.loginmvp.dto.LoginDTO;
import com.ww.loginmvp.entity.User;
import com.ww.loginmvp.repository.UserRepository;
import com.ww.loginmvp.service.UserService;
import com.ww.loginmvp.util.JwtUtil;
import com.ww.loginmvp.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public String login(LoginDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        String token = jwtUtil.generateToken(user.getId().toString());
        redisTemplate.opsForValue()
                .set("token:" + user.getId(), token, Duration.ofHours(2));
        return token;
    }

    @Override
    public UserInfoVO info(Long id) {
        return BeanUtil.copyProperties(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在")), UserInfoVO.class);
    }
}