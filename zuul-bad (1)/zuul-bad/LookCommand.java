public class LookCommand extends Command{
    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     *
     * @param firstWord  The first word of the command. Null if the command
     *                   was not recognised.
     * @param secondWord The second word of the command.
     */
    public LookCommand(String firstWord, String secondWord) {
        super(firstWord, secondWord);
    }

    @Override
    public boolean execute(Game game) {
        if(!hasSecondWord())
        {
            System.out.println(game.getCurrentRoom().getDescriptions());
            getRoomItem(game);
        }
        else
        {
            String item =getSecondWord();
            if(item.equals(game.getCurrentRoom().getItemName()))
            {
                System.out.println(game.getCurrentRoom().getItemDescription());
            }
            else
            {
                System.out.println("Look What ??");
            }
        }

        return false;
    }
    private void getRoomItem(Game game)
    {
        System.out.println(game.getCurrentRoom().getItem());
    }
}