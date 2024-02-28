import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa Hoşgeldiniz.");
        //  System.out.print("Lütfen bir isim giriniz: ");
        // String playerName = input.nextLine();
        Player player = new Player("Ömer");
        System.out.println("Savaşmaya hazır mısın " + player.getName() + " ?");
        System.out.println("Hazırsan başlıyoruz! ");
        System.out.println("Lütfen bir karakter seçin.");
        player.selectChar();

        Location loc = null;


        while (true) {
            Location[] locations = {
                    new SafeHouse(player),
                    new ToolStore(player),
                    new Cave(player),
                    new Forest(player),
                    new Lake(player)
            };


            System.out.println();
            System.out.println("################# Gidilebilecek Bölgeler #################");
            System.out.println();
            for (Location location : locations) {
                System.out.println(location.getId() + "\t Bölge adı: " + location.getName());
            }
            System.out.println("0\t Çıkış yap.");
            System.out.println();
            System.out.println("##########################################################");


            System.out.print("Lütfen gitmek itediğiniz bölgeyi seçiniz: ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    loc = null;
                    break;
                case 1:
                    loc = new SafeHouse(player);
                    break;
                case 2:
                    loc = new ToolStore(player);
                    break;
                case 3:
                    loc = new Cave(player);
                    break;
                case 4:
                    loc = new Forest(player);
                    break;
                case 5:
                    loc = new Lake(player);
                    break;
                default:
                    System.out.println("Lürfen doğru bir id giriniz.");
            }

            if (loc == null) {
                System.out.println("Demek pes ettin. Cesaretini topla ve tekrar dene!");
                break;
            }

            if (!loc.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }

        }


    }

}
