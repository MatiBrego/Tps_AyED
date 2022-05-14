public class PathBuilder {
    int current_jump = 0;

    public void nextJump() {
        current_jump++;
    }

    public int getCurrent_jump() {
        return current_jump;
    }

    public void recursive_peek(Position pos, int jumps, String combination) {
        pos.calculate_possibilities();
        if (jumps == 0) {
            System.out.println(combination + pos.getString());
            return;
        }
        while (!(pos.getPossibilities().isEmpty())) {
            recursive_peek(pos.getPossibilities().peek(), jumps - 1, combination + pos.getString() + "-");
            pos.getPossibilities().pop();
        }
    }

    public String[][] build_stacks(Position position, int jumps) {
        Position pos = position;
        String[][] stacks = new String[jumps][];
        for (int i = 0; i < jumps; i++) {
            pos.calculate_possibilities();
            String []current_stack = new String[pos.getPossibilities().size()];
            int counter = 0;
            while (!(pos.getPossibilities().isEmpty())) {
                current_stack[counter] = pos.getPossibilities().peek().getString();
                pos.getPossibilities().pop();
                counter++;
            }
            stacks[i] = current_stack;
            pos.calculate_possibilities();
            pos = pos.getPossibilities().peek();

        }
        return stacks;
    }
    public void print_stacks() {
        String[][] stacks = build_stacks(new Position(1, 1), current_jump);
        for (int i = 0; i < stacks.length; i++) {
            String positions = "[";
            for(int j = 0; j < stacks[i].length; j++){
                positions = positions + stacks[i][j] + ";";
            }
            System.out.println("Stack " + (i + 1) + ": " + positions + "]");
        }

    }
}

