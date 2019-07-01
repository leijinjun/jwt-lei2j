import com.lei2j.jwt.validator.DefaultJwtClaimsValidator;
import com.lei2j.jwt.JwtBuilder;
import com.lei2j.jwt.coder.JwtDecoder;
import com.lei2j.jwt.validator.JwtVerify;
import com.lei2j.jwt.algorithm.Algorithm;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lei2j on 2018/12/4.
 */
public class TestJwt {

    @Test
    public void test1(){
        String jwt = JwtBuilder.builder().setIssuedAt(new Date())
                .setAudience("www").addPublicClaim("name","冰与火")
                .setIssuer("lei").build()
                .sign(Algorithm.hmacSHA256("1234"));
        System.out.println(jwt);
    }

    @Test
    public void test2(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoi5Yaw5LiO54GrIiwiaXNzIjoibGVpIiwiYXVkIjoid3d3IiwiaWF0IjoxNTYxOTUxNjQxMTk2fQ.WMVFyz8D-l66P5HF83UUdSd0lAC6NSMXV06bDJTqQ_o";
        JwtDecoder jwtDecoder = JwtDecoder.decode(token);
        JwtVerify jwtVerify = new JwtVerify(jwtDecoder, Algorithm.hmacSHA256("1234"), new DefaultJwtClaimsValidator());
        System.out.println(jwtVerify.verify());
    }

}
