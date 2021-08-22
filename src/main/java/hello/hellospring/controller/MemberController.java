package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
