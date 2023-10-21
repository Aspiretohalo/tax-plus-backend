package com.taxplus.taxplusbackend.utils;

import java.util.HashMap;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.JWT;

public class psignUtils {
    public static Integer AppId = 1317662942;// 用户 appid
    public static String FileId = "";
    public static String AudioVideoType = "RawAdaptive";// 播放的音视频类型
    public static Integer RawAdaptiveDefinition = 10;// 允许输出的未加密的自适应码流模板 ID
    public static Integer ImageSpriteDefinition = 10;// 进度条预览的雪碧图模板 ID
    public static Integer CurrentTime = 1589448067;
    public static Integer PsignExpire = CurrentTime + 3600000;// 可任意设置过期时间，示例1h
    public static String UrlTimeExpire = "5ebe9423‬";// 可任意设置过期时间，16进制字符串形式，示例1h
    public static String PlayKey = "TxtyhLlgo7J3iOADIron";

    public static String Psign() {
        HashMap<String, Object> urlAccessInfo = new HashMap<String, Object>();
        urlAccessInfo.put("t", UrlTimeExpire);
        HashMap<String, Object> contentInfo = new HashMap<String, Object>();
        contentInfo.put("audioVideoType", AudioVideoType);
        contentInfo.put("rawAdaptiveDefinition", RawAdaptiveDefinition);
        contentInfo.put("imageSpriteDefinition", ImageSpriteDefinition);

        try {
            Algorithm algorithm = Algorithm.HMAC256(PlayKey);
            String token = JWT.create().withClaim("appId", AppId).withClaim("fileId", FileId)
                    .withClaim("contentInfo", contentInfo)
                    .withClaim("currentTimeStamp", CurrentTime).withClaim("expireTimeStamp", PsignExpire)
                    .withClaim("urlAccessInfo", urlAccessInfo).sign(algorithm);
            System.out.println("token:" + token);
            return token;
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            System.out.println("psign生成失败");
        }

        return null;
    }


}
