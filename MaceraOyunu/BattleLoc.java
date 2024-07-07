package MaceraOyunu;

public abstract class BattleLoc extends Location {
    // abstract yaptı çünkü bu classta nesne üretmeyecekmiş
    // gerekli nesneleri forest, river ve cave alt sınıflarında oluşturacak
protected Obstacle obstacle;
//buna getter setter yazmıyoruz çünkü dışarıdaki bir sınıftan buraya erişmeyeceğiz
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle; // bunu yazmazsak obstacle içeren konum seçtiğimizde hata verip çalışmayı durduruyor
        this.award = award;
    }
    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("Şu an  " + this.getName()+ "'dasınız");
        System.out.println("Dikkatli ol! Burada "+ obsCount + " tane "+ obstacle.getName() + " yaşıyor");
        System.out.print("<S>avaş veya <K>aç : ");
        String selCase = scan.nextLine();
        selCase=selCase.toUpperCase();
        if (selCase.equals("S")) {
            if(combat(obsCount)){
                System.out.println(this.getName()+ " bölgesindeki tüm düşmanları yendiniz ! ");
                if (this.award.equals("Food") && player.getInv().isFood() == false){
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setFood(true);
                }else if (this.award.equals("Water") && player.getInv().isWater() == false){
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setWater(true);
                }else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false){
                    System.out.println(this.award + " kazandınız !");
                    player.getInv().setFirewood(true);
                }
                return true;
            }

            if (player.getHealthy()<=0){
                System.out.println("Öldünüz !!!");
                return false;
            }

        }
        return true;
    }
    public boolean combat(int obsCount){
        for(int i=0; i<obsCount; i++){
            int defObsHealth = obstacle.getHealth(); // dövüşten sonra obstacle ölmüş olursa bu değerle tekrar canlandıracağız sonraki gelişler için
            playerStats();  // ilk yazdığımızda hata veriyor. sonra metodu aşağıda yaratıyoruz.
            enemyStats();
            while(player.getTotalDamage()>0 && obstacle.getHealth()>0){
                System.out.print("<V>ur veya <K>aç : ");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")){
                    System.out.println("Siz vurdunuz! ");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth()>0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else{
                    return false; // burada break vardı. o zaman Vur Kaç'ta kaçınca da yenip ödül alıyorduk. hatayı böyle düzelttik
                }
            }
            if (obstacle.getHealth() < player.getHealthy()){
                System.out.println("Düşmanı yendiniz!");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Güncel paranız : " + player.getMoney());
                obstacle.setHealth(defObsHealth); // dövüşten sonra obstacle tekrar canlansın ki sonra da çıkabilsin

            }else {
                return false; // ölmüşsek false döndürecek
            }
            System.out.println("---------------");
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri\n---------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInv().getDamage()>0){
            System.out.println("Silah: " + player.getInv().getwName());
        }
        if (player.getInv().getArmor()>0) {
            System.out.println("Zırh: " + player.getInv().getaName());
        }

    }
    public void enemyStats(){
        System.out.println("\n"+obstacle.getName() +" Değerleri\n---------");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Para: " + obstacle.getAward());

    }
    public void afterHit(){
        System.out.println("Oyuncu canı : " + player.getHealthy());
        System.out.println(obstacle.getName()+ " canı " + obstacle.getHealth());
        System.out.println();
    }

}
