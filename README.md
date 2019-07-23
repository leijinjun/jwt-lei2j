![GitHub Pre-Releases](https://img.shields.io/github/downloads-pre/leijinjun/jwt-lei2j/0.9.0/total.svg?color=%2349C31B)
![GitHub release](https://img.shields.io/github/release-pre/leijinjun/jwt-lei2j.svg?color=%231182C3)
![language java](https://img.shields.io/badge/language-java-be864f.svg)
# 介绍
本项目是JWT规范使用JAVA语言的一种实现。
目前还在测试阶段，不建议在生产环境中使用，如果有兴趣的话，可以一起交流学习。
目前对于JWT规范中算法实现以下`HS256`、`HS384`、`HS512`、`RS256`、`RS384`、`RS512`、`ES256`、`ES384`、`ES512`。
# 使用
1. 生成JWT字符串
2. ``Jwt jwt = JwtBuilder.builder().setIssuedAt(new Date()).setAudience("www").addPublicClaim("name","冰与火")
.setIssuer("lei").build(); ``,构建一个Jwt对象
3. ``String jwtToken = jwt.sign(Algorithm.hmacSHA256("123456"));``,使用SH256算法及密钥123456生成一个token。
4. 验证jwt字符串
5. ``String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ3d3ciLCJuYW1lIjoi5Yaw5LiO54GrIiwiaXNzIjoibGVpIiwiaWF0IjoxNTYzODkyOTkyMDQxfQ.8oG70bSpQtJhQdH3yaf8XD4sMhQfIo73RE_0OkeSRMQ";
    //解析JWT字符串
    JwtDecoder jwtDecoder = JwtDecoder.decode(token);
    //根据对应的算法、密钥，使用Jwt校验器来校验该Jwt token字符串是否验证通过
    JwtVerify jwtVerify = new JwtVerify(jwtDecoder, Algorithm.hmacSHA256("123456"),new DefaultJwtClaimsValidator());
    //验证
    jwtVerify.verify();
``

