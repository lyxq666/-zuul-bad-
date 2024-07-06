/**
 * @author 罗智斌
 */


public class QuitCommand extends Command{
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */
    public QuitCommand(String firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public boolean execute(Game game) {
        if(hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
