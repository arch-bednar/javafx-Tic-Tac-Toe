import javafx.scene.layout.Pane;
import javafx.scene.text.*;

class Engine{
    
    private String [][] fields = new String[3][3];

    Engine(){
	for (int col=3; col<3; col++){
	    for (int row=3; row<3; row++){
		fields[col][row] = " ";
	    }
	}
    }

    public void changeValue(String chr, String loc, int whosTurn){
	if(chr.equals(" ")){
	    if(whosTurn==1)
		for(int i=0; i<3; i++){
		    for(int j=0; j<3; j++){
			String valLoc = (String)(String.valueOf(i)+","+String.valueOf(j));
			if(valLoc.equals(loc)){
			    fields[i][j]=chr;
			}
		    }
		}
	    
	    else if(whosTurn==2)
		for(int i=0; i<3; i++){
		    for(int j=0; j<3; j++){
			String valLoc = (String.valueOf(i)+","+String.valueOf(j));
			if(valLoc.equals(loc)){
			    fields[i][j]=chr;
			}
		    }
		}
	}
    }

    public boolean diagonal(){
	if(fields[1][1].equals("X") || fields[1][1].equals("O")){
	    if(fields[1][1]==fields[0][0] && fields[1][1]==fields[2][2])
		return true;
	    else if(fields[1][1]==fields[0][2] && fields[1][1]==fields[2][0])
		return true;
	}
	return false;
    }

    public boolean vonNeumann(){
	for(int col=0; col<fields.length; col++){
	    for(int row=0; row<fields.length; row++){
		int count=0;

		for(int colT=col-1; colT<col+1; colT++){
		    if(colT<0 || colT>fields.length || colT==col)
			continue;
		    if(fields[col][row]==fields[colT][row] && (fields[col][row].equals("X") || fields[col][row].equals("O")))
			count=count+1;

		}

		if(count==2)
		    return true;

		count=0;
		for(int rowT=row-1; rowT<row+1; rowT++){
		    if (rowT<0 || rowT>fields.length || rowT==row)
			continue;
		    if (fields[col][row]==fields[col][rowT] && (fields[col][row].equals("X") || fields[col][row].equals("O")))
			count++;
		}

		if(count==2)
		    return true;
		
	    }
	}
	return false;
    }
}
