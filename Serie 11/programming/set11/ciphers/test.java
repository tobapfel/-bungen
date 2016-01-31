package programming.set11.ciphers;

public class test {
	public static void main(String args[]) {
		CaesarCipher cipher = new CaesarCipher(CryptMode.ENCRYPT, 3);
		String bla = cipher.encode("Hallo");
		System.out.println(bla);
	}

}
