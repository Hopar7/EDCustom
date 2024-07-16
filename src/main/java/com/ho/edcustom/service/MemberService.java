package com.ho.edcustom.service;

import com.ho.edcustom.Jwt.JwtTokenProvider;
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
    public void createMember(String name,String email,String password){
        memberRepository.save(Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build());
    }

    public boolean alreadyUsingemail(String email)
    {
        return memberRepository.findByEmail(email).isPresent();

    }

    public String loginMember(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!matches(password, member.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtTokenProvider.generateToken(member);
    }



}
