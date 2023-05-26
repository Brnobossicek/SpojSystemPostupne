import org.w3c.dom.html.HTMLLabelElement;

import java.util.Scanner;

public class SrovnatPoleSpojSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vstup = sc.nextInt();
        Prvek hlava = new Prvek(vstup, null);

        for (;;) {
            vstup = sc.nextInt();
            if (vstup == 0)
                break;
            Prvek p = new Prvek(vstup, null);
            Prvek postup;
            Prvek pomalejsi;
            if (vstup >= hlava.hodnota) {
                pomalejsi = hlava;
                postup = hlava.dalsiPrvek;
                while (vstup >= postup.hodnota) {
                    pomalejsi = postup;
                    postup = postup.dalsiPrvek;
                }
                pomalejsi.dalsiPrvek = p;
                p.dalsiPrvek = postup;
            } else {
                int x = hlava.hodnota;
                hlava.hodnota = vstup;
                hlava.dalsiPrvek = p;
                hlava.dalsiPrvek.hodnota = x;
            }

        }
        Prvek pocitam = hlava;
        while (pocitam.dalsiPrvek != null) {
            System.out.println(pocitam.hodnota);
            pocitam = pocitam.dalsiPrvek;
        }
        System.out.println(pocitam.hodnota);
    }
}
