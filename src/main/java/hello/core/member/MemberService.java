package hello.core.member;

/**
 * Created by Imaspear on 2021-12-11
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
