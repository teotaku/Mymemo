package com.Bymyselfmemomemo.memomemomm.Controller;


import com.Bymyselfmemomemo.memomemomm.dto.JoinDTO;
import com.Bymyselfmemomemo.memomemomm.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoinController {


    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(@ModelAttribute JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        return "ok";
    }
}
