public class FieldDisplay {
    public static void render(BattleField field) {
        int size = field.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(
                        String.format("%c ",
                        field.tileAt(i, j)));
            }

            System.out.println();
        }
    }
}
