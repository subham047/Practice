package com.subham.Practice.Utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class jwt {
    private static final Logger log = LoggerFactory.getLogger(jwt.class);

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {

        //For building a jwt token                                           -- Do not remove this logic
//        String userId = "hdfcpwa";
//        String userToken = "1234567890ABDEDF";
//        String secret = "1234567890ABDEDF" + userId;
//        String str = buildJwtToken(userId, userToken, secret);
//        System.out.println(str);


        //For fetching details from a jwt token of HS512 algorithm              -- Do not remove this logic
//        String token = "";
//        String secret = "";
//        Claims json = fetchDataFromJwt(token, secret);
//        System.out.println(json.get("Role"));
//        System.out.println("json = " + json);


        //For fetching details from a jwt token of RS256 algorithm
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJjb252ZXJzaW9uUmF0aW8iOjEwMC4wLCJiYWxhbmNlIjo1MDAsImlzcyI6ImF1dGgwIiwidmlydHVhbFVzZXJJZCI6ImZkc2hhZ2tpNzZkc2F0ZmFka3MiLCJleHAiOjE2NzU4NDY3MDJ9.fhPvMVe_L_bHMTIdvfJkC-Ir93G0dvSluTcUtoSV2cLDEvfSUMPRq4YE8-b1zofGzhVPJFGyGQZr_44UQbQ0NDE9jvj88oihAWRvTu7hI_ifBetQXsrj8qHy8R24QFMz4qqHC38fyEXtMr8OhuBIvS46ZUQBAbrNJrN-CUs1zkwWUSzGspP8U28s8vj3y61rE6K0cqs7nCVGffEIztIkYTWzkijDdvvIOJAfNFJOsr1XOxSF7upvlbzKvyBZ3-Tymfsej8wX5Ay-Pi1lGQogvzbOwnr4xV3pOSZAUFgO3AFhkwDrLr-YZ9YNiIMl85Ipo-iCpyHjHDY1raGc_MssYg";
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJjb252ZXJzaW9uUmF0aW8iOjEwMC4wLCJiYWxhbmNlIjo1MDAsImlzcyI6ImF1dGgwIiwidmlydHVhbFVzZXJJZCI6ImZkc2hhZ2tpNzZkc2F0ZmFka3MiLCJleHAiOjE2NzUwNzg3NzN9.J2gjxnHa6t3kNl-W0ZdV2LUM-RV-GJRNm45kKWEVrP57CMmE8lsgTiGc5t2T6S8xR_OlkncNz_mBaMVLSslQScuHYNSu6gvFwxkRqGF4fEfgPGib1kmkSOZpp2zeg3titwJ4yZbfBqd3h8bBBbq97a4TFtcH6JaFoJ9p9iR_uislEHtNVnj6uMEhg_ROZaJ4aGixeYu6DLA_xiUvm1K9piJ4WsD2SIT82Hp5ulolpmgbDnaaL0C-9qJWgYDJkYQI_n89yCZLAHxIE646IPQtTvELTw-xvTPcOYtMdPkzEXwE8wgW8dbbeocCoPq-rxiMbAphbYygVQtnZbyKomOOlg";
        String secret = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCSHsyXJEAJJl6t\n" +
                "1F469HSNUzUAQzkP9x5ov9Rv8y0xrANFsxGIESwBRjoaPTWHJkU1+DT06frmByTa\n" +
                "0TapxiurXW2mBWRml1Fa3I/OduF0cHRYVe2uze1sbN+ITkZih01tkUE3IRbihkCy\n" +
                "8fzpyGOZVViaFCzKe0iA5noplQcLocx+LNryTAzbJ9qj3TMiONNmqsPsQTcdv51L\n" +
                "KXZpGtxH7LnzMcnyQxszqcdGa9Yp2pBd/5Y2jUTSxV1W/gtPwXTsaWCbnChPQneJ\n" +
                "eafqQtbTCyVbP7EEgwf95yihPAiimvr//s5BBP5ZEh/mCc4VyYOt16VUpr9T9WN3\n" +
                "h1MFDSPHAgMBAAECggEABZTunNFyLsdL85j6tobTEvj8O9PVkLIQc9DsJRClh9G5\n" +
                "2EZEY63AQBY2Lv1ql4yTNUITh82OW44nTsKSM38R+PxbLW3kTXT3UyC8z5bD+wY2\n" +
                "s48owrY0HSG1kkfnMWlYwFg9pQT7ElEtlIhg8G9KurdDaLNfmKaH+QCU5xS9zahk\n" +
                "Uc/AU8hqPrl+eUwV3moloGGuxehjlivQImWjS927xoc+tbvB7k4mdzd+fyodtd5I\n" +
                "6EMLpnapJLgFsMglrzNEuYIMpUFdEwkqSJ6KRjLWE3SNd7vkqvudI1c/ZNWAyIQD\n" +
                "ni/21D3x+YTKQ/gMXY8hxEohD8DapYVi4IXtEQwFpQKBgQDM5RepVqJ+329vqUrj\n" +
                "dBZK+1Yf7Dil9rlnMLpLyG4jyVGEjkW5y0zY+kYwFAfCWdYBdAKuc5lyOELdU0G2\n" +
                "xlPPSU210jnShlAyF3VAZq0GPtZjoqL0m4KFdGNZ0SmxhP4t8ArD9zVMjzvppHLp\n" +
                "fcpQFsvdAhJQl4XIQ3QkHkjXvQKBgQC2kNgHrePwv8X/bQrAuaMd3V3T8we/4K6L\n" +
                "xeQg6a7ahPGxiUcbI20AlsDt5PiRLlmorY8XKBqRK+bs8CuJudoMBOODLp4SDNIH\n" +
                "FzssfMYaYOk/d76X0JxJLPvvhtCt7ghcjycDd5glmRWVBZVtWe1gIYMuvqyGN3+r\n" +
                "xz4fNTBP0wKBgBAHcBVwUKAKTMZ4gQJQR5owFWnD6h6ZsaFv/3MESBGGo1jyZGQH\n" +
                "koh689i5CG5c5tAQSlFpe7yiyCBWbhKla1MREgJCYwGkPkvc5/BU1/5gFhePVp46\n" +
                "ODjGhSs2oMNhex0O5Vi1UzcdEXvSwKahj506W1J74gDqCa5EEKbus5YlAoGBAIGh\n" +
                "0bOKNssw8N+QxszYQ8ml8MTZ0YvedzIKXxU7uQuy0IeWiWXsvq5nXTDOn+0+sy1B\n" +
                "p9PyhwLD4KInW1LdI8XbBs2UIWuBrPSZ+0t4gZYjcBu/5Baaaw7OoUmQOcb2uPs4\n" +
                "LqSYm/E+hQOexl6yNwpGYYakn45iBAauYB76voY/AoGBAJuPSNg3NOwmLHbAUg2p\n" +
                "b08RMgful6RePv9D0sbv5JOCpRDXfOPnDmaGE0vKJBSWt4eX4/CFGoSdcln24AtS\n" +
                "28wPSYQaR3cNq3IdiAl8c+evF7EDP85C3oYjo4NxFrLbrD4HqmQzLMErsA8UpyzO\n" +
                "ZHoqPOMLjxMEd2tQstTaLL0b\n" +
                "-----END PRIVATE KEY-----";
        Claims json = jwtData(token, secret);
        System.out.println("json = " + json);
    }

    public static boolean validateToken(String expectedUserId, String jwtToken, String secret) {
        String tokenName;
        try {
            tokenName = fetchDataFromJwt(jwtToken, secret) + "";
            System.out.println("tokenNametokenNametokenName " + tokenName);
        } catch (Exception e) {
            System.out.println("Error " + e);
            return false;
        }
        if (expectedUserId.equals(tokenName) == false) {
            System.out.println("Token:{} and userId:{} don't match:" + tokenName + "   " + expectedUserId);
            return false;
        }
        return true;
    }

    //For HS512 algorithm
    private static Claims fetchDataFromJwt(String token, String secret) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (JwtException e) {
            throw new IllegalStateException("Could not verify JWT token", e);
        }
    }

    //For RS256 algorithm
    private static Claims jwtData(String token, String secret) throws InvalidKeySpecException, NoSuchAlgorithmException {


        secret = secret.replace("-----BEGIN PRIVATE KEY-----", "");
        secret = secret.replace("-----END PRIVATE KEY-----", "");
        secret = secret.replace("\n", "");

        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privKeySpecPKCS8 = new PKCS8EncodedKeySpec(java.util.Base64.getDecoder().decode(secret));
        PrivateKey key = kf.generatePrivate(privKeySpecPKCS8);
        System.out.println("key = " + key);

        try {
            Claims json = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String buildJwtToken(String userId, String userToken, String secret) {
        JSONObject json = new JSONObject();
        try {
            json.put("userId", userId);
            json.put("userToken", userToken);
        } catch (Exception e) {
            System.out.println("Failed to find buildJwtToken.");
        }
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS512, secret).setPayload(json.toString()).compact();
        return token;
    }
}



