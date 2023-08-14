//package customer;
//
//import customer.repo.MemberRepo;
//import customer.repo.MemoryMemberRepo;
//import customer.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///** java code로 직접 스프링 빈에 등록하는 방법*/
//@Configuration
//public class SpringConfig {
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepo());
//    }
//
//    @Bean
//    public MemberRepo memberRepo(){
//        return new MemoryMemberRepo();
//    }
//}
