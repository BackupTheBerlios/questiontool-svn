package db;

import javax.crypto.*;
import javax.crypto.spec.*;

public class VerschluesselnMitJava {

  final private transient static String password = "ns9N8ARS6t4AnLxhd9k5YM0Dd";
  final private transient byte [] salt = { (byte) 0xc9, (byte) 0xc9,(byte) 0xc9,(byte) 0xc9,(byte) 0xc9,(byte) 0xc9,(byte) 0xc9,(byte) 0xc9};
  final int iterations = 3;

  protected VerschluesselnMitJava() {
//    java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE()); // implizit bereits erledigt!
  }

  /** instance */
  private static VerschluesselnMitJava instance;

  /** Singleton Factory
   * @return instance
   */
  public static VerschluesselnMitJava getInstance () {
    if (instance == null) {
      instance = new VerschluesselnMitJava ();
    }
    return instance;

  }


  /** Notwendige Instanczen */
  private Cipher encryptCipher;
  private Cipher decryptCipher;
  private sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
  private sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

  /** Verwendete Zeichendecodierung */
  private String charset = "UTF16";

  /**
   * Initialisiert den Verschl�sselungsmechanismus
   * @param pass char[]
   * @param salt byte[]
   * @param iterations int
   * @throws SecurityException
   */
  public void init (final char[] pass, final byte[] salt, final int iterations) throws SecurityException {
    try {
      final PBEParameterSpec ps = new PBEParameterSpec(salt, 20);
      final SecretKeyFactory kf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
      final SecretKey k = kf.generateSecret(new PBEKeySpec(pass));
      encryptCipher = Cipher.getInstance("PBEWithMD5AndDES/CBC/PKCS5Padding");
      encryptCipher.init (Cipher.ENCRYPT_MODE, k, ps);
      decryptCipher = Cipher.getInstance("PBEWithMD5AndDES/CBC/PKCS5Padding");
      decryptCipher.init (Cipher.DECRYPT_MODE, k, ps);
    }
    catch (Exception e) {
      throw new SecurityException("Could not initialize CryptoLibrary: " +
                                  e.getMessage());
    }
  }

  /**
   * Verschl�sselt eine Zeichenkette
   *
   * @param str Description of the Parameter
   * @return String the encrypted string.
   * @exception SecurityException Description of the Exception
   */
  public synchronized String encrypt(String str) throws SecurityException {
    try {
      byte[] b = str.getBytes(this.charset);
      byte[] enc = encryptCipher.doFinal(b);
      return encoder.encode(enc);
    }
    catch (Exception e){
      throw new SecurityException("Could not encrypt: " + e.getMessage());
    }

  }

  /**
   * Entschl�sselt eine Zeichenkette, welche mit der Methode encrypt
   * verschl�sselt wurde.
   *
   * @param str Description of the Parameter
   * @return String the encrypted string.
   * @exception SecurityException Description of the Exception
   */
  public synchronized String decrypt(String str) throws SecurityException  {
    try {
      byte[] dec = decoder.decodeBuffer(str);
      byte[] b = decryptCipher.doFinal(dec);
      return new String(b, this.charset);
    }
    catch (Exception e) {
      throw new SecurityException("Could not decrypt: " + e.getMessage());
    }
  }

  @SuppressWarnings("static-access")
public static void main (final String [] ignored) {
    VerschluesselnMitJava man = VerschluesselnMitJava.getInstance();
    man.init(man.password.toCharArray(), man.salt, man.iterations);
    final String encrypted = man.encrypt("Bastie");
    System.out.println ("Verschl�sselt :"+encrypted);
    final String decrypted = man.decrypt (encrypted);
    System.out.println("Entschl�sselt :"+decrypted);
  }
  
  /**
   * Verschl�sselt eine Zeichenkette statisch
   *
   * @param str Description of the Parameter
   * @return String the encrypted string.
   * @exception SecurityException Description of the Exception
   */
  @SuppressWarnings("static-access")
public static String verschluessel(String text1)
  {
	  String text = "";
	  VerschluesselnMitJava man = VerschluesselnMitJava.getInstance();
	    man.init(man.password.toCharArray(), man.salt, man.iterations);
	    text = man.encrypt(text1);  
	    return text;
  }
  
  /**
   * Entschl�sselt eine Zeichenkette, welche mit der Methode encrypt
   * verschl�sselt wurde.
   *
   * @param str Description of the Parameter
   * @return String the encrypted string.
   * @exception SecurityException Description of the Exception
   */
  @SuppressWarnings("static-access")
public static String entschlusseln(String text1)
  {
	  String text = "";
	  VerschluesselnMitJava man = VerschluesselnMitJava.getInstance();
	    man.init(man.password.toCharArray(), man.salt, man.iterations);
	    text = man.decrypt(text1);  
	    return text;
  }
  }
  

