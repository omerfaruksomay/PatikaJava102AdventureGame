import java.util.Random;

public abstract class Battlefields extends Location {

    private Obstacle obstacle;
    public String award;

    public int maxObstacle;


    public Battlefields(int id, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(id, player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Girilen bölge: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + getNumberOfObstacle() + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.println("Savaşmak için 's' ye kaçmak için 'k' ye basınız.");
        String  selectBattleCase = input.nextLine();
        selectBattleCase = selectBattleCase.toUpperCase();

        if (selectBattleCase.equals("S")){
            System.out.println("Savaş başlasın...");
        }else {
            System.out.println("Bu alandan kaçtın.");
        }



        return true;
    }

    public int getNumberOfObstacle() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
