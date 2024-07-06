/**
 * @author 罗智斌
 */

public class UnknownCommand extends Command{
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */
    public UnknownCommand(String firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public boolean execute(Game game) {
        System.out.println("I don't know what you mean...");
        return false;
    }
}
