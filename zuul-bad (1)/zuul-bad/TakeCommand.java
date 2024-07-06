public class TakeCommand extends Command{
    Item item = new Item();
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */
    public TakeCommand(String firstWord, String secondWord) {
        super(firstWord, secondWord);
    }


    @Override
    public boolean execute(Game game) {
        String item = game.getCurrentRoom().getItemName();


        // 如果命令没有提供第二个单词，或者提供的物品名称与当前房间中的物品名称不匹配
        if(!hasSecondWord() || !getSecondWord().equals(item)) {
            System.out.println("Take what??");
            return false;
        }
        // 如果房间中没有物品存在
        if(!game.getCurrentRoom().isItemPresent())
        {
            System.out.println("No item present in the room");
            return false;
        }





        // 如果成功拿取物品
        else if(game.getCurrentRoom().takeItem())
        {
            System.out.println("成功捡起物品");
            game.bag.add(game.getCurrentRoom().getItemInTheRoom());
//            switch (game.getCurrentRoom().getItemName()) {
//                case "破损的剑":
//                    int swordWeight = 5;
//                    int currentWeightSword = game.getPlayerbag().getCurrentWeight() + swordWeight;
//                    int remainingCapacity = game.getPlayerbag().getWeightLimit() - currentWeightSword;
//                    game.getPlayerbag().setCurrentWeight(currentWeightSword);
//                    System.out.println("\033[0;34m当前背包重量：" + currentWeightSword + "\033[0m ; \033[0;31m背包剩余承受重量：" + remainingCapacity + "\033[0m");
//                    break;
//                case "幽灵盾牌":
//                    int shieldWeight = 10;
//                    int currentWeightShield = game.getPlayerbag().getCurrentWeight() + shieldWeight;
//                    int remainingCapacity2 = game.getPlayerbag().getWeightLimit() - currentWeightShield;
//                    game.getPlayerbag().setCurrentWeight(currentWeightShield);
//                    System.out.println("\033[0;34m当前背包重量：" + currentWeightShield + "\033[0m ; \033[0;31m背包剩余承受重量：" + remainingCapacity2 + "\033[0m");
//                    break;
//                case "干粮":
//                    int foodWeight = 3;
//                    int currentWeightFood = game.getPlayerbag().getCurrentWeight() + foodWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightFood);
//                    break;
//                case "炼金药水":
//                    int potionWeight = 1;
//                    int currentWeightPotion = game.getPlayerbag().getCurrentWeight() + potionWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightPotion);
//                    break;
//                case "银制匕首":
//                    int daggerWeight = 8;
//                    int currentWeightDagger = game.getPlayerbag().getCurrentWeight() + daggerWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightDagger);
//                    break;
//                case "古籍":
//                    int bookWeight = 2;
//                    int currentWeightBook = game.getPlayerbag().getCurrentWeight() + bookWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightBook);
//                    break;
//                case "宝石":
//                    int gemWeight = 1;
//                    int currentWeightGem = game.getPlayerbag().getCurrentWeight() + gemWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightGem);
//                    break;
//                case "幽灵护符":
//                    int amuletWeight = 1;
//                    int currentWeightAmulet = game.getPlayerbag().getCurrentWeight() + amuletWeight;
//                    game.getPlayerbag().setCurrentWeight(currentWeightAmulet);
//                    break;
//                default:
//                    // 如果当前房间中没有物品，不需要做任何操作
//                    break;
//            }
            switch (game.getCurrentRoom().getItemName()) {
                case "破损的剑":
                    int swordWeight = 5;
                    int currentWeightSword = game.getPlayerbag().getCurrentWeight() + swordWeight;
                    int remainingCapacity = game.getPlayerbag().getWeightLimit() - currentWeightSword;
                    game.getPlayerbag().setCurrentWeight(currentWeightSword);
                    System.out.println("当前背包重量：" + currentWeightSword + " ; 背包剩余承受重量：" + remainingCapacity );
                    break;
                case "幽灵盾牌":
                    int shieldWeight = 10;
                    int currentWeightShield = game.getPlayerbag().getCurrentWeight() + shieldWeight;
                    int remainingCapacity2 = game.getPlayerbag().getWeightLimit() - currentWeightShield;
                    game.getPlayerbag().setCurrentWeight(currentWeightShield);
                    System.out.println("当前背包重量：" + currentWeightShield + "；背包剩余承受重量：" + remainingCapacity2);
                    break;
                case "干粮":
                    int foodWeight = 3;
                    int currentWeightFood = game.getPlayerbag().getCurrentWeight() + foodWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightFood);
                    System.out.println("当前背包重量：" + currentWeightFood + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightFood));
                    break;
                case "炼金药水":
                    int potionWeight = 1;
                    int currentWeightPotion = game.getPlayerbag().getCurrentWeight() + potionWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightPotion);
                    System.out.println("当前背包重量：" + currentWeightPotion + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightPotion));
                    break;
                case "银制匕首":
                    int daggerWeight = 8;
                    int currentWeightDagger = game.getPlayerbag().getCurrentWeight() + daggerWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightDagger);
                    System.out.println("当前背包重量：" + currentWeightDagger + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightDagger) );
                    break;
                case "古籍":
                    int bookWeight = 2;
                    int currentWeightBook = game.getPlayerbag().getCurrentWeight() + bookWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightBook);
                    System.out.println("当前背包重量：" + currentWeightBook + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightBook) );
                    break;
                case "宝石":
                    int gemWeight = 1;
                    int currentWeightGem = game.getPlayerbag().getCurrentWeight() + gemWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightGem);
                    System.out.println("当前背包重量：" + currentWeightGem + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightGem) );
                    break;
                case "幽灵护符":
                    int amuletWeight = 1;
                    int currentWeightAmulet = game.getPlayerbag().getCurrentWeight() + amuletWeight;
                    game.getPlayerbag().setCurrentWeight(currentWeightAmulet);
                    System.out.println("当前背包重量：" + currentWeightAmulet + "；背包剩余承受重量：" + (game.getPlayerbag().getWeightLimit() - currentWeightAmulet) );
                    break;
                default:
                    // 如果当前房间中没有物品，不需要做任何操作
                    break;
            }


            game.getCurrentRoom().setItem(null);
        }
        else
        {
            System.out.println("Item not picked");
        }




        return false;
    }
}
