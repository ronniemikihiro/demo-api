package com.example.demoapi.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.security.MessageDigest;

/**
 * Gera uma senha encodada. (Utilizada para testes, não faz parte do projeto).
 */
public class GeradorSenha {

	public static void main(String[] args) {
		System.out.println("BCryptPasswordEncoder");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String senhaBCryptPasswordEncoder = bCryptPasswordEncoder.encode("123");
		System.out.println(senhaBCryptPasswordEncoder);
		System.out.println(senhaBCryptPasswordEncoder.length());

		System.out.println("-------------------------------");

		System.out.println("StandardPasswordEncoder");
		StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
		String senhaStandardPasswordEncoder = standardPasswordEncoder.encode("admin");
		System.out.println(senhaStandardPasswordEncoder);
		System.out.println(senhaStandardPasswordEncoder.length());

		System.out.println("-------------------------------");

		System.out.println("Pbkdf2PasswordEncoder");
		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
		String senhaPbkdf2PasswordEncoder = pbkdf2PasswordEncoder.encode("admin");
		System.out.println(senhaPbkdf2PasswordEncoder);
		System.out.println(senhaPbkdf2PasswordEncoder.length());

		System.out.println("-------------------------------");

		System.out.println("SCryptPasswordEncoder");
		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
		String senhaSCryptPasswordEncoder = sCryptPasswordEncoder.encode("admin");
		System.out.println(senhaSCryptPasswordEncoder);
		System.out.println(senhaSCryptPasswordEncoder.length());

		System.out.println("-------------------------------");

		System.out.println("Exemplo banco:");
		System.out.println("094ff24887c84bb3258068d044fa85cf560f92ce6a1453c547d0efa3bea0a8b1");
		System.out.println("094FF24887C84BB3258068D044FA85CF560F92CE6A1453C547D0EFA3BEA0A8B1".length());

		System.out.println("-------------------------------");

		System.out.println("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225");
		System.out.println("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225".length());

		System.out.println("-------------------------------");

		System.out.println("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918".length());

		System.out.println("-------------------------------");

		try {
			String a = fncsha("admin");
			System.out.println(a);
			System.out.println(a.length());

		} catch (Exception e) {

		}
	}

	static public String fncsha(String inputVal) throws Exception
	{
		MessageDigest myDigest = MessageDigest.getInstance("SHA-256");
		myDigest.update(inputVal.getBytes());
		byte[] dataBytes = myDigest.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dataBytes.length; i++) {
			sb.append(Integer.toString((dataBytes[i])).substring(1));
		}
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<dataBytes.length;i++) {
			String hex=Integer.toHexString(0xff & dataBytes[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		String retParam = hexString.toString();
		return retParam;
	}

}
