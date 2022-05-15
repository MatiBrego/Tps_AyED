public class main {

    public static void main(String[]args){
        String str = "2 1 Barcelona 1 Madrid 1 Barcelona Madrid";
        String[] newStr = str.split(" ");
        for(int i= 2; i< 2 + Integer.parseInt(newStr[0]); i= i+2) {
            Team new_team = new Team(newStr[i], Integer.parseInt(newStr[i+1]));
        }


    }
}
