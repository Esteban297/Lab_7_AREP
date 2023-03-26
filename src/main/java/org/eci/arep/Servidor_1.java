package org.eci.arep;

import static spark.Spark.*;

public class Servidor_1 {
    public static void main(String[] args) {
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/server", (req, res) -> "Servidor 2 Funcionando");
        get("/remoteServer", (req, res) -> URLReader.readSecureUrl("https://ec2-100-25-103-106.compute-1.amazonaws.com:3000/server",getKeyServerOne(), getPwdKeyStore()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3001 ;
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "/home/ec2-user/target/certificados/ecikeystore2.p12";
    }

    static String getKeyServerOne() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "/home/ec2-user/target/certificados/ecikeystore1.p12";
    }

    static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "123456";
    }
}
