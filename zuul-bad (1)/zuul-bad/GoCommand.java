/**
 * @author 罗智斌
 */


public class GoCommand extends Command{
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     */
    public GoCommand(String firstWord,String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public boolean execute(Game game) {
            if(!hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Go where?");
                return false;
            }

            String direction =  getSecondWord();

            // Try to leave current room.

            Room nextRoom = game.getCurrentRoom().getExit(direction);

            Room currentRoom = game.getCurrentRoom();

            if (nextRoom == null) {
                System.out.println("你来到迷宫的一处分岔路口，眼前出现了一扇巨大的石门。" +
                        "然而，当你靠近时，你发现门已经消失了！一股神秘的力量将门完全抹去，只留下一片空旷。" +
                        "这难道是迷宫中的魔法障碍？你决定继续探索，寻找出口并解开这些神秘的谜题。!");
            }
            else {
    //            roomStack.push(currentRoom);

                game.setCurrentRoom(nextRoom);


                if(game.getCurrentRoom().getDescription().equals("你突然感到一阵眩晕，然后你发现自己已经出现在了另一个房间。"))
                {
//                    game.printRoomInfo();
                    System.out.println("一股莫名的眩晕感骤然袭来，犹如时空的涟漪轻轻荡漾，瞬间便打破了空间的桎梏。");
                    System.out.println("你感到自己仿佛被一股无形的力量牵引，穿越了一个个未知的维度，最终，眼前的一切变得模糊又清晰。。");
                    System.out.println("你突然感到一阵眩晕，然后你发现自己已经出现在了另一个房间。");
                    System.out.println("你意识到，自己似乎经历了一次随机的传送，你来到了迷宫的另一处位置，");
                    //生成一个随机数
                    int random = (int) (Math.random() * 6 + 1);
                    //如果随机数为1，2，3，4，5，6，就执行下面的代码
                    switch (random) {
                        case 1:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("north"));
                            game.printRoomInfo();
                            break;
                        case 2:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("south"));
                            game.printRoomInfo();
                            break;
                        case 3:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("east"));
                            game.printRoomInfo();
                            break;
                        case 4:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("west"));
                            game.printRoomInfo();
                            break;
                        case 5:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("up"));
                            game.printRoomInfo();
                            break;
                        case 6:
                            game.setCurrentRoom(game.getCurrentRoom().getExit("down"));
                            game.printRoomInfo();
                            break;
                    }
                }
                else
                {
                    game.printRoomInfo();
                }




                System.out.println();
            }
            return false;
    }



}
