package MyProject;

import java.util.Scanner;

public class Seyahat {

    static double toplamBiletTutari;
    static double kmBirimFiyat = 0.25; // 20 km da 5 euro ise 1 km de 0,25
    static int frankfurtKm = 60;
    static int kolnKm = 80;
    static String islem;
    static String bilet;
    static double bakiye ;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        karsilama();
        sehirSecme();
        biletSecme();
        odemeYapma();


    }
    public static void karsilama() {
        System.out.println(BOLD+c_BLUE+" *** SEYAHAT SAYFAMIZA HOŞ GELDİNİZ *** ");
        System.out.println("Frankfurt : 60 KM");
        System.out.println("Köln : 80 KM");
        System.out.println("Her 20 KM başına 5 euro ücret tarifesi"+c_RESET);
    }
    public static void sehirSecme() {
        try {
            System.out.print("\nNereye yolculuk etmek istersiniz : ");
            String city = scan.nextLine().trim().toUpperCase();
            if ( city.equals("KÖLN")) {
                System.out.println("\nRota ---> Köln'e doğru gidiyor.");
                islem = "Köln";
                toplamBiletTutari = kolnKm * kmBirimFiyat;
                System.out.println("Köln bilet ücreti " + toplamBiletTutari + " euro'dur.");
            }
            else if (city.equals("FRANKFURT")) {
                System.out.println("\nRota ---> Frankfurt'a doğru gidiyor.");
                islem = "Frankfurt";
                toplamBiletTutari = (frankfurtKm * kmBirimFiyat);
                System.out.println("Frankfurt bilet ücreti " + toplamBiletTutari + " euro'dur.");
            }
            else {
                System.out.println("-- Hatalı veri girdiniz. --");
                sehirSecme();
            }
        }catch (Exception e) {
            System.out.println(BOLD+c_RED+" *** Hatalı giriş *** "+c_RESET);
            scan.nextLine();
            sehirSecme();
        }

    }
    public static void biletSecme() {
        try {

            System.out.println("\nKaç kişilik bilet istiyorsunuz (Max 2) ? ");
            int kisi = scan.nextInt();
            switch (kisi) {
                case 1 :
                    bilet = "bir";
                    break;
                case 2:
                    toplamBiletTutari = toplamBiletTutari * 2;
                    bilet = "iki";
                    break;
                default :
                    System.out.println("Kişi sayısını doğru girmediniz sanırım. ");
                    biletSecme();
                    break;
            }
            System.out.println(BOLD+c_PURPLE+"\n"+islem + " yönüne " + kisi + " kişilik bilet seçtiniz. ");
            System.out.println("Toplam bilet ücreti --> " + toplamBiletTutari +" euro'dur."+c_RESET);
        }catch (Exception e) {
            System.out.println(BOLD+c_RED+" *** Hatalı giriş *** "+c_RESET);
            scan.nextLine();
            biletSecme();
        }
    }
    public static void odemeYapma() {
        try {

            System.out.print("\nÖdeme yapacağınız miktarı girin : ");
            double para = scan.nextDouble();
            bakiye += para;

            while (bakiye < toplamBiletTutari) {
                System.out.println("\nYetersiz ödeme yaptınız. "+(toplamBiletTutari-bakiye)+ " euro daha ödemeniz gerekiyor.");
                System.out.print("Tekrar ödeme yapınız : ");
                para = scan.nextDouble();
                bakiye += para;
            }

            if ( toplamBiletTutari < bakiye ) {
                System.out.println(c_PURPLE+"\nÖdemeniz için teşekkür ederiz..");
                System.out.println((bakiye - toplamBiletTutari) +" euroyu para üstü olarak almayı unutmayınız."+c_RESET);
            }
            else if (bakiye == toplamBiletTutari) {
                System.out.println(c_PURPLE+"\nÖdemeniz için teşekkür ederiz.. Para üstü bulunmamaktadır."+c_RESET);
            }

        }catch (Exception e) {
            System.out.println(BOLD+c_RED+" *** Hatalı giriş *** "+c_RESET);
            scan.nextLine();
            odemeYapma();
        }
    }


    static String c_RESET  = "\u001B[0m";
    static String c_RED    = "\u001B[31m";
    static String BOLD     = "\033[0;1m";
    static String c_BLUE   = "\u001B[34m";
    static String c_PURPLE = "\u001B[35m";

}


