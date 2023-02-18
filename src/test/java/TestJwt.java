import com.lei2j.jwt.exception.JwtDecoderException;
import com.lei2j.jwt.validator.DefaultJwtClaimsValidator;
import com.lei2j.jwt.JwtBuilder;
import com.lei2j.jwt.coder.JwtDecoder;
import com.lei2j.jwt.validator.JwtVerify;
import com.lei2j.jwt.algorithm.Algorithm;
import org.junit.Test;

import java.security.*;
import java.util.Date;

/**
 * Created by lei2j on 2018/12/4.
 */
public class TestJwt {

    @Test
    public void test1() throws NoSuchAlgorithmException, KeyStoreException {
        String jwt = JwtBuilder.builder().setIssuedAt(new Date())
                .setAudience("www").addPublicClaim("name","冰与火")
                .setIssuer("lei").build()
                .sign(Algorithm.shaWithRSA256("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDBBv9/JTzXyZqH" +
                        "wV0WYGLQqL1JODZk1myPzc0DdME5VTpIK55/hp6VzU5EtB7PvJ8CAgwZ/8iQ/VHw" +
                        "diqh9y9hUo6baAPFUmXLNE4PktNOrLx1a723auHM+Cfs69vYkKlfUsAku0lfwNQP" +
                        "C4j+RrlGAc+ewT2mEbQB73BcznSYuhxjabDj821biN8O1fPXd0xGppLiZTNkavnI" +
                        "9/vrO0mWEJoG81YRbNBvHzyeO79XCmrF6ZAuHrX9MLOdtApdH7rjgB6EhvXgsWuB" +
                        "6e3zR2vghSPd7LPXu40JDntEZJoEWJhHFXEScqgGQaxTr+a01AekrfUXSuWfuAiB" +
                        "ysm1hUxFAgMBAAECggEBAKhbezMhfnzTqUWo4JEoxmcqFdasAb1XzF5s6NiP2Awy" +
                        "it/xs4+VEfKknBSOaaVU5fcxY+61SvEzEWnDFxInb5raD+n6Aff0Ezb2SvOIY2dm" +
                        "gAWGUHWO8pz9AI3Ddf/gxOmQWmhvNeMfY5YvwG/Prb8iyzyzXRrgq/lYJs+7frTJ" +
                        "cycxjL7K2V5bdpt6/nVxB1bNNPYxjV8KlDHDfYUgqppo5RQtQbIAyVKBzn6+pSin" +
                        "AeJaf432Z5PE8P6v+1jbcvlADTjf3vlGFHxaySRvAGbKhGaI+y8IzCn2pq/nPLXR" +
                        "7ZH49FuBa/32ecq2zdQ2VMtRLOlCD5DDkRKknhRxUWECgYEA4v/dSKAkd9Tuehsu" +
                        "IVnC/vIaGaMDM8wvJlY6ZS972kHsjBO0Nr0Q1A9G5o+jM0JwN8wDvfi5GidEWnsa" +
                        "1yRD9WzR07b4Y7l58TEFsPH9ANCXXYCGfySlgkhN6vn2gFvsJiZ+3h3esGDLaGPT" +
                        "9ZLtaBUPXQo/cJLetL2Yyj4u9n0CgYEA2bAOrjEd3c5q+IjcdZAlGJY5gSn2xQ+8" +
                        "XnrKPVDZB/nnesLqrxBYcRtymKaoCyLra5MnKNXtX9lJ7wDjZqjHcHmXf6Q8tSld" +
                        "vmybtubpRixQfID/bHrswMt2GGxw1FRKaU4Q15wj+CaTyOezdAFfS0e9DBkR4oDB" +
                        "Al8sZFiKb2kCgYA6wEJDg78sjJ3UWKiN1S+U0JBUxk4T3+rsHzEp8yo5CQryDj98" +
                        "U17Bo9qT3eU9ZRqqNlFZn8A4tqUITghaWnaEVM/R3e9X0C9xb2CrtVXoGhSzDIrC" +
                        "6Xc0ywXvpRZZjnEGRrxbPJvgRo0ezYeUbZyobZr2V6qntjuRx+h9n66D+QKBgQC3" +
                        "uyMI3qfIl/otPsZj63+D2vc6D0MaXAeu7pBXZC9pzgET2gPeMjuTa4kzUiYvEBAH" +
                        "QbIhgz3QUkNWmDdWZEnAor+9mc8rUHiwylY673YgJjLggrgSxUWiC5fnUU+Bxorv" +
                        "ilYoxL6PKXA+d2E9HhNiJHBpD5fKxsUgzVdYcmqVUQKBgHKUON6/5K5F6ahhW8VL" +
                        "A4tQ7+ZG3K6gAXI5vZVyFgArnF62P1lzCpvQ62X/MU9oi0T39UkjEXmqkY+TKcMh" +
                        "Kh4jBSgBqYVqJSTAWR/mJt0oRtsmtip/d6ushuJlAKNO55Y8ShBqDHFEdgVH5dz/" +
                        "YbZqahCRBd50htxTdC1jurVy"));
        System.out.println(jwt);
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        System.out.println(keyStore);
    }

    @Test
    public void test2() throws JwtDecoderException {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ3d3ciLCJuYW1lIjoi5Yaw5LiO54GrIiwiaXNzIjoibGVpIiwiaWF0IjoxNTY5MDc5OTAxOTExfQ.NGgI2hb0FZGvK714TDr071D_9zAk5CrByiPXDX3NXVABRy-s38EocqvRa19B-yhEHF9uv3-Ej2NOj8tpQu2BeZarJHWUr15uit7OC46-wkvSmMpoBW4l9y0HogHQ4GaZ3QRaQuVkXHz9o6i0GQjwwWWe4kutTkT4drWNsEG45VKtD21wAOh2DBbjQZUDNSAwTLriarTK5l9q2PEyKZDn_hzeTZl4ntQv6UUBpscjE0L5IaMjF6RNwSNh9j_x_-DPowJhdyYm3lwI_F_6d6gpB6MAR2fMafTVgjsrbtasddBREQgh2LMmCVkOCnjKJMu3OXPlMxHmPjx3jvBgh6flwg\n";
        JwtDecoder jwtDecoder = JwtDecoder.decode(token);
        JwtVerify jwtVerify = new JwtVerify(jwtDecoder, Algorithm.shaWithRSA256("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQb/fyU818mah8FdFmBi" +
                "0Ki9STg2ZNZsj83NA3TBOVU6SCuef4aelc1ORLQez7yfAgIMGf/IkP1R8HYqofcv" +
                "YVKOm2gDxVJlyzROD5LTTqy8dWu9t2rhzPgn7Ovb2JCpX1LAJLtJX8DUDwuI/ka5" +
                "RgHPnsE9phG0Ae9wXM50mLocY2mw4/NtW4jfDtXz13dMRqaS4mUzZGr5yPf76ztJ" +
                "lhCaBvNWEWzQbx88nju/VwpqxemQLh61/TCznbQKXR+644AehIb14LFrgent80dr" +
                "4IUj3eyz17uNCQ57RGSaBFiYRxVxEnKoBkGsU6/mtNQHpK31F0rln7gIgcrJtYVM" +
                "RQIDAQAB"), new DefaultJwtClaimsValidator());
        System.out.println(jwtVerify.verify());
    }

    @Test
    public void test3(){
        String s = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDBBv9/JTzXyZqH" +
                "wV0WYGLQqL1JODZk1myPzc0DdME5VTpIK55/hp6VzU5EtB7PvJ8CAgwZ/8iQ/VHw" +
                "diqh9y9hUo6baAPFUmXLNE4PktNOrLx1a723auHM+Cfs69vYkKlfUsAku0lfwNQP" +
                "C4j+RrlGAc+ewT2mEbQB73BcznSYuhxjabDj821biN8O1fPXd0xGppLiZTNkavnI" +
                "9/vrO0mWEJoG81YRbNBvHzyeO79XCmrF6ZAuHrX9MLOdtApdH7rjgB6EhvXgsWuB" +
                "6e3zR2vghSPd7LPXu40JDntEZJoEWJhHFXEScqgGQaxTr+a01AekrfUXSuWfuAiB" +
                "ysm1hUxFAgMBAAECggEBAKhbezMhfnzTqUWo4JEoxmcqFdasAb1XzF5s6NiP2Awy" +
                "it/xs4+VEfKknBSOaaVU5fcxY+61SvEzEWnDFxInb5raD+n6Aff0Ezb2SvOIY2dm" +
                "gAWGUHWO8pz9AI3Ddf/gxOmQWmhvNeMfY5YvwG/Prb8iyzyzXRrgq/lYJs+7frTJ" +
                "cycxjL7K2V5bdpt6/nVxB1bNNPYxjV8KlDHDfYUgqppo5RQtQbIAyVKBzn6+pSin" +
                "AeJaf432Z5PE8P6v+1jbcvlADTjf3vlGFHxaySRvAGbKhGaI+y8IzCn2pq/nPLXR" +
                "7ZH49FuBa/32ecq2zdQ2VMtRLOlCD5DDkRKknhRxUWECgYEA4v/dSKAkd9Tuehsu" +
                "IVnC/vIaGaMDM8wvJlY6ZS972kHsjBO0Nr0Q1A9G5o+jM0JwN8wDvfi5GidEWnsa" +
                "1yRD9WzR07b4Y7l58TEFsPH9ANCXXYCGfySlgkhN6vn2gFvsJiZ+3h3esGDLaGPT" +
                "9ZLtaBUPXQo/cJLetL2Yyj4u9n0CgYEA2bAOrjEd3c5q+IjcdZAlGJY5gSn2xQ+8" +
                "XnrKPVDZB/nnesLqrxBYcRtymKaoCyLra5MnKNXtX9lJ7wDjZqjHcHmXf6Q8tSld" +
                "vmybtubpRixQfID/bHrswMt2GGxw1FRKaU4Q15wj+CaTyOezdAFfS0e9DBkR4oDB" +
                "Al8sZFiKb2kCgYA6wEJDg78sjJ3UWKiN1S+U0JBUxk4T3+rsHzEp8yo5CQryDj98" +
                "U17Bo9qT3eU9ZRqqNlFZn8A4tqUITghaWnaEVM/R3e9X0C9xb2CrtVXoGhSzDIrC" +
                "6Xc0ywXvpRZZjnEGRrxbPJvgRo0ezYeUbZyobZr2V6qntjuRx+h9n66D+QKBgQC3" +
                "uyMI3qfIl/otPsZj63+D2vc6D0MaXAeu7pBXZC9pzgET2gPeMjuTa4kzUiYvEBAH" +
                "QbIhgz3QUkNWmDdWZEnAor+9mc8rUHiwylY673YgJjLggrgSxUWiC5fnUU+Bxorv" +
                "ilYoxL6PKXA+d2E9HhNiJHBpD5fKxsUgzVdYcmqVUQKBgHKUON6/5K5F6ahhW8VL" +
                "A4tQ7+ZG3K6gAXI5vZVyFgArnF62P1lzCpvQ62X/MU9oi0T39UkjEXmqkY+TKcMh" +
                "Kh4jBSgBqYVqJSTAWR/mJt0oRtsmtip/d6ushuJlAKNO55Y8ShBqDHFEdgVH5dz/" +
                "YbZqahCRBd50htxTdC1jurVy";
        System.out.println(s.replaceAll("[\\r\\n]",""));
    }

    @Test
    public void test4() throws NoSuchAlgorithmException, JwtDecoderException {
        Long iat = System.currentTimeMillis() / 1000;
        final String sign = JwtBuilder.builder().addPublicClaim("iss", "9wGa0Wyip4Q7BDNdC4d4J0eCmUXTZ1ZO")
                .addPublicClaim("iat", iat)
                .addPublicClaim("nbf", iat - 5)
                .addPublicClaim("exp", iat + 60)
                .build()
                .sign(Algorithm.hmacSHA256("iOWORRnA1sJ7peVTFk72FgKwmuWHKDPQ"));
        System.out.println(sign);
        JwtDecoder jwtDecoder = JwtDecoder.decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI5d0dhMFd5aXA0UTdCRE5kQzRkNEowZUNtVVhUWjFaTyIsImlhdCI6MTY3NDAxNDA4NSwibmJmIjoxNjc0MDE0MDgwLCJleHAiOjE2NzQwMTQxNDV9.WjtK8MmE0RkIY-rCzrEmZTMWqeTzjuGgTVDOyvyDr2E");
        final JwtVerify jwtVerify = new JwtVerify(jwtDecoder, Algorithm.hmacSHA256("iOWORRnA1sJ7peVTFk72FgKwmuWHKDPQ"), new DefaultJwtClaimsValidator());
        System.out.println(jwtVerify.verify());
    }

}
