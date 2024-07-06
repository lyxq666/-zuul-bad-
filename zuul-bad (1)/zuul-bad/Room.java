import java.util.*;
import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author 罗智斌
 * @version 2011.07.31
 */
public class Room 
{

    private String description;
    private Item item;
    private HashMap<String ,Room>exits;
    private boolean isItem;

    //键（Key）：代表方向的字符串，"north"、"south"、"east"、"west"
    //值（Value）：对于每个方向，对应的值是相邻的房间，即 Room 类型的对象。

//    public Room northExit;
//    public Room southExit;
//    public Room eastExit;
//    public Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */


    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String ,Room>();

    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */

    //定义房间出口
    public void setExits(Room north, Room east, Room south, Room west,Room up ,Room down)
    {
        if(north!=null){
            exits.put("north",north);
        }
        if(east!=null){
            exits.put("east",east);
        }
        if(south!=null){
            exits.put("south",south);
        }
        if(west!=null){
            exits.put("west",west);
        }
        if(up!=null){
            exits.put("up",up);
        }
        if(down!=null){
            exits.put("down",down);
        }
    }

    //set only 1 exit for 当前room
    public void setExits(String direction,Room neighborRoom)
    {
        exits.put(direction,neighborRoom);
    }

    //用于设置房间的出口。这个方法应该接受多个参数，每个参数代表一个方向的出口，以及相邻的房间。然后将这些出口信息存储到 exits 哈希表中。
    /**
     * @return The description of the room.
     */
    //如果当前方向有房间则返回，如果没有则返回Null；
    public Room getExit(String description)
    {
        return exits.get(description);
    }


    //返回当前房间所有可能的出口的字符串表示形式。
    public String getExitString()
    {
        String outS = "Exits:";
        Set<String>keys = exits.keySet();
        for(String exit:keys){
            outS+=" "+exit;
        }
        return outS;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDescriptions(){



        if (description=="你来到迷宫的核心地带，在这里存放着古老的秘密，周围弥漫着神秘的能量波动")
        {
                System.out.println("啊！你找到了它！那颗璀璨的宝石在你的手中闪耀着奇异的光芒，仿佛蕴含着无尽的能量与智慧。");
                System.out.println("你的心中充满了胜利的喜悦，这是对勇气与坚持的最好回报。");
                System.out.println("现在，你可以安心地离开这个神秘而充满挑战的地方，带着你的宝石，去追寻下一个冒险的旅程。");
                System.out.println("当你抬头望去，你看到了一道闪烁着光芒的魔法阵，将你传送出了迷宫。");
                System.out.println();
                System.out.println("恭喜你成功逃离了迷宫，找到了传说中的宝物！你是第一个成功逃离迷宫的冒险者！");
                System.out.println("你的勇气和智慧让你成功完成了这次冒险，你是中土大陆的英雄！");
                System.out.println("感谢你的游玩，期待你下次再次挑战“辛迪林迷宫”！");
                System.exit(0);
        }
        return   description + "\n" + getExitString();
    }





    //CCCCC
    //设置当前位置的物品为传入的 Item 对象。
    //如果传入的 item 不为空，则将 isItem 标记为 true，表示当前位置有物品，
    //否则标记为 false。
    public void setItem(Item item)
    {
        this.item = item;
        if(this.item!=null)isItem=true;
        else isItem=false;
    }

    //返回当前位置物品的名称。
    public String getItemName()
    {
        if(item == null)
        {
            System.out.println("不存在物品");
            return null;
        }

            return item.getName();

    }

    //return item detials in this room
    public String getItem()
    {
        if(item==null)return "";
        System.out.println("物品\t\t\t描述\t\t\t\t\t\t\t\t\t\t重量");
        return item.getName()+"\t"+item.getDescription()+"\t"+item.getKg();
    }

    //返回当前位置的物品对象。
    public Item getItemInTheRoom()
    {
        if(item==null)return null;
        return this.item;
    }

    //check玩家是否捡起物品
    /**
     *：用于玩家捡起当前位置的物品。如果当前位置有物品，将 isItem 标记为 false，
     * 表示物品已被取走，然后返回 true；
     * 如果当前位置没有物品，则返回 false。
     */
    public boolean takeItem()
    {
        if(isItem)isItem=false;
        else return false;

        return true;
    }

    //返回当前位置物品的描述。
    public String getItemDescription()
    {
        return item.getDescription();
    }

    //check 当前位置是否有物品。如果有物品，返回 true；否则返回 false。
    public boolean isItemPresent()
    {
        if(isItem)return true;
        return false;
    }


}
