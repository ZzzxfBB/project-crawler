package com.iskeen.project.crawler.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.iskeen.project.crawler.common.constant.Constant;
import com.iskeen.project.crawler.common.exception.BizException;
import com.iskeen.project.crawler.common.exception.CommonError;
import java.util.Date;

/**
 * @ClassName JWTUtil
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/9/9 5:53 下午
 * @Version V1.0
 **/

public class JWTUtil {


  // 过期时间2小时
  private static final long EXPIRE_TIME = Constant.TOKEN_TTL;

  /**
   * 校验token是否正确
   *
   * @param token  密钥
   * @param secret 用户的密码
   * @return 是否正确
   */
  public static boolean verify(String token, Integer userNo, String secret) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim("accountId", userNo)
          .build();
      verifier.verify(token);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }

  /**
   * 获得token中的信息无需secret解密也能获得
   *
   * @return token中包含的用户名
   */
  public static Integer getUserNo(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("accountId").asInt();
    } catch (JWTDecodeException e) {
      throw new BizException(CommonError.UN_LOGIN, "token异常");
    }
  }

  /**
   * 生成签名,指定时间后过期,一经生成不可修改，令牌在指定时间内一直有效
   *
   * @param userNo 用户编号
   * @param secret 用户的密码
   * @return 加密的token
   */
  public static String sign(Integer userNo, String secret) {
    try {
      Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
      Algorithm algorithm = Algorithm.HMAC256(secret);
      // 附带username信息
      return JWT.create()
          .withClaim("accountId", userNo)
          .withExpiresAt(date)
          .sign(algorithm);
    } catch (Exception e) {
      throw new BizException(CommonError.UN_LOGIN, "token加密异常");
    }
  }


  public static boolean isExpired(String token) {

    try {
      DecodedJWT jwt = JWT.decode(token);
      Date expiresAt = jwt.getExpiresAt();
      return expiresAt.before(new Date());
    } catch (JWTDecodeException e) {
      throw new BizException(CommonError.UN_LOGIN, "token异常");
    }
  }


}