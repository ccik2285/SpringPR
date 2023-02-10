package first.spring;


import first.spring.repository.*;
import first.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {


    private EntityManager em;

    @Autowired

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

//    private DataSource datasource;
//    @Autowired
//    public SpringConfig(DataSource datasource) {
//        this.datasource = datasource;
//    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new JdbcMemberRepository(datasource);
        //return new JdbcTemplateMemberRepository(datasource);
        return new JpaMemberRepository(em);
    }
}
