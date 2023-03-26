package org.eci.arep;

import static spark.Spark.*;

public class Servidor_0 {

    public static void main(String[] args) {
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/server", (req, res) -> "Servidor 1 Funcionando");
        get("/remoteServer", (req, res) -> URLReader.readSecureUrl("https://ec2-44-208-167-180.compute-1.amazonaws.com:3001/server",getKeyServerTwo(), getPwdKeyStore()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3000;
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "/home/ec2-user/target/certificados/ecikeystore1.p12";
    }

    static String getKeyServerTwo() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "/home/ec2-user/target/certificados/ecikeystore2.p12";
    }

    static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "123456";
    }
}