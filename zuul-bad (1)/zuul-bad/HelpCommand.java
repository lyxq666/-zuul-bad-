public class HelpCommand extends Command
{
     /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */
    public HelpCommand(String firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public boolean execute(Game game) {
        System.out.println("欢迎来到辛迪林迷宫！作为一名勇敢的冒险者，你要寻找宝藏。");
        System.out.println("运用智慧和勇气来穿越迷宫，解谜，避开陷阱。");
        System.out.println("小心迷宫中的魔法障碍和危险生物。");
        System.out.println("你可以使用的指令有:go,quit,help,look,take,bag,use,player");
        return false;
    }
}
