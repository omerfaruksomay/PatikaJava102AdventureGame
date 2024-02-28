public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(2, player, "Ekipman Mağazası");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------------ Mağazaya hoşgeldiniz. ------------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.println("-----------------------------------------------");
            System.out.print("Yapmak istediğiniz işlem: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz değer, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Birdaha bekleriz.");
                    showMenu = false;
                    break;
            }
        }


        return true;
    }

    public void printWeapon() {
        Weapon[] weapons = Weapon.weapons();
        System.out.println("------------ Silahlar ------------");

        for (Weapon weapon : weapons) {
            System.out.println(weapon.getId() + "\t Silah adı: " + weapon.getName() + "\t Hasar: " + weapon.getDamage() + "\t Fiyat: " + weapon.getPrice());
        }
        System.out.println("0\t Çıkış yap.");
        System.out.println("----------------------------------");


    }

    public void buyWeapon() {
        Weapon[] weapons = Weapon.weapons();
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > weapons.length) {
            System.out.print("Geçersiz değer girdiniz, tekrar giriniz: ");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    //satın alma
                    System.out.println(selectedWeapon.getName() + " Silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.print("Satın alımdan sonra karakterinizin istatistikleri: ");
                    this.getPlayer().printInfo();

                }
            }

        }

    }

    public void printArmor() {
        Armor[] armors = Armor.armors();
        System.out.println("------------ Zırhlar ------------");

        for (Armor armor : armors) {
            System.out.println(armor.getId() + " Zırh adı: " + armor.getName() + "\t Engelleme: " + armor.getBlock() + "\t Fiyat: " + armor.getPrice());
        }
        System.out.println("0 Çıkış yap.");
        System.out.println("----------------------------------");
    }

    public void buyArmor() {
        Armor[] armors = Armor.armors();
        System.out.print("Bir zırh seçiniz: ");
        int selectedArmorId = input.nextInt();
        while (selectedArmorId < 0 || selectedArmorId > armors.length) {
            System.out.print("Geçersiz değer girdiniz, tekrar giriniz: ");
            selectedArmorId = input.nextInt();
        }

        if (selectedArmorId != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectedArmorId);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    //satın alma
                    System.out.println(selectedArmor.getName() + " Zırhı satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.print("Satın alımdan sonra karakterinizin istatistikleri: ");
                    this.getPlayer().printInfo();

                }
            }
        }

    }
}
