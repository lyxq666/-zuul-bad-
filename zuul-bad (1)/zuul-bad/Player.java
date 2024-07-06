    public class Player extends Command {
        private static int healthPoints=100;  // 生命值
        private static int magicPoints= 50;   // 魔法值
        private static int attackPower= 20;     // 攻击力
        private static int defense= 30;      // 防御力
        private static int intelligence=30;  // 智力
        private static int stamina=25;       // 耐力
        private static int luck=20;          // 幸运值


        public Player() {
            super(null, null);

//            System.out.println("------ 个人属性面板 ------");
//            System.out.println("生命值（HP）：" + healthPoints);
//            System.out.println("魔法值（MP）：" + magicPoints);
//            System.out.println("攻击力（AttackPower）：" + attackPower);
//            System.out.println("防御力（defense）：" + defense);
//            System.out.println("智力（Intelligence）：" + intelligence);
//            System.out.println("耐力（Stamina）：" + stamina);
//            System.out.println("幸运（Luck）：" + luck);
//            System.out.println("--------------------------");
        }

        public Player(String firstWord, String secondWord) {
            super(firstWord, secondWord);

            System.out.println("------ 个人属性面板 ------");
            System.out.println("生命值（HP）：" + healthPoints);
            System.out.println("魔法值（MP）：" + magicPoints);
            System.out.println("攻击力（AttackPower）：" + attackPower);
            System.out.println("防御力（defense）：" + defense);
            System.out.println("智力（Intelligence）：" + intelligence);
            System.out.println("耐力（Stamina）：" + stamina);
            System.out.println("幸运（Luck）：" + luck);
            System.out.println("--------------------------");
        }




        @Override
        public boolean execute(Game game) {

            return false;
        }
        // 获取生命值
        public int getHealthPoints() {
            return healthPoints;
        }
        // 设置生命值
        public void setHealthPoints(int healthPoints) {
            this.healthPoints = healthPoints;
        }

        public int getMagicPoints() {
            return magicPoints;
        }
        public void setMagicPoints(int magicPoints) {
            this.magicPoints = magicPoints;
        }

        public int getAttackPower() {
            return attackPower;
        }
        public void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
        }

        public int getDefense() {
            return defense;
        }
        public void setDefense(int defense) {
            this.defense = defense;
        }

        public int getIntelligence() {
            return intelligence;
        }
        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public int getStamina() {
            return stamina;
        }
        public void setStamina(int stamina) {
            this.stamina = stamina;
        }

        public int getLuck() {
            return luck;
        }
        public void setLuck(int luck) {
            this.luck = luck;
        }
//        public void updatePlayer(Item item)
//        {
//            if (item.getName().equals("破损的剑")) {
//                setAttackPower(getAttackPower() + 5); // 增加攻击力
//            } else if (item.getName().equals("幽灵盾牌")) {
//                setDefense(getDefense() + 10); // 增加防御力
//            } else if (item.getName().equals("干粮")) {
//                setStamina(getStamina() + 20); // 增加耐力
//            } else if (item.getName().equals("炼金药水")) {
//                setMagicPoints(getMagicPoints() + 30); // 增加魔法值
//            } else if (item.getName().equals("银制匕首")) {
//                setAttackPower(getAttackPower() + 8); // 增加攻击力
//            } else if (item.getName().equals("古籍")) {
//                setIntelligence(getIntelligence() + 15); // 增加智力
//            } else if (item.getName().equals("宝石")) {
//                setLuck(getLuck() + 5); // 增加幸运值
//            } else if (item.getName().equals("幽灵护符")) {
//                setLuck(getLuck() + 10); // 增加幸运值
//            }
//
//        }

    }
