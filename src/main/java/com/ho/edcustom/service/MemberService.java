package com.ho.edcustom.service;

import com.ho.edcustom.JwtTokenProvider;
import com.ho.edcustom.entity.Member;
import com.ho.edcustom.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    public void createMember(String userid,String password){
        memberRepository.save(Member.builder()
                .userid(userid)
                .password(password)
                .build());

    }

    public String loginMember(String userid, String password) {
        Member member = memberRepository.findByUserid(userid)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!matches(password, member.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtTokenProvider.generateToken(member);
    }



}
