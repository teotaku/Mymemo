package com.Bymyselfmemomemo.memomemomm.service;

import com.Bymyselfmemomemo.memomemomm.Entity.UserEntity;
import com.Bymyselfmemomemo.memomemomm.dto.JoinDTO;
import com.Bymyselfmemomemo.memomemomm.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public JoinService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);

        Boolean isExist = userRepository.existsByuserEmail(username);
        if (isExist) {
            return;

        }

        UserEntity userEntity = UserEntity.createFromDTO(joinDTO,encodePassword);
        userRepository.save(userEntity);

    }

}
