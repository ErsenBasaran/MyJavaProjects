import java.util.Arrays;

public class OyunDurumu {

    private char[] tahminler;
    private int kalanHak;
    private int dogruTahminSayisi;

    public OyunDurumu(int kelimeUzunlugu){
        tahminler = new char[kelimeUzunlugu];// char tipinde bir dizi olarak tanımlandı ve uzunluğu
                                            // tahmin edilecek kelimenin uzunluğuna ayarlandı
        for (int i=0; i<kelimeUzunlugu; i++){
            tahminler[i] = '_';
        }
        kalanHak=6;
        dogruTahminSayisi=0;
    }

    public boolean harfTahminEt(char harf,String kelime){
        boolean dogruTahmin= false;
        for (int i=0; i<kelime.length(); i++){
           if (kelime.charAt(i)==harf){
               tahminler[i]=harf;
               dogruTahmin=true;
               dogruTahminSayisi++;
           }
        }
        if (!dogruTahmin){  //  if'in içerisi true ise çalışır, false ile çalışmazdı
            kalanHak--;
        }
        return dogruTahmin;
    }

    public boolean oyunBittiMi(){
        return kalanHak<=0 || dogruTahminSayisi==tahminler.length;
    }

    public boolean kazandinizMi(){
        return dogruTahminSayisi==tahminler.length;
    }

    public void durumGoster(){
        for (char harf:tahminler){
           System.out.print(harf + " ");
        }
        System.out.println("Kalan hak : " + kalanHak);
        //System.out.println(Arrays.toString(tahminler)); // yukarıdaki ile aynı sonucu verirdi


    }



}
