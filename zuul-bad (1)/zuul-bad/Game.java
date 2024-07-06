/**
 *  This class is the main class of the "World of Zuul" application.
 *  "World of Zuul" is a very simple, text based adventure game.  Users
 *  can walk around some scenery. That's all. It should really be extended
 *  to make it more interesting!
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author 罗智斌
 * @version 2011.07.31
 */

/**
 * 已实现游戏功能：
 * 1. 迷宫式探险功能：
 *    - 玩家可以在迷宫中探索，并通过找到终点来完成游戏。
 *    - 当玩家成功走到终点时，显示“祝贺游戏通过”等信息。
 * 2. 拾取（物品）系统：
 *    - 玩家可以捡起房间中的物品。
 *    - 所有物品都有重量，并且玩家背包所能携带的重量有限。
 *    - 在捡起物品时会显示物品重量和当前背包重量。
 * 3. 属性变化系统：
 *    - 玩家可以吃食物和喝药水来改变个人属性，如生命值、魔法值等。
 *    - 游戏中会输出相应的文字提示，反映属性的变化。
 * 4. 背包系统：
 *    - 玩家可以查看背包中的物品及其描述。
 *    - 高亮显示背包当前重量和背包重量限制。
 *
 *
 * 5. 游戏指令：
 *    - player：查看当前玩家个人属性。
 *    - look：观察当前环境，发现房间中的物品，并输出房间环境描述和出口方向。
 *    - take：捡起房间中的物品。
 *    - bag：查看背包中的物品，高亮显示当前背包重量和限制。
 *    - use：使用背包中的游戏道具、物品，以提升玩家个人属性。
 * ······
 *   面向对象编程思想，将游戏各个功能模块化。
 */

import java.util.*;

/**
 * 《迷失的中土大陆》
 *
 * 在中土大陆的深处，隐藏着一个神秘的迷宫，据说是古老精灵们为了保护一件强大的魔法宝物而建造的。
 * 这个迷宫被称为“辛迪林迷宫”，它充满了危险和未知的挑战，许多冒险者曾试图闯入迷宫寻找传说中的宝物，
 * 但没有一个人能够成功逃脱。作为一名勇敢的冒险者，你听闻了这个传说，决定挑战“辛迪林迷宫”。
 * 你将扮演一名勇敢的中土大陆居民，在旅途中你可能会遇到来自指环王世界的各种生物和魔法。
 * 你需要利用你的智慧和勇气，在迷宫的曲径中寻找线索、解开谜题，最终找到出口并成功逃离迷宫。
 * 然而，逃离迷宫并不容易，你将面临诸多挑战和危险。迷宫内部布满了机关陷阱和怪物，同时还有诸多魔法障碍等待着你。
 * 只有那些具备坚定意志和足够智慧的冒险者才能成功逃脱这个充满未知和危险的迷宫。
 * 你准备好开始你的冒险了吗？在“辛迪林迷宫”中展现你的勇气和智慧，逃离迷宫，寻找传说中的宝物吧！
 * @author LZB
 * @version 2024.5.29
 */
public class Game
{

    private String description;

    private Player player;
    private Parser parser;
    private Room currentRoom;// 当前房间
    ArrayList<Item> bag;// 玩家的背包，存储收集的物品
    private Bag Playerbag;
    private int Limitkg = 30;
//    private Stack<Room> roomStack;
    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
        bag = new ArrayList<>();
        player = new Player();
        Playerbag = new Bag();
//        roomStack = new Stack<Room>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        //加入一个瞬时传送房间，玩家只要一至这个房间就会被随机地传送到另一个房间（终点除外）。
        //这个房间的描述可以是“你突然感到一阵眩晕，然后你发现自己已经出现在了另一个房间。”
        //这个房间的出口可以是随机的，但是不能是终点房间。
        Room randomRoom = new Room("你突然感到一阵眩晕，然后你发现自己已经出现在了另一个房间。");
        //入口处
        Room entrance = new Room("你站在一片古代废墟的入口处，古老的石柱支撑着苍穹，风吹过时传来古老的呢喃");
        //大厅
        Room chamber = new Room("你置身于一个黑暗而广袤的大厅内，墙壁上布满了历史的印记，空气中弥漫着沉重的寂静");
        //废弃的大厅
        Room hall = new Room("你来到一间废弃的大厅内，每一步都回荡着昔日的繁华，墙角堆积着岁月的尘埃");
        //炼金实验室
        Room laboratory = new Room("你踏入一个神秘的炼金实验室，烧瓶中冒着微弱的烟雾，架子上摆放着古老的炼金工具");
        //核心地带
        Room heart = new Room("你来到迷宫的核心地带，在这里存放着古老的秘密，周围弥漫着神秘的能量波动");
        //训练场
        Room trainingGround = new Room("你置身于被幽灵战士所困扰的被遗忘的训练场中，战鼓声还在回荡，似乎还能听到当年的激烈战斗");
        //幽灵能量的交汇处
        Room crossroads = new Room("你发现自己置身在幽灵能量的交汇处，失落的灵魂在这里聚集，空气中弥漫着一种悲凉的氛围");

        //图书馆
        Room library = new Room("你来到古老的图书馆，书架上摆放着陈旧的书籍和羊皮卷轴，书香扑鼻，似乎可以感受到知识的沉淀");
        //地下墓穴
        Room crypt = new Room("你置身于一座古老的地下墓穴，棺材和石棺散落在四周，阴冷的气息让人不禁打了个寒颤");

// 初始化新房间出口
        entrance.setExits(hall, null, null, null, null, null);
        chamber.setExits(null, trainingGround, hall, library, null, crypt);
        hall.setExits(chamber, trainingGround, entrance, library, null, null);
        laboratory.setExits(randomRoom, chamber, library, null, null, null);//在炼金实验室的北方设置一个瞬时传送房间
        heart.setExits(null, null, null, null, crypt, null);
        crossroads.setExits(crypt, null, null, null, trainingGround, null);
        trainingGround.setExits(null, null, hall, chamber, null, crossroads);
        library.setExits(laboratory, chamber, hall, null, null, null);
        crypt.setExits(null, null, crossroads, null, chamber, heart);
        randomRoom.setExits(chamber, trainingGround, library, hall, crypt, crossroads);

        setCurrentRoom(entrance);  // start game outside

        hall.setItem(new Item("破损的剑", "这把剑看起来历经沧桑，刀锋已经生锈，但仍然能够用于近战。", 5));
        trainingGround.setItem(new Item("幽灵盾牌", "这面盾牌散发着幽灵般的光芒，据说能够抵挡幽灵战士的攻击。", 10));
        chamber.setItem(new Item("干粮", "一些经过时间考验的硬干面包和晒干的肉干，虽然看起来不太美味，但却可以填饱肚子。", 3));
        laboratory.setItem(new Item("炼金药水", "一瓶古老的炼金药水，可能具有不可预测的效果。", 1));
//        crypt.setItem(new Item("银制匕首", "这把匕首刻满古老的符文，能够对抗不死生物。", 8));
        library.setItem(new Item("古籍", "一本记载着古老知识的羊皮卷轴，或许包含着解谜的线索。", 2));
        crypt.setItem(new Item("宝石", "一块闪耀着神秘能量的宝石，传说中能够启动古代机关。", 1));
        crossroads.setItem(new Item("幽灵护符", "这个护符能够在一定程度上保护你免受幽灵能量的影响。", 1));

//        hall.setItem(new Item("破损的剑", "这把剑看起来历经沧桑，刀锋已经生锈，但仍然能够用于近战。"));
//        trainingGround.setItem(new Item("幽灵盾牌", "这面盾牌散发着幽灵般的光芒，据说能够抵挡幽灵战士的攻击。"));
//        chamber.setItem(new Item("干粮", "一些经过时间考验的硬干面包和晒干的肉干，虽然看起来不太美味，但却可以填饱肚子。"));
//        laboratory.setItem(new Item("炼金药水", "一瓶古老的炼金药水，可能具有不可预测的效果。"));
//        crypt.setItem(new Item("银制匕首", "这把匕首刻满古老的符文，能够对抗不死生物。"));
//        library.setItem(new Item("古籍", "一本记载着古老知识的羊皮卷轴，或许包含着解谜的线索。"));
//        heart.setItem(new Item("宝石", "一块闪耀着神秘能量的宝石，传说中能够启动古代机关。"));
//        crossroads.setItem(new Item("幽灵护符", "这个护符能够在一定程度上保护你免受幽灵能量的影响。"));
        /**
         * 破损的剑"：攻击力 +5
         * "幽灵盾牌"：防御力 +10
         * "干粮"：耐力 +20
         * "炼金药水"：魔法值 +30
         * "银制匕首"：攻击力 +8
         * "古籍"：智力 +15
         * "宝石"：幸运值 +5
         * "幽灵护符"：幸运值+10
         */

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = command.execute(this);




        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Lost Middle-earth!");
        System.out.println("Lost Middle-earth is a new, incredibly challenging adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("欢迎来到失落的中土大陆！");
        System.out.println("《迷失的中土大陆》是一款全新、极具挑战的冒险游戏。");
        System.out.println("在中土大陆的深处，隐藏着一个神秘的迷宫，据说是古老精灵们为了保护一件强大的魔法宝物而建造的。");
        System.out.println("这个迷宫被称为“辛迪林迷宫”，充满了危险和未知的挑战。许多冒险者曾试图闯入迷宫寻找传说中的宝物，但没有一个人能够成功逃脱。");
        System.out.println("作为一名勇敢的冒险者，你听闻了这个传说，决定挑战“辛迪林迷宫”。");
        System.out.println("你将扮演一名勇敢的中土大陆居民，在旅途中可能会遇到来自指环王世界的各种生物和魔法。");
        System.out.println("你需要利用你的智慧和勇气，在迷宫的曲径中寻找线索、解开谜题，最终找到出口并成功逃离迷宫。");
        System.out.println("然而，逃离迷宫并不容易，你将面临诸多挑战和危险。迷宫内部布满了机关陷阱和怪物，同时还有诸多魔法障碍等待着你。");
        System.out.println("只有那些具备坚定意志和足够智慧的冒险者才能成功逃脱这个充满未知和危险的迷宫。");
        System.out.println("你准备好开始你的冒险了吗？在“辛迪林迷宫”中展现你的勇气和智慧，逃离迷宫，寻找传说中的宝物吧！");
        System.out.println("如果需要帮助，请输入'help'。");
        printRoomInfo();
        System.out.println();
    }

    //此部分应该交给Room
    public void printRoomInfo() {
        System.out.println();


        System.out.println(getCurrentRoom().getDescriptions());

        //getDescriptions()在Room中；
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }









    public Player getPlayer() {
        return player;
    }

    public static void main(String[] args) {

        new Game().play();
    }


    public Bag getPlayerbag() {
        return Playerbag;
    }





}

