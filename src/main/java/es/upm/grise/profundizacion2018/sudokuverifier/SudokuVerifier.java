package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier{

	public static int verify (String candidateSolution) throws InvalidLengthException{
		
		int[] sudoku = new int[81];
 		String[] sudokuString = candidateSolution.split("");
		
		if(sudokuString.length != 81)
			throw new InvalidLengthException();
		
		for(int i=0;sudokuString.length>i;i++){
			int number;
			try{
				number = Integer.parseInt(sudokuString[i]);
			}catch (NumberFormatException name){
				return -1;
			}
			sudoku[i] = number;
		}
		
		for(int n=0;n<3;n++)
			for(int m=0;m<3;m++){
				int[] cuadrante = {sudoku[m*3+n*27],sudoku[m*3+1+n*27],sudoku[m*3+2+n*27],sudoku[m*3+9+n*27],
						sudoku[m*3+10+n*27],sudoku[m*3+11+n*27],sudoku[m*3+18+n*27],sudoku[m*3+19+n*27],sudoku[m*3+20+n*27]};
				
				for(int x=0;x<9;x++){
					System.out.print(cuadrante[x]);
				}
				System.out.println();
				
				for(int x=0;x<9;x++){
					for(int y=1+x;y<9;y++){
						System.out.println(cuadrante[x]+"-"+cuadrante[y]);
						if(cuadrante[x]==cuadrante[y])
							return -2;
					}
				}
			}
		
		for(int col=0;col<9;col++){
			int[] columnas = {sudoku[col],sudoku[col+9*1],sudoku[col+9*2],sudoku[col+9*3],sudoku[col+9*4],
					sudoku[col+9*5],sudoku[col+9*6],sudoku[col+9*7],sudoku[col+9*8]};
			
			for(int n=0;n<9;n++){
				for(int m=1+n;m<9;m++){
					if(columnas[n]==columnas[m])
						return -3;
				}
			}
		}
		
		for(int fil=0;fil<9;fil++){
			int[] columnas = {sudoku[fil*9],sudoku[fil*9+1],sudoku[fil*9+2],sudoku[fil*9+3],sudoku[fil*9+4],
					sudoku[fil*9+5],sudoku[fil*9+6],sudoku[fil*9+7],sudoku[fil*9+8]};
		
			for(int n=0;n<9;n++){
				for(int m=1+n;m<9;m++){
					if(columnas[n]==columnas[m])
						return -4;
				}
			}
		}
		
        return 0;
    }
}

