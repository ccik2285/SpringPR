package first.spring;


import first.spring.aop.TimeTraceAop;
import first.spring.repository.*;
import first.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // private EntityManager em;

   // @Autowired

  //  public SpringConfig(EntityManager em) {
  //      this.em = em;
 //   }

//    private DataSource datasource;
//    @Autowired
//    public SpringConfig(DataSource datasource) {
//        this.datasource = datasource;
//    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository(){

        //return new JdbcMemberRepository(datasource);
        //return new JdbcTemplateMemberRepository(datasource);
        //return new JpaMemberRepository(em);

 //   }
}
