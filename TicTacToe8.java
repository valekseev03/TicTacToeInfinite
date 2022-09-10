import java.util.Scanner;
 
/*
To play compile this in a java compiler (preferably eclipse) and run. This is a tic tic toe game that can have a 150 by 150 board (not infinite but more than most people need), you can play with an "AI" or another player. Use the console to play.
 
Sorry for any spaghetti code this was made in my sophomore year of high school, so feel free to modify it. Also feel free to view any other projects I made.
*/
 
public class TicTacToe8 {
    public TicTacToe8() {
        
    }
    
    private String winx = "xxx";
    private String wino = "ooo";
    private int boardsize = 3;
    
    private String[][] board = new String[][] {};
    
    private String player = "x";
    
    public String[][] setupBoard(int l, int numtowin){
    
    board = new String[l][l];
    for(int i =0; i < l; i++ ) {
        for(int j = 0; j < l; j++) {
        board[i][j] = "_";  
        }
    }
    
    boardsize = l;
    winx = "";
    wino = "";
    
    for(int p = 0; p < numtowin; p++) {
    winx += "x";
    wino+= "o";
    }
            
        
        
    return board;   
    }
    
    public void placePiece(int X, int Y){
    player = "x";
    if(board[X][Y] != "x" & board[X][Y] != "o") {
        board[X][Y] = player;   
        }
 
    
    }
    
    public void placePiece2(int X, int Y){
    player = "o";   
        if(board[X][Y] != "x" & board[X][Y] != "o") {
            board[X][Y] = player;   
            }
        
        }
    
    public String showBoard() {
    String r = "";
    
    for(int i =0; i < boardsize; i++) { 
        for(int j = 0; j < boardsize; j ++) {
        r+= board[i][j] + " ";  
        }
        r += "\n";
    }
    return r;
}
    
    
public boolean detectWin() {
    boolean b = false;
    String s = "";
    
    for(int i = 0; i < boardsize; i++) {
        for(int j = 0; j < boardsize; j++) {
        s+= board[i][j];
        }
        
        if(s.contains(winx) || s.contains("ooo")) {
        b = true;   
        }else {
        s = ""; 
        }   
    }
 
    for(int a = 0; a < boardsize; a++) {
        for(int j = 0; j < boardsize; j++) {
        s+= board[j][a];
        }
        
        if(s.contains(winx) || s.contains(wino)) {
            b = true;   
            }else {
            s = ""; 
        }
    }
    
    
    //Diagonal
    
for(int i = 0; i < (boardsize - 3) + 1; i++) {  
    for(int a = 0; a < boardsize; a++) {
        if(a + i < boardsize) {
        s+= board[a + i][a];
        }
    }
    
    
    
    if(s.contains(winx) || s.contains(wino)) {
        b = true;   
        }else {
        s = ""; 
    }
 
    int h = 0;
    
    for(int a = 0; a < boardsize; a++) {
        if(a < boardsize & 1 + a + i  < boardsize) {
        s+= board[a][1 + a + i];
        }
    }
    
    
    
    if(s.contains(winx) || s.contains(wino)) {
        b = true;   
        }else {
        s = ""; 
    }
 
    
    h = 0;
    
    for(int a = boardsize - 1; a > 0; a--) {
        if(h + i < boardsize & a - 1 + i < boardsize) { 
        s+= board[a - 1 + i][h + i];
        h++;
        }
    }
    
 
    
    if(s.contains(winx) || s.contains(wino)) {
        b = true;   
        }else {
        s = ""; 
    }
}   
    
    return b;
    }
 
public String[][] placePieceCom(){
int X = (int)(Math.random() * boardsize);
int Y = (int)(Math.random() * boardsize);
player = "o";
 
 
 
if(board[X][Y] != "x" & board[X][Y] != "o") {
    board[X][Y] = player;   
    }else {
    while(board[X][Y] == "x" || board[X][Y] == "o") {
        X = (int)(Math.random() * boardsize);
        Y = (int)(Math.random() * boardsize);   
    }
    board[X][Y] = player;
    }
 
        
    
return board;   
}
 
public static void main(String[] args) {
    TicTacToe8 tic = new TicTacToe8();
    int size;
    
    Scanner scan = new Scanner(System.in);
    int i = 0;
    int j = 0;
    boolean sing = false;
    String s= "";
    int player = 1;
    
     
     
    System.out.println("Do You Want To Play Singleplayer or Multiplayer");
    s = scan.next();
    
    if(s.contains("ultiplayer")) {
    sing = true;    
    }else {
    sing = false;   
    }
    
    System.out.println("Time To Set Up The Game!");
    System.out.println("How Big Do You Want It To Be? (max 150 by 150)");
    i = scan.nextInt();
    if(i > 10) {
    System.out.println("Are You Sure You Want This To Be That Big? (It Can Be Un-fun That Way)");
    s = scan.next();
    if(s.contains("es")) {
        
    }else {
    System.out.println("How Big Do You Want It To Be? (max 10 by 10)");
    i = scan.nextInt(); 
    if(i > 10 || i < 3) {
        while(i > 10 || i < 3) {
        System.out.println("Invalid Amount! Try Again!");
        System.out.println("How Big Do You Want It To Be? (max 10 by 10)");
        i = scan.nextInt(); 
        }
        }
    }
    
    }
    if(i > 150 || i < 3) {
    while(i > 150 || i < 3) {
    System.out.println("Invalid Amount! Try Again!");
    System.out.println("How Big Do You Want It To Be? (max 150 by 150)");
    i = scan.nextInt(); 
    }
    }
    System.out.println("How Many Pieces Should It Be To Win? (min 3)");
    j = scan.nextInt();
    if(j > i || j < 3) {
    while(j > i || j < 3) {
        System.out.println("Invalid Size! Try Again!");
        System.out.println("How Many Pieces Should It Be To Win? (y to win)");
        j = scan.nextInt();
        }
    }
    size = i;
    tic.setupBoard(i, j);
    System.out.println(tic.showBoard());
    System.out.println("");
    
if(sing == true) {
    while(tic.detectWin() == false) {
    System.out.println("Your Turn Player #" + player);
    System.out.println("Give X Coordinates (1 - x)");
    i = scan.nextInt() - 1;
    System.out.println("Give Y Coordinates (1 - x)");       
    j = scan.nextInt() - 1;
    if(player == 1) {
    tic.placePiece(i, j);   
    }else {
    tic.placePiece2(i, j);  
    }
    System.out.println(tic.showBoard());
    System.out.println("");
    
    if(player == 1) {
    player++;   
    }else {
    player--;   
    }   
}
    
}else {
    while(tic.detectWin() == false) {
        if(player == 1) {
            System.out.println("Your Turn Player #" + player);
            System.out.println("Give X Coordinates (1 - " + size +")");
            i = scan.nextInt() - 1;
            System.out.println("Give Y Coordinates (1 - " + size + ")");        
            j = scan.nextInt() - 1; 
        tic.placePiece(i, j);   
        }else {
        System.out.println("Your Turn Player #" + player + " (computer)");
        tic.placePieceCom();    
        }
        System.out.println(tic.showBoard());
        System.out.println("");
        
        if(player == 1) {
        player++;   
        }else {
        player--;   
        }   
    }   
}
    player--;
    if(player==0) {
    player = 2; 
    }
    System.out.println("You Win: Player #" + player + "!"); 
    scan.close();
    }   
 
}