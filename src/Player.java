class Player{
    private String name;
    private boolean isAI;

    Player(){
	name="Computer";
	isAI=true;
    }
    
    Player(String n){
	name=n;
	isAI=false;
    }

    public String getName(){
	return name;
    }
}
