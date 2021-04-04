class Player{
    private String name;
    private boolean isAI;

    private Player(){
	name="Computer";
	isAI=true;
    }
    
    private Player(String n){
	name=n;
	isAI=false;
    }

    public String getName(){
	return name;
    }
}
