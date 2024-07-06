public class Bag extends Command{


    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */

    private static int weightLimit = 30; // 背包重量限制

    private static int currentWeight; // 当前背包总重量

    public Bag()
    {
        super(null,null);
    }

    public Bag(String firstWord, String secondWord) {
        super(firstWord, secondWord);

    }
    public Bag(String firstWord, String secondWord, int weightLimit) {
        super(firstWord, secondWord);

    }

    @Override
    public boolean execute(Game game) {

        if (game.bag.isEmpty()) {
            System.out.println("你的背包是空的。");
            return false;
        }
        System.out.println("物品 \t\t 备注");
        for(Item i : game.bag)
        {
            System.out.println(i.getName()+" \t\t "+i.getDescription());
        }
        System.out.println("当前背包重量：" + currentWeight + "/" + weightLimit);

        return false;
    }
    public int getCurrentWeight() {

        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }
}
