/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
//用于存储游戏已知的所有命令单词
public class CommandWords
{
    // a constant array that holds all valid command words
    //私有静态数组 validCommands
    private static final String[] validCommands = {
        "go", "quit", "help","look","take","bag","use","player"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */



//    isCommand 方法用于检查给定的字符串是否是一个有效的命令单词。
//    它遍历 validCommands 数组，如果找到匹配的字符串，则返回 true；否则返回 false。
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
