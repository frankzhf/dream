package net.frank.framework.payment.face.service;

import net.frank.framework.payment.face.domain.AliConfig;
import net.frank.framework.payment.face.domain.AliPartnerConfig;

public class TestAliFacePayService {

	public static void main(String[] args) {
		AliConfig aliConfig = new AliConfig();

        aliConfig.setOpenApiDomain("https://openapi.alipay.com/gateway.do");
        aliConfig.setMcloudApiDomain("http://mcloudmonitor.com/gateway.do");
        AliPartnerConfig aliPartnerConfig = new AliPartnerConfig();
        aliPartnerConfig.setAliConfig(aliConfig);

        aliPartnerConfig.setPid("2088121185642914");
        aliPartnerConfig.setAppid("2015121000953533");

        aliPartnerConfig.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCwl5lAt9ofjjYBDNME2MALFZGr05aGOClAKWEjnebiJ/zpabM8gJl1/VS2PQqN9nU/ac0NjFFdH4jeFfa+KXdv9G/e236wAmP3UjH4GBpGTlsL4zeQYvzmjLWLo95xZ7dFWdf0N1ilmkQ4m70WwBuIf2HDnIz/ClhTSL6YhO/dsmeZw6iTtqsXKVdUmJdLDrCbn6OV9D4FKpS4vblK9kf71xNRgqtqxNcw0Wj3QqyZNfG6aZV3/EdqZBMwgr7u6FkOlFfnW1q4R/yZzfNxI3GgzqErEAbY4O2l6ufP5c7xcdXh6sqPonmxAMUh/wrh0wtkf/my+QJ2/L8oNB0Nkw7dAgMBAAECggEADGnrxQfnlnZJx5MeNmYCQgU3I0wRdcf25mLCSF2uQFGtTr82cVdc8lVnohPybP5ZSabnWj917MTtuybyHHYPxlf5kUH+yuKwIk+t4ZHYLv8NGW3UlxrOSmqzzGgtl+1Bjed97dYCLkoE57HS/gltJhBGUBjuNHOGt/wSIeiecAgfhaxZcCQRDZPakCp/LSZZF6JhzeQ3/GiZ8PvG3VlpOM02faeXO1rert1RLuz9X3zMpM55gv8rxch0gCuoIu1C8EB1wA1/ajIjqvsqekfjw8WmREXn3l+8pQk9iKT7VRSVAyS2FFE/E/WCtF/OBUKG0niop5+KBxxyxSHsUZxmAQKBgQDqPqMGlgKs3j1lLyyY9ZfrJsfvKf3FkIQacs0VqA7PMvmhk1RBP9mRBQJE89bBbDXlosAhozODF0QJ3tmRfx+7N4kWlv4HNUfMsDEFGRj0LEzX4AJtwlRtf9P9pzPQulwwGs3uRAKClzBOxpm9W7j4gpNbXiQV65f5MgJ/m/m9gQKBgQDA/jm+P2la35L5bKf8zC7MPJTxliMnWQAk8cVODiJlto8iHzKk59fg/0yqTooTROJ6XEgGVjgGrMxyawvncdFK55S6s19M+MX1ugA0cga1fG4c+3iAkTVemTtkFKmMTFDu3UyxHicHNDtWaXtJIWIHfcPE72j5u8Q+u8D0UmK3XQKBgQCvLUaX30mC4/TAHeZZQZlqFyeAGUQaInhYmy/6GSNyGqoLBnYFEe3wAPHwhPY+0mEAKZVL0pPsXlLYmtrUb2BYjzCrPyIcW+ElF0KhkGJUAGk7K+BFGwYumWD9GbSrTSMyKmmE3UGPTeenkehZbyXGW0g+FQohhn2xs4+gxRGggQKBgQCnOGAuAOG3lHrT1ZrkxsJRwrhHb5B8GniuijIsRMD3Iqx4o1GNYzlBQdRayHyI36ng3a6mlvQqjHUFOs1wt8ThwzCyaJNNrUxRct2Uk6xOekcqo5WwyKDWm6zDNcgGwWVq4qL94KNucYpsgC8LmXpIBWeobsylflU3ChXRXMUeHQKBgC5n5Lgyjdm5X+UMXcyOkM0UTvWN5qqxqxilJBTDVSLvC+fLobhGISEEqnlUta7dbjNf0W7IUfj4L3oAeTry9dm2aPxwAFziJHasiWKTtpPqShWoLaLK7yctZXo3blh2pst/ianbl3wX7q7XwfDwK4dwKDwPP0Hd4/ngJJZ3DCYZ");
        aliPartnerConfig.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsJeZQLfaH442AQzTBNjACxWRq9OWhjgpQClhI53m4if86WmzPICZdf1Utj0KjfZ1P2nNDYxRXR+I3hX2vil3b/Rv3tt+sAJj91Ix+BgaRk5bC+M3kGL85oy1i6PecWe3RVnX9DdYpZpEOJu9FsAbiH9hw5yM/wpYU0i+mITv3bJnmcOok7arFylXVJiXSw6wm5+jlfQ+BSqUuL25SvZH+9cTUYKrasTXMNFo90KsmTXxummVd/xHamQTMIK+7uhZDpRX51tauEf8mc3zcSNxoM6hKxAG2ODtpernz+XO8XHV4erKj6J5sQDFIf8K4dMLZH/5svkCdvy/KDQdDZMO3QIDAQAB");
        aliPartnerConfig.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjBpnGYvSp5iwwANMj/xkWM+uv35c6I0Zah8Cnt8TmS+sWLUoVBr0hHjjYSRAvi2stohodWY1zD2nprpb1S8yA5VwW9VWdpRyUUE/mItFgqSDQBqZCWOiyF3hN7VM3PosUP5pOAcb1kccJEkt0OC8viVRpPf3XfaYHWe0mtkMmjnyWOjoiFBvmX0pigiFkCv73ldgNmBAvTj7j/tBNP7fVeQRIIQgXkvDGnTg95TOHoUiEIbzT3foP/KRCFu5W6S9AZah1nfhz163EesR8xQw7CsL6sI/b2nyIZ6Lav1+OLcBCl5h1/LLYhhxX2dKnu3OsEyee4/mcZaxZv2P40aD9QIDAQAB");

        aliPartnerConfig.setSignType("RSA2");

        aliPartnerConfig.setMaxQueryRetry(5);
        aliPartnerConfig.setQueryDuration(5000L);

        aliPartnerConfig.setMaxCancelRetry(3);
        aliPartnerConfig.setCancelDuration(2000L);

        aliPartnerConfig.setHeartbeatDuration(5L);
        aliPartnerConfig.setHeartbeatDuration(900L);

        FacePayService service = new FacePayService();

        service.ali("1110110111011129",
                "服务测试","0.01","288653042220031235","0.01",
                aliPartnerConfig,null);
	}

}
