public class Position {
    //Representa una posición con coordenadas x, y. Puede calcular sus posibles siguientes saltos
    private Stack<Position> possibilities;
    private int coord_x;
    private int coord_y;

    public Position(int coord_x, int coord_y) {
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        possibilities = new Stack<>();
    }

    public void calculate_possibilities(){
        //Crea un array con todas las posibilidades para el caballo
        int[][] pre_possibilities = {
                {coord_x -2, coord_y + 1},
                {coord_x -2, coord_y - 1},
                {coord_x +2, coord_y + 1},
                {coord_x +2, coord_y - 1},
                {coord_x -1, coord_y + 2},
                {coord_x +1, coord_y + 2},
                {coord_x -1, coord_y - 2},
                {coord_x +1, coord_y - 2}
        };

        //Filtra las coordenadas que se salieron del tablero, crea las posiciones posibles y
        //las guarda en possibilities
        for(int i = 0; i < pre_possibilities.length; i++){
            int new_coord_x = pre_possibilities[i][0];
            int new_coord_y = pre_possibilities[i][1];
            if((new_coord_x > 0 && new_coord_x < 9) &&
                (new_coord_y > 0 && new_coord_y < 9)){
                Position new_position = new Position(new_coord_x, new_coord_y);
                possibilities.push(new_position);
            }
        }
    }

    public int getCoord_x() {
        return coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }



    public Stack<Position> getPossibilities() {
        return possibilities;
    }

    public String getString(){
        String  letters[]  =  {"0", "A", "B", "C", "D", "E", "F", "G", "H"};
        String numbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        return letters[coord_x] + numbers[coord_y];
    }

}
