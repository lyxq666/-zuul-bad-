    public class UseCommand extends Command{
        /**
         * Create a command object. First and second word must be supplied, but
         * either one (or both) can be null.
         *
         * @param firstWord  The first word of the command. Null if the command
         *                   was not recognised.
         * @param secondWord The second word of the command.
         */

        public UseCommand(String firstWord, String secondWord) {
            super(firstWord, secondWord);
        }
//        public UseCommand(String firstWord, String secondWord, Player player) {
//            super(firstWord, secondWord);
//            this.player = player; // 初始化 player 变量
//        }
        @Override
        public boolean execute(Game game) {

            if (!hasSecondWord()) {
                System.out.println("Use what?");
                return false;
            }

            String item = getSecondWord();
            boolean itemFound = false;
            for (Item i : game.bag) {
                if (i.getName().equalsIgnoreCase(item)) {
                    itemFound = true;
                    switch (i.getName()) {
                        case "破损的剑":
                            int newAttackPower = game.getPlayer().getAttackPower() + 10;
                            game.getPlayer().setAttackPower(newAttackPower);
                            System.out.println("你装备了一把破损的剑，似乎是曾经勇者的遗物。在它的重量中蕴藏着岁月的沉淀，但你感受到了力量的增加。你的攻击力得到了提升。");
                            break;
                        case "幽灵盾牌":
                            int newDefense = game.getPlayer().getDefense() + 10;
                            game.getPlayer().setDefense(newDefense);
                            System.out.println("你装备了一块幽灵盾牌，它的表面散发着淡淡的幽光，仿佛能够抵挡一切邪恶的力量。你的防御力得到了提升。");
                            break;
                        case "干粮":
                            int newStamina = game.getPlayer().getStamina() + 20;
                            game.getPlayer().setStamina(newStamina);
                            System.out.println("你吃了一些干粮，虽然简单却充满了满足感。你感到体力恢复了一些。");
                            break;
                        case "炼金药水":
                            int newMagicPoints = game.getPlayer().getMagicPoints() + 30;
                            game.getPlayer().setMagicPoints(newMagicPoints);
                            System.out.println("你饮下了一瓶炼金药水，涌入你体内的力量使你感到焕发出了新的活力。你的魔法值增加了。");
                            break;
                        case "银制匕首":
                            int newAttackPowerDagger = game.getPlayer().getAttackPower() + 8;
                            game.getPlayer().setAttackPower(newAttackPowerDagger);
                            System.out.println("你悄然装备了一把银制匕首，它的锋利程度足以让任何敌人胆寒。你的攻击力得到了提升。");
                            break;
                        case "古籍":
                            int newIntelligence = game.getPlayer().getIntelligence() + 15;
                            game.getPlayer().setIntelligence(newIntelligence);
                            System.out.println("你仔细阅读了一本古籍，其中蕴含着古老智慧的结晶，使你的思维更加敏捷。你的智力得到了提升。");
                            break;
                        case "宝石":
                            int newLuckGem = game.getPlayer().getLuck() + 5;
                            game.getPlayer().setLuck(newLuckGem);
                            System.out.println("你发现了一颗闪烁着光芒的宝石，握在手中似乎能感受到幸运之力的注入。你的幸运值提升了。");
                            break;
                        case "幽灵护符":
                            int newLuckAmulet = game.getPlayer().getLuck() + 10;
                            game.getPlayer().setLuck(newLuckAmulet);
                            System.out.println("你获得了一枚幽灵护符，它散发着神秘的能量，似乎能够庇佑你免受邪恶的侵袭。你的幸运值得到了巨大的提升。");
                            break;
                        default:
                            // 可以添加默认情况的处理，比如提示未知物品或者什么也不做
                            break;
                    }
                    game.bag.remove(i); // 从玩家背包中移除使用过的物品
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("You don't have that item.");
            }
            return false; // 返回 true 表示命令执行成功
        }



    }
