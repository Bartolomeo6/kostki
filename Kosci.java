import java.util.Random;

public class Kosci {
    public int[] kostki = {};

    public Kosci() {

    }

    private int[] sortowaniePrzezWybor(int[] tab){
        int n = 5;
        for(int i = 0; i<n; i++){
            int najmIndeks = i;
            for(int j = i+1; j<n; j++){
                if(tab[j] < tab[najmIndeks]){
                    najmIndeks = j;
                }
            }
            if(najmIndeks != i){
                int temp = tab[najmIndeks];
                tab[najmIndeks] = tab[i];
                tab[i] = temp;
            }
        }
        return tab;
    }

    private boolean czyUnikalne(int[] tab){
        int[] sortTab = sortowaniePrzezWybor(tab);
        int licznik = 0;
        int l = 0;
        for(int i = 0; i<5; i++) {
            if(sortTab[0] != sortTab[1]){
                licznik++;
            }
        }
        if(licznik == 5){
            return true;
        }
        return false;
    }

    public void losujKosci(){
        int[] losowe = new int[5];
        Random random = new Random();
        for(int i = 0; i<5; i++){
            losowe[i] = random.nextInt(1,7);
        }
        this.kostki = losowe;
        wyswietlKosci();
    }
    public void wyswietlKosci(){
        for(int i = 0; i<5; i++){
            System.out.println("Kostki "+(i+1)+": "+this.kostki[i]);
        }
    }

    public int obliczPunkty(){
        int[] licznikPowtorzen = new int[7];
        for(int i = 0; i<5; i++){
            licznikPowtorzen[kostki[i]]++;
        }

        int[] posortowaneKostki = sortowaniePrzezWybor(kostki);

        int suma = 0;
        int x = 0;
        int y = 1;
        for(int i = 0; i<7; i++){
            if(licznikPowtorzen[i] >= 2){
                suma += i*licznikPowtorzen[i];
            }
            else if(czyUnikalne(kostki) && (posortowaneKostki[0] == 1 && posortowaneKostki[1] == 2 && posortowaneKostki[2] == 3 && posortowaneKostki[3] == 4 && posortowaneKostki[4] == 5)){
                suma += 15;
                break;
            }
            else if(czyUnikalne(kostki) && (posortowaneKostki[0] == 2 && posortowaneKostki[1] == 3 && posortowaneKostki[2] == 4 && posortowaneKostki[3] == 5 && posortowaneKostki[4] == 6)){
                suma += 20;
                break;
            }
        }


        return suma;
    }

    public void rozpocznijGre(){
        losujKosci();
        System.out.println(obliczPunkty());
    }
}
