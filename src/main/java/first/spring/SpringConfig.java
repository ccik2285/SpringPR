package first.spring;


import first.spring.repository.JdbcMemberRepository;
import first.spring.repository.JdbcTemplateMemberRepository;
import first.spring.repository.MemberRepository;
import first.spring.repository.MemoryMemberRepository;
import first.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private DataSource datasource;
    @Autowired
    public SpringConfig(DataSource datasource) {
        this.datasource = datasource;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new JdbcMemberRepository(datasource);
        return new JdbcTemplateMemberRepository(datasource);
    }
}
