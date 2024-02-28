public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(1,player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Canınız tazelendi!");
        return true;
    }
}
