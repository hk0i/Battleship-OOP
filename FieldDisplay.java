public class FieldDisplay {
    public static void render(BattleField field) {
        int size = field.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(
                    String.format("%c ",
                        tileToChar(field.tileAt(i, j))));
            }

            System.out.println();
        }
    }

    public static char tileToChar(BattleField.Tile tile) {
        char retChar = '?';

        switch (tile) {
            case Ocean:
                retChar = '~';
                break;

            case Miss:
                retChar = 'O';
                break;

            case Hit:
                retChar = 'X';
                break;
        }

        return retChar;
    }
}
